<template >
    <div class="" id="board" @click="test3">



        <div class="bodyBox " ref="whiteBoard" @dblclick="focusAction"
          @click="changeTargetAction"
          @mousedown="test3" @click.right="test4">

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


          <Postit 
          v-for="(a, idx) in counter.textC"
          :key="idx"
          style="position: relative;
                display: inline-block"
          :uid="a"
          :title="board.postits[a].title"
          :content="board.postits[a].content"
          v-on:setTitle="changePITitle"
          v-on:setContent="changePIContent"/>
            
          <Scheduler @mousedown.stop
          @dblclick="changeTargetAction"
          v-for="(a, idx) in counter.schedulerC"
          :key="idx"
          class="moveable2" />

          <div @dblclick="focusAction"
          @click="changeTargetAction"
          v-for="(a, idx) in counter.canvasC"
          :key="idx"
          class="moveable3">
            <Canvas />
          </div>

          <Poll
          v-for="(a, idx) in counter.pollC"
          :key="idx"
          style="position: relative;
                display: inline-block"
          />

        </div>

    </div>
</template>



<script>

import Scheduler from "../../components/common/Scheduler";
import Canvas from "../../components/common/Canvas";
import Moveable from 'vue-moveable';
import Postit from '../../components/common/Postit';
import Poll from '../../components/common/Poll';

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
  },
  created() { 
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
      pollC: [],
    },
    board: {
      idCounter: 0, 
      postits: [],
      polls: [],
    },
    channelId: '',
    channelName: '',
    sender: '',
    postit: '',
    postitList: [],
    token: '',
    userCount: 0,
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

      // if(target.getAttribute('class') != null){
      //   var clas = target.getAttribute('class').split(' ');
      
      //   for(var cla in clas){
      //     // console.log(clas[cla]);
      //     if(clas[cla] == 'notMoveBox'){return;}
      //   }
      // }
      if(target.getAttribute('class') != null){
        var clas = target.getAttribute('class').split(' ');
      
        for(var cla in clas){
          // console.log(clas[cla]);
          if(clas[cla] == 'MoveableBox'){
            event.stopPropagation();
            target.blur();
            this.$refs.moveable.moveable.target = target;
          }
        }
      }


      // event.stopPropagation();
      // target.blur();
      // this.$refs.moveable.moveable.target = target;
    },
    test(){
      document.querySelector('.moveable-control-box').style.display = 'block';
    },
    test2(){
      console.log("click body!");
      document.querySelector('.moveable-control-box').style.display = 'none';
    },
    test3({target}){
      console.log("click target!");
      console.log(target.style.left);
    },
    test4({target}){
      target.style.left = "100px";

    },
    changePITitle: function(value,index){
      console.log("title is changed!",index ,value);
      this.board.postits[index].title = value;
    },
    changePIContent: function(value,index){
      console.log("content is changed!",index ,value);
      this.board.postits[index].content = value;
    },

    createText(event) {
      event.stopPropagation();
      this.counter.textC.push(this.counter.textC.length);
      // this.board.idCounter++;
      this.board.postits.push({
        "pid":this.board.idCounter++,
        "title": "title",
        "content": "content" ,
      });
    },
    createScheduler() {
      event.stopPropagation();
      this.counter.schedulerC.push(this.counter.schedulerC.length);
    },
    createCanvas() {
      event.stopPropagation();
      this.counter.canvasC.push(this.counter.canvasC.length);
    },
    createPoll() {
      event.stopPropagation();
      this.counter.pollC.push(this.counter.pollC.length);
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
  /* background-color: yellow; */
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
  /* position: relative; */
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