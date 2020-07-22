<template ref="outline">
    <div class="post" id="board">
        <button @click="test">Add Button</button>
        <div class="container" ref="whiteBoard">

            <Moveable
            class="moveable"
            v-bind="moveable"
            @drag="handleDrag"
            @resize="handleResize"
            @scale="handleScale"
            @rotate="handleRotate"
            @warp="handleWarp"
            >

            <textarea  @dblclick="clickEv" ref="contentTextArea" name="" id="asdfasdf" cols="30" rows="3">
                asdfa
            </textarea>
            </Moveable>

            <Moveable
            class="moveable"
            v-bind="moveable"
            @drag="handleDrag"
            @click="lining"
            @resize="handleResize"
            @scale="handleScale"
            @rotate="handleRotate"
            @warp="handleWarp"
            >

              <textarea  @dblclick="clickEv" ref="contentTextArea" name="" id="asdfasdf" cols="30" rows="3">
                  1111
              </textarea>
            </Moveable>
            
        </div>
    </div>
</template>

<script>
import Moveable from 'vue-moveable';

const postItDiv = `<div class="moveable"><textarea name="" id="asdfasdf" cols="30" rows="3">  </textarea></div>`
const pI = `<div data-styled-id="rCS53a2i7" data-able-draggable="true" data-able-rotatable="true" data-able-scalable="true" data-able-padding="true" class="moveable-control-box    rCS53a2i7" style="position: absolute; display: block; transform: translate(592px, 197px) translateZ(50px); --zoom:1; --zoompx:1px;"><div class="moveable-line moveable-rotation-line" style="transform: translate(-50%) translate(150px, 0px) rotate(0rad);"><div class="moveable-control moveable-rotation"></div></div><div data-rotation="135" data-direction="nw" class="moveable-control moveable-direction moveable-nw" style="transform: translate(0px, 0px) rotate(0rad);"></div><div data-rotation="45" data-direction="ne" class="moveable-control moveable-direction moveable-ne" style="transform: translate(300px, 0px) rotate(0rad);"></div><div data-rotation="45" data-direction="sw" class="moveable-control moveable-direction moveable-sw" style="transform: translate(0px, 200px) rotate(0rad);"></div><div data-rotation="135" data-direction="se" class="moveable-control moveable-direction moveable-se" style="transform: translate(300px, 200px) rotate(0rad);"></div><div data-rotation="0" data-direction="n" class="moveable-control moveable-direction moveable-n" style="transform: translate(150px, 0px) rotate(0rad);"></div><div data-rotation="90" data-direction="w" class="moveable-control moveable-direction moveable-w" style="transform: translate(0px, 100px) rotate(0rad);"></div><div data-rotation="0" data-direction="s" class="moveable-control moveable-direction moveable-s" style="transform: translate(150px, 200px) rotate(0rad);"></div><div data-rotation="90" data-direction="e" class="moveable-control moveable-direction moveable-e" style="transform: translate(300px, 100px) rotate(0rad);"></div><div data-rotation="-1" data-line-index="0" data-direction="" class="moveable-line moveable-direction " style="transform: translateY(-50%) translate(0px, 0px) rotate(0rad); width: 300px;"></div><div data-rotation="-1" data-line-index="1" data-direction="" class="moveable-line moveable-direction " style="transform: translateY(-50%) translate(300px, 0px) rotate(1.5708rad); width: 200px;"></div><div data-rotation="-1" data-line-index="2" data-direction="" class="moveable-line moveable-direction " style="transform: translateY(-50%) translate(0px, 0px) rotate(1.5708rad); width: 200px;"></div><div data-rotation="-1" data-line-index="3" data-direction="" class="moveable-line moveable-direction " style="transform: translateY(-50%) translate(0px, 200px) rotate(0rad); width: 300px;"></div></div><div data-styled-id="rCS53a2i7" data-able-draggable="true" data-able-rotatable="true" data-able-scalable="true" data-able-padding="true" class="moveable-control-box    rCS53a2i7" style="position: absolute; display: block; transform: translate(592px, 197px) translateZ(50px); --zoom:1; --zoompx:1px;"><div class="moveable-line moveable-rotation-line" style="transform: translate(-50%) translate(150px, 0px) rotate(0rad);"><div class="moveable-control moveable-rotation"></div></div><div data-rotation="135" data-direction="nw" class="moveable-control moveable-direction moveable-nw" style="transform: translate(0px, 0px) rotate(0rad);"></div><div data-rotation="45" data-direction="ne" class="moveable-control moveable-direction moveable-ne" style="transform: translate(300px, 0px) rotate(0rad);"></div><div data-rotation="45" data-direction="sw" class="moveable-control moveable-direction moveable-sw" style="transform: translate(0px, 200px) rotate(0rad);"></div><div data-rotation="135" data-direction="se" class="moveable-control moveable-direction moveable-se" style="transform: translate(300px, 200px) rotate(0rad);"></div><div data-rotation="0" data-direction="n" class="moveable-control moveable-direction moveable-n" style="transform: translate(150px, 0px) rotate(0rad);"></div><div data-rotation="90" data-direction="w" class="moveable-control moveable-direction moveable-w" style="transform: translate(0px, 100px) rotate(0rad);"></div><div data-rotation="0" data-direction="s" class="moveable-control moveable-direction moveable-s" style="transform: translate(150px, 200px) rotate(0rad);"></div><div data-rotation="90" data-direction="e" class="moveable-control moveable-direction moveable-e" style="transform: translate(300px, 100px) rotate(0rad);"></div><div data-rotation="-1" data-line-index="0" data-direction="" class="moveable-line moveable-direction " style="transform: translateY(-50%) translate(0px, 0px) rotate(0rad); width: 300px;"></div><div data-rotation="-1" data-line-index="1" data-direction="" class="moveable-line moveable-direction " style="transform: translateY(-50%) translate(300px, 0px) rotate(1.5708rad); width: 200px;"></div><div data-rotation="-1" data-line-index="2" data-direction="" class="moveable-line moveable-direction " style="transform: translateY(-50%) translate(0px, 0px) rotate(1.5708rad); width: 200px;"></div><div data-rotation="-1" data-line-index="3" data-direction="" class="moveable-line moveable-direction " style="transform: translateY(-50%) translate(0px, 200px) rotate(0rad); width: 300px;"></div></div>`

export default {
  name: 'app',
  components: {
    Moveable,
  },
  data: () => ({
    moveable: {
      draggable: true,
      throttleDrag: 0,
      resizable: false,
      throttleResize: 1,
      keepRatio: true,
      scalable: true,
      throttleScale: 0,
      rotatable: true,
      throttleRotate: 0,
    },
    text: '',
    // imageSourse:{
    //     [
    //         {thumnail: ''}
    //     ]
    // }

  }),
  methods: {
    handleDrag({ target, left, top }) {
    //   console.log('onDrag left, top', left, top);
      target.style.left = `${left}px`;
      target.style.top = `${top}px`;
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
    clickEv({ target, transform }){
        console.log('click!')
        console.log(target.innerHTML);
        target.focus();
    },
    lining({}){
      
    },
    test(){
      this.$refs.outline.innerHTML += pI;
      // console.log(this.$refs.whiteBoard.innerHTML += pI)
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