<template>
  <div style="margin-top:45px ">
    <h3>착한 말 고운말 ^^</h3>
    <form class="form-inline">
      <div class="form-group">
        <label for="msgForm">Message:</label>
        <input type="text" placeholder="메시지를 입력해주세요 :)" class="form-control" id="msgForm" />
      </div>
      <button class="btn btn-primary" @click="sendMessage()">Send</button>
    </form>
    <div id="chatLogs"></div>
  </div>
</template>
<script>
import constants from '../../lib/constants'
export default { 
    name: 'Chat', 
    created() { 
        // this.$store.dispatch(constants.METHODS.GET_USER);
        console.log('하이')
        // this.$socket.on('chat', (data)=> { 
        //     this.textarea += data.message + "\n" 
        //     })
        // this.$router.push('chat')
        this.$socket.emit('forceDisconnect');
        
        
        },
        mounted() {
            
this.$socket.emit("login", {    
            name: this.$store.state.email,
            userid: this.$store.state.email
        });

        this.$socket.on("login", (data)=> {
            $("#chatLogs").append("<div><strong>" + data + "</strong> has joined</div>");
        });

        this.$socket.on("s2c chat", (data)=> {
            $("#chatLogs").append("<div>" + data.from.name + " : " + data.msg + "</div>");
        }); 
        },
         
    data() { 
        return { 
            textarea: "", message: '',
            islogin:false, 
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