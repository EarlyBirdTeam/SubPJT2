<template >
    <div class="" id="board" @click="test2">
        <button @click="test">Add Button</button>
        <div class="container" ref="whiteBoard">
          <component v-bind:is="comps"></component>

            <Moveable
            ref="moveable"
            class="moveable"
            v-bind="moveable"
            @drag="handleDrag"
            @resize="handleResize"
            @scale="handleScale"
            @rotate="handleRotate"
            @warp="handleWarp"
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
        </div>
    </div>
</template>

<script>
import Moveable from 'vue-moveable';

const pI = `<div  class="moveable" @dblclick="dblclickEv"   @click="clickEv"
                ref="contentTextArea" readonly="readonly"
                name="" id="asdfasdf"
                draggable="false"
               >
                it's Post it!
                </div>`


export default {
  name: 'app',
  components: {
    Moveable,
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
    comps: [],
  }),
  methods: {
    handleDrag({ target, left, top, currentTarget, clientX}) {
      target.style.left = `${left}px`;
      target.style.top = `${top}px`;
      console.log(target);
    },
    handleResize({
      target, width, height, delta,
    }) {
      console.log('onResize', width, height , delta);
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
        // console.log('click! : ', target.innerHTML)
        // this.moveable.target = currentTarget
        // console.log(currentTarget);
        // // console.log(this.moveable.target);
        // // target.focus();
        // // target.setAttribute('class', 'target')
        // console.log(this.moveable);
        // console.log(target.style.left + ' and ' + target.style.top);
        // console.log(this.$children[0]);
        this.$refs.moveable.moveable.target = target
        
        console.log(target);
      console.log(this.$refs.moveable.moveable.target);
    },
    lining({}){
      
    },
    test(){
      this.comps.push(pI);
    },
    test2(){
      // console.log(this.$refs.moveable);
    },
    showSomeData(){

    }
  },
  
}
</script>

<style>
.moveable {
  font-family: "Roboto", sans-serif;
  position: relative;
  width: 300px;
  height: 200px;
  text-align: center;
  font-size: 40px;
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
  border: solid 1px;
}

img{
    height: 300px;
    width: 300px;
}

textarea {
    height: 100%;
    width: 100%;
    background-color: yellow;
}
</style>