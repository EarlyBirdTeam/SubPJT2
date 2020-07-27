<template >
    <div class="" id="board" @click="test2">
        <div>
            <button @click="createText">Text</button>
            <button @click="createScheduler">Scheduler</button>
            <button @click="createCanvas">Canvas</button>
        </div>

        <div class="container" ref="whiteBoard">

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

              <div  class="moveable" @dblclick="dblclickEv"   @click="clickEv"
                ref="contentTextArea" readonly="readonly"
                name="" id="asdfasdf"
                draggable="false"
               >
                it's Post it!
                </div>
            <div class="moveable" style="left: -1px; top: 0px;" @click="clickEv" >
              <div @dblclick="dblclickEv" 
                ref="contentTextArea" readonly="readonly"
                name="" id="asdfasdf"
                draggable="false"
                style="position: absolute; ; width: 400px; text-align: center;text-align: center; transform: translate(166px, 113px) rotate(0deg) scale(1, 1);">
                22
                </div>
            </div>

            <div class="moveable" style="left: -1px; top: 0px;" @click="clickEv" >
              <div @dblclick="dblclickEv" 
                ref="contentTextArea" readonly="readonly"
                name="" id="asdfasdf"
                draggable="false"
                style="position: absolute; ; width: 400px; text-align: center;text-align: center; transform: translate(166px, 113px) rotate(0deg) scale(1, 1);">
                33
                </div>
            </div>

            <Moveable
        v-for="(a, idx) in counter.textC"
        :key="idx"
        class="moveable"
        v-bind="moveable"
        @drag="handleDrag"
        @resize="handleResize"
        @scale="handleScale"
        @rotate="handleRotate"
        @warp="handleWarp"
      >
        <textarea @dblclick="clickEv" ref="contentTextArea" name id="asdfasdf" cols="30" rows="3">
                asdfa
            </textarea>
      </Moveable>

      <Moveable
        v-for="(a, idx) in counter.schedulerC"
        :key="idx"
        class="moveable2"
        v-bind="moveable"
        @drag="handleDrag"
        @click="lining"
        @resize="handleResize"
        @scale="handleScale"
        @rotate="handleRotate"
        @warp="handleWarp"
      >
        <Scheduler />
      </Moveable>

      <Moveable
        v-for="(a, idx) in counter.canvasC"
        :key="idx"
        class="moveable3"
        v-bind="moveable"
        @drag="handleDrag"
        @click="lining"
        @resize="handleResize"
        @scale="handleScale"
        @rotate="handleRotate"
        @warp="handleWarp"
      >
        <Canvas/>
      </Moveable>


        </div>

    </div>
</template>

<script>
import Scheduler from "../../components/common/Scheduler";
import Canvas from "../../components/common/Canvas";
import Moveable from 'vue-moveable';

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
    },
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
    dblclickEv({ target, transform }){
        console.log('dblclick!')
        console.log(target.innerHTML);
        target.focus();
    },
    clickEv({ target, transform, currentTarget }){
        this.$refs.moveable.moveable.target = target;
        console.log(this.$refs.moveable.moveable.style);
    },
    test(){


    },
    test2(){
      console.log("click body!");
      console.log(this.$refs.moveable.moveable); 
      // this.$refs.moveable.moveable.display = none;
        // this.$refs.moveable.moveable.target = null
    },

    createText() {
      this.counter.textC.push(0);
    },
    createScheduler() {
      this.counter.schedulerC.push(0);
    },
    createCanvas() {
      this.counter.canvasC.push(0);
    },
  },
  
}
</script>

<style>
.moveable {
  font-family: "Roboto", sans-serif;
  position: relative;
  width: 300px;
  text-align: center;
  font-size: 40px;
  margin: 0 auto;
  font-weight: 100;
  letter-spacing: 1px;
}

.moveable2 {
  font-family: "Roboto", sans-serif;
  position: relative;
  width: 800px;
  height: 600px;
  text-align: center;
  font-size: 40px;
  margin: 0 auto;
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

.container {
  position: relative;
  height: 500px;
  width: 80vw;
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
  background-color: yellow;
}

#board button {
  border: 1px solid black;
  border-radius: 5px;
  margin-right: 5px;
}

.moveable-control-box{
    display:none;
  }
</style>