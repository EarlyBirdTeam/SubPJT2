<template ref="outline">
    <div class="" id="board">
        <button @click="test">Add Button</button>
        <div class="container" ref="whiteBoard">
          <component v-bind:is="comps"></component>

          

            <!-- <Moveable
            ref="moveable"
            class="moveable"
            v-bind="moveable"
            @drag="handleDrag"
            @resize="handleResize"
            @scale="handleScale"
            @rotate="handleRotate"
            @warp="handleWarp"
            >
                <div @click="clickEv" @dblclick="dblclickEv" 
            readonly="readonly"
              name="" id="asdfasdf"
              style="position: absolute; ; width: 400px; text-align: center;text-align: center; transform: translate(166px, 113px) rotate(0deg) scale(1, 1);">
              
              this is inner
              </div>
            </Moveable> -->
              <div @click="clickEv" @dblclick="dblclickEv" 
              ref="contentTextArea" readonly="readonly"
              name="" id="asdfasdf"
              draggable="false"
              style="position: absolute; ; width: 400px; text-align: center;text-align: center; transform: translate(166px, 113px) rotate(0deg) scale(1, 1);">
              11
              </div>
              
        </div>
    </div>
</template>

<script>
import Moveable from 'vue-moveable';

const postItDiv = `<div class="moveable" style="left: 365px; top: 113px;"><textarea name="" id="asdfasdf" cols="30" rows="3"> asdfa </textarea></div>`
const pI = `<div 
            style="position: absolute; width: 200px; height: 200px; background-color: yellow;">
            <textarea name="" id="" cols="30" rows="10"></textarea>
          </div>`


export default {
  name: 'app',
  components: {
    Moveable,
  },
  created() {
    
      // this.comps.push('Moveable');
        console.log(this.moveable);
  },
  data: () => ({
    moveable: {
      target: '',
      draggable: true,
      throttleDrag: 1,
      resizable: true,
      throttleResize: 1,
      keepRatio: false,
      scalable: false,
      throttleScale: 0,
      rotatable: true,
      throttleRotate: 0,
      origin: false,
    },
    comps: [],
    // imageSourse:{
    //     [
    //         {thumnail: ''}
    //     ]
    // }

  }),
  methods: {
    handleDrag({ target, left, top, currentTarget, clientX}) {
    //   console.log('onDrag left, top', left, top);
      target.style.left = `${left}px`;
      target.style.top = `${top}px`;
      // console.log("getRect: ", this.$refs.moveable.getRect())
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
        console.log('click! : ', target.innerHTML)
        this.moveable.target = currentTarget
        console.log(currentTarget);
        // console.log(this.moveable.target);
        // target.focus();
        // target.setAttribute('class', 'target')
        console.log(this.moveable);
        console.log(target.style.left + ' and ' + target.style.top);
        console.log(this.$children[0]);
    },
    lining({}){
      
    },
    test(){
      this.comps.push(pI);
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