var app = require('express')();
var server = require('http').createServer(app);
// http server를 socket.io server로 upgrade한다
var io = require('socket.io')(server);


// localhost:3000으로 서버에 접속하면 클라이언트로 index.html을 전송한다
app.get('/', function(req, res) {
    res.sendFile(__dirname + '/index.html');
});

// NameSpace 사용. 경로할당
// Server-side
// var nsp = io.of('/space');
// nsp.on('connection', function(socket){
//     console.log('someone connected');
// });
// nsp.emit('hi', 'everyone!');


// connection event handler
// connection이 수립되면 event handler function의 인자로 socket인 들어온다
io.on('connection', function(socket) {

    // 접속한 클라이언트의 정보가 수신되면
    socket.on('login', function(data) {
        console.log('Client logged-in:\n name: ' + data.name + '\n userid: ' + data.userid);

        // socket에 클라이언트 정보를 저장한다
        socket.name = data.name;
        socket.userid = data.userid;
        //socket.id = data.name;
        console.log('socket.id: '+socket.id);

        // 접속된 모든 클라이언트에게 메시지를 전송한다
        // 'data.userid' has joined 가 index.html 에 출력. emit과 on방식 알기
        io.emit('login', data.name );
    });

    // 클라이언트로부터의 메시지가 수신되면
    socket.on('chat', function(data) {
        console.log('Message from %s, 내용 : %s', socket.name, data.msg);

        var msg = {
            from: {
                name: socket.name,
                userid: socket.userid
            },
            msg: data.msg,
            id: '',
        };

        // 메시지를 전송한 클라이언트를 제외한 모든 클라이언트에게 메시지를 전송한다
        // socket.broadcast.emit('chat', msg);

        // 메시지를 전송한 클라이언트에게만 메시지를 전송한다
        // socket.emit('s2c chat', msg);

        // 접속된 모든 클라이언트에게 메시지를 전송한다
        io.emit('s2c chat', msg);

        // 특정 클라이언트에게만 메시지를 전송한다
        // io.to(id).emit('s2c chat', data);
    });


    // 클라이언트로부터의 메시지가 수신되면
    socket.on('chatto', function(data) {
        console.log('to %s from %s', data.id, socket.name);
        console.log('(귓속말) 내용 : %s', data.msg);
        console.log("socketid : "+socket.id);
        console.log("dataid : "+data.id);

        // socket.join(data.id);  // 상대 socket.id에 내 id를 조인시킴으로써 같은 room 입장. 이 경우 조인 경우가 꼬일 수 있음.

        var msg = {
            from: {
                name: socket.name,
                userid: socket.userid
            },
            msg: data.msg,
            id: data.id,
            myid: socket.id,
            yourname: data.name
        };

        // 메시지를 전송한 클라이언트를 제외한 모든 클라이언트에게 메시지를 전송한다
        // socket.broadcast.emit('chat', msg);

        // 메시지를 전송한 클라이언트에게만 메시지를 전송한다
        socket.emit('s2c chat', msg);

        // 접속된 모든 클라이언트에게 메시지를 전송한다
        // io.emit('s2c chat', msg);

        // 특정 클라이언트에게만 메시지를 전송한다
        io.to(data.id).emit('s2c chat', msg);

    });

    // force client disconnect from server
    socket.on('forceDisconnect', function() {
        socket.disconnect();
    })



    socket.on('disconnect', function(data) {
        console.log(socket.name + "님이 연결을 끓으셨습니다.");
        var msg = {
            from: {
                name: socket.name,
                userid: socket.userid
            },
            msg: data.msg
        };

        io.emit('out', msg);
    });
});





server.listen(3000, function() {
    console.log('Socket IO server listening on port 3000');
});