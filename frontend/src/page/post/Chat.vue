<template>
  <div class="container">
    <h3>착한 말 고운말 ^^</h3>
    <form class="form-inline">
      <div class="form-group">
        <label for="msgForm">Message:</label>
        <input type="text" placeholder="메시지를 입력해주세요 :)" class="form-control" id="msgForm"/>
      </div>
      <button class="btn btn-primary" @click="sendMessage()">작성</button>
    </form>
    <div id="chatLogs"></div>
  </div>
</template>
<script>
export default {
    name: 'Chat',
    created() {
        // this.$socket.on('chat', (data)=> {
        //     this.textarea += data.message + "\n"
        //     })

        this.$socket.emit("login", {
            name: "Dongryul",
            userid: "ungmo2@gmail.com"
        });

        this.$socket.on("login", (data)=> {
            $("#chatLogs").append("<div><strong>" + data + "</strong>님이 입장하셨습니다</div>");
        });

        this.$socket.on("s2c chat", (data)=> {
            $("#chatLogs").append("<div>" + data.from.name + " : " + data.msg + "</div>");
        });
        },
    data() {
        return {
            textarea: "", message: '',
            }
        },
    methods: {
        sendMessage () {
            event.preventDefault();
            var $msgForm = $("#msgForm");

            // 서버로 메시지를 전송한다.
            this.$socket.emit("chat", { msg: $msgForm.val() });
            $msgForm.val("");
            }
        }
    }

</script>

<style>
</style>