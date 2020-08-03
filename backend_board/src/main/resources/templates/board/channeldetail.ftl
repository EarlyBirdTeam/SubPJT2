<!doctype html>
<html lang="en">
  <head>
    <title>Websocket ChatRoom</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/webjars/bootstrap/4.3.1/dist/css/bootstrap.min.css">
    <style>
      [v-cloak] {
          display: none;
      }
    </style>
  </head>
  <body>
    <div class="container" id="app" v-cloak>
        <div class="row">
            <div class="col-md-6">
                <h4>{{channelName}} <span class="badge badge-info badge-pill">{{userCount}}</span></h4>
            </div>
            <div class="col-md-6 text-right">
                <a class="btn btn-primary btn-sm" href="/logout">로그아웃</a>
                <a class="btn btn-info btn-sm" href="/board/channel">채널 나가기</a>
            </div>
        </div>
        <div class="input-group">
            <div class="input-group-prepend">
                <label class="input-group-text">내용</label>
            </div>
            <input type="text" class="form-control" v-model="postit" v-on:keypress.enter="sendMessage('TALK')">
            <div class="input-group-append">
                <button class="btn btn-primary" type="button" @click="sendMessage('TALK')">보내기</button>
            </div>
        </div>
        <ul class="list-group">
            <li class="list-group-item" v-for="postit in postitList">
                {{postit.postitList}}</a>
            </li>
        </ul>
    </div>
    <!-- JavaScript -->
    <script src="/webjars/vue/2.5.16/dist/vue.min.js"></script>
    <script src="/webjars/axios/0.17.1/dist/axios.min.js"></script>
    <script src="/webjars/sockjs-client/1.1.2/sockjs.min.js"></script>
    <script src="/webjars/stomp-websocket/2.3.3-1/stomp.min.js"></script>
    <script>
        // websocket & stomp initialize
        var sock = new SockJS("/ws-stomp");
        var ws = Stomp.over(sock);
        // vue.js
        var vm = new Vue({
            el: '#app',
            data: {
                channelId: '',
                channelName: '',
                sender: '',
                postit: '',
                postitList: [],
                board:'',
                boards: [],
                token: '',
                userCount: 0
            },
            created() {
                this.channelId = localStorage.getItem('wsboard.channelId');
                this.channelName = localStorage.getItem('wsboard.channelName');
                var _this = this;
                axios.get('/board/user').then(response => {
                    _this.token = response.data.token;
                    ws.connect({"token":_this.token}, function(frame) {
                        ws.subscribe("/sub/board/channel/"+_this.channelId, function(message) {
                            var recv = JSON.parse(message.body);
                            _this.recvMessage(recv);
                        });
                    }, function(error) {
                        alert("서버 연결에 실패 하였습니다. 다시 접속해 주십시요.");
                        location.href="/board/channel";
                    });
                });
            },
            methods: {
                sendMessage: function(type) {
                    ws.send("/pub/board/message", {"token":this.token}, JSON.stringify({channelId:this.channelId, postitList:this.postitList}));
                    this.postit = '';
                },
                recvMessage: function(recv) {
                    this.userCount = recv.userCount;
                    this.postitList.unshift({"sender":recv.sender,"postitList":recv.postitList})
                }
            }
        });
    </script>
  </body>
</html>