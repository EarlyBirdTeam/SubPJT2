<template >
  <div id="board" @click="test2">
    <div>
      <h2>공유 보드</h2>
      <div class="add_modules border rounded">
        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <v-btn @click="createText" v-bind="attrs" v-on="on">
              <v-icon>mdi-format-text</v-icon>
            </v-btn>
          </template>
          <span>Add Textarea</span>
        </v-tooltip>
        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <v-btn @click="createScheduler" v-bind="attrs" v-on="on">
              <v-icon>mdi-calendar</v-icon>
            </v-btn>
          </template>
          <span>Add Calendar</span>
        </v-tooltip>              
        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <v-btn @click="createCanvas" v-bind="attrs" v-on="on">
              <v-icon>mdi-draw</v-icon>
            </v-btn>
          </template>
          <span>Add Drawing Tool</span>
        </v-tooltip>
        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <v-btn v-bind="attrs" v-on="on">
              <v-icon>mdi-map</v-icon>
            </v-btn>
          </template>
          <span>Add Map</span>
        </v-tooltip>
        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <v-btn v-bind="attrs" v-on="on">
              <v-icon>mdi-vote</v-icon>
            </v-btn>
          </template>
          <span>Add Map</span>
        </v-tooltip>
        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <v-btn v-bind="attrs" v-on="on">
              <v-icon>mdi-account</v-icon>
            </v-btn>
          </template>
          <span>Add Members</span>
        </v-tooltip>
      </div>
      <div id="board" class="board border rounded">
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
                  asdfasdf
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
          <Canvas />
        </Moveable>
      </div>
    </div>
  </div>
</template>

<script>
import Scheduler from "../../components/common/Scheduler";
import Canvas from "../../components/common/Canvas";
import Moveable from "vue-moveable";

const pI = `<div  class="moveable" @dblclick="dblclickEv"   @click="clickEv"
                ref="contentTextArea" readonly="readonly"
                name="" id="asdfasdf"
                draggable="false"
               >
                it's Post it!
                </div>`;

export default {
  name: "app",
  components: {
    Moveable,
    Scheduler,
    Canvas,
  },
  created() {},
  data: () => ({
    moveable: {
      target: "",
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
    dblclickEv({ target, transform }) {
      console.log("dblclick!");
      console.log(target.innerHTML);
      target.focus();
    },
    clickEv({ target, transform, currentTarget }) {
      this.$refs.moveable.moveable.target = target;
      console.log(this.$refs.moveable.moveable.style);
    },
    test() {},
    test2() {
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
};
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

.moveable-control-box {
  display: none;
}

.whiteboard {
  border: 3px solid rgba(0, 0, 0, 0.5);
  margin-top: 5px;
  height: 800px;

}
</style>