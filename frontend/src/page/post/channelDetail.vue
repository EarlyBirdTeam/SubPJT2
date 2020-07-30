<template>
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
            <li class="list-group-item" v-for="(postit, idx) in postitList" :key="idx">
                {{postit.postitList}}
            </li>
        </ul>
    </div>
</template>

<script>
import SockJS from 'sockjs-client';
import Stomp from 'stomp-websocket';
import axios from 'axios';
import http from '../../http-common.js';

export default {
  data () {
    return {
      ws: null,
      channelId: '',
      channelName: '',
      sender: '',
      postit: '',
      postitList: [],
      board:'',
      boards: [],
      token: '',
      userCount: 0
    }
  },
  created() {
    this.init();
  },
   methods: {
    init() {
      var BASE_URL =  "http://localhost:8080"
      var sock = new SockJS(BASE_URL + "/ws-stomp");
      var ws = Stomp.over(sock);
      this.ws = ws;

      this.channelId = localStorage.getItem('wsboard.channelId');
      this.channelName = localStorage.getItem('wsboard.channelName');
      var _this = this;
      http.get('/board/user').then(response => {
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
    sendMessage: function(type) {
        this.ws.send("/pub/board/message", {"token":this.token}, JSON.stringify({channelId:this.channelId, postitList:this.postitList}));
        this.postit = '';
    },
    recvMessage: function(recv) {
        this.userCount = recv.userCount;
        this.postitList.unshift({"sender":recv.sender,"postitList":recv.postitList})
    }
  }
}
</script>

<style>

</style>