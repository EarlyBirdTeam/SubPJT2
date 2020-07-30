<template >
    <div class="" id="board" @click="test2">
      <!-- <v-btn @click="connect">connect</v-btn> -->


        <div class="bodyBox" ref="whiteBoard">

          <Moveable
          ref="moveable"
          class="moveable"
          v-bind="moveable"
          @drag="handleDrag"
          @resize="handleResize"
          @scale="handleScale"
          @rotate="handleRotate"
          @warp="handleWarp"
          style="display: none;"
          >
          </Moveable> 

          <!-- 도구상자 -->
          <v-toolbar class=" toolBox" @dblclick="changeTargetAction" >
            <v-btn icon color="orange" @click="createText">
              <v-icon>mdi-message</v-icon>
            </v-btn>
            <v-btn icon color="orange" @click="createScheduler">
              <v-icon>mdi-book</v-icon>
            </v-btn>
            <v-btn icon color="orange" @click="createCanvas">
              <v-icon>mdi-palette</v-icon>
            </v-btn>

            <v-btn icon color="red" @click="createPoll">
              <v-icon>mdi-palette</v-icon>
            </v-btn>
          </v-toolbar>

          {{ this.board }}

          <!-- <Postit @dblclick="focusAction"
          @click="changeTargetAction"
          v-for="(a, idx) in counter.textC"
          :key="idx"/> -->

          <textarea @dblclick="focusAction"
          @click="changeTargetAction"
          @click.right="deleteTargetAction(idx, $event)"
          v-for="(postit, idx) in board.postits"
          class="moveable"
          :key="idx"
          :id="idx"
          v-model="postit.content"
          ref="contentTextArea"
          placeholder="It's Post it!"
          cols="30" rows="3">
          </textarea>

          <Scheduler @mousedown.stop
          @dblclick="changeTargetAction"
          @click.right="deleteTargetAction"
          v-for="(a, idx) in counter.schedulerC"
          :key="idx"
          class="moveable2" />

          <div @dblclick="focusAction"
          @click="changeTargetAction"
          @click.right="deleteTargetAction"
          v-for="(a, idx) in counter.canvasC"
          :key="idx"
          class="moveable3">
            <Canvas />
          </div>

          <Poll @mousedown.stop
          @dblclick="changeTargetAction"
          v-for="(a, idx) in counter.pollC"
          :key="idx"
          
          />

          <Map 
          @dblclick="focusAction"
          @click="changeTargetAction"
          @click.right="deleteTargetAction"
          v-for="(a, idx) in counter.mapC"
          :key="idx"
          class="moveable2" 
          />
          
        </div>
        
    </div>
</template>


<script>
// import SockJs from 'sockjs';
// import Stomp from 'webstomp-client';
import axios from 'axios';

import Scheduler from "../../components/common/Scheduler";
import Canvas from "../../components/common/Canvas";
import Moveable from 'vue-moveable';
import Postit from '../../components/common/Postit';
import Poll from '../../components/common/Poll';
import Map from '../../components/common/Map';

const pI = `<div  class="moveable" @dblclick="dblclickEv"   @click="clickEv"
                ref="contentTextArea" readonly="readonly"
                name="" id="asdfasdf"
                draggable="false"
               >
                it's Post it!
                </div>`


export default {
  name: "app",
  components: {
    Moveable,
    Scheduler,
    Canvas,
    Postit,
    Poll,
    Map,
  },
  created() { 
    console.log(document.querySelector('.moveable-control-box'));
    // 우클릭 기본이벤트 차단
    window.oncontextmenu = function() {
      return false;
    };
  },
  data: () => ({
    moveable: {
      target: '',
      draggable: true,
      throttleDrag: 1,
      resizable: false,
      throttleResize: 1,
      keepRatio: false,
      scalable: true,
      throttleScale: 0,
      rotatable: true,
      throttleRotate: 0,
      origin: false,
    },
    text: "",
    counter: {
      textC: [],
      schedulerC: [],
      canvasC: [],
      mapC: [],
      pollC: [],
    },
    board: {
      idCounter: 2, 
      postits: [ { "pId": 0, "title": "title", "content": "0" }, { "pId": 1, "title": "title", "content": "1" } ],
      polls: [],
    },
    channelId: '',
    channelName: '',
    sender: '',
    postit: '',
    postitList: [],
    board:'',
    boards: [],
    token: '',
    userCount: 0
  }),
  methods: {
    handleDrag({ target, left, top }) {
      target.style.left = `${left}px`;
      target.style.top = `${top}px`;
      // console.log(target);
    },
    handleResize({ target, width, height, delta }) {
      console.log("onResize", width, height, delta);
      delta[0] && (target.style.width = `${width}px`);
      delta[1] && (target.style.height = `${height}px`);
    },
    handleScale({ target, transform, scale }) {
      //   console.log('onScale scale', scale);
      target.style.transform = transform;
    },
    handleRotate({ target, dist, transform }) {
      //   console.log('onRotate', dist);
      target.style.transform = transform;
    },
    handleWarp({ target, transform }) {
      //   console.log('onWarp', target);
      target.style.transform = transform;
    },  
    focusAction({ target, transform }){
        target.focus();
    },
    changeTargetAction({target}){
      this.test();
      event.stopPropagation();
      target.blur();
      this.$refs.moveable.moveable.target = target;
    },
    deleteTargetAction(idx ,{target}){
      console.log(idx);
      console.log(target);
      if(confirm("요소를 삭제하시겠습니까?") === true) {
        if(target.getAttribute("class") === "moveable") {
          this.board.postits.splice(idx, 1);
        }
        // target이 뒤에 있는 두 개가 삭제되는 문제가 있다. 
        target.remove();
      }
    },
    test(){
      document.querySelector('.moveable-control-box').style.display = 'block';
    },
    test2(){
      console.log("click body!");
      document.querySelector('.moveable-control-box').style.display = 'none';
    },

    createText(event) {
      event.stopPropagation();
      this.board.postits.push({pId: this.board.idCounter++, title: "title", content: "sample"});
      this.counter.textC.push(0);
    },
    createScheduler() {
      event.stopPropagation();
      this.counter.schedulerC.push(0);
    },
    createCanvas() {
      event.stopPropagation();
      this.counter.canvasC.push(0);
    },
    createPoll() {
      event.stopPropagation();
      this.counter.pollC.push(0);
    },
    createMap() {
      event.stopPropagation();
      this.counter.mapC.push(0);
    },
    sendData() {
      // 서버로 보낼 데이터 구성 (testing)
      const API_URL = ""
      var data = { 
        channel: { 
          channelId: 0, 
          name:"sample-channel", 
          }, 
        board: this.board
        
      }
      
    }
  },
  
}
</script>

<style>
.moveable {
  font-family: "Roboto", sans-serif;
  position: relative;
  width: 300px;
  height: 100px;
  text-align: center;
  font-size: 40px;
  margin: 0 auto;
  font-weight: 100;
  letter-spacing: 1px;
  background-color: yellow;
}

.moveable2 {
  font-family: "Roboto", sans-serif;
  position: relative;
  width: 800px;
  height: 600px;
  text-align: center;
  font-size: 40px;
  margin: 0 0;
  font-weight: 100;
  letter-spacing: 1px;
}

.moveable3 {
  font-family: "Roboto", sans-serif;
  position: relative;
  width: 400px;
  height: 200px;
  text-align: center;
  font-size: 32px;
  margin: 0 auto;
  font-weight: 100;
  letter-spacing: 1px;
}

.moveable span {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  white-space: nowrap;
}

.bodyBox {
  position: relative;
  height: 100%;
  width: 80vw;
  margin: 1% 3%;
  /* transform: translate(-50%, -50%); */
  /* border: solid 1px; */
}

img {
  height: 300px;
  width: 300px;
}

textarea {
  height: 100%;
  width: 100%;
  /* background-color: yellow; */
}

#board button {
  border: 1px solid black;
  border-radius: 5px;
  margin-right: 5px;
}

.moveable-control-box{
    display:none;
  }


.toolBox{
  font-family: "Roboto", sans-serif;
  position: relative;
  width: 400px;
}

  
</style>