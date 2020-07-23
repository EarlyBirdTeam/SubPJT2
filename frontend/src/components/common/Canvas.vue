<template>
  <div id="gg">
    <button @click="clicked">button</button>
  </div>
</template>

<script src="https://www.webrtc-experiment.com/Canvas-Designer/canvas-designer-widget.js"></script>
<script>
var designer = new CanvasDesigner();
export default {
  data() {
    return {
      is_canvas: false
    }
  },
  created() {
    designer.widgetHtmlURL =
      "https://www.webrtc-experiment.com/Canvas-Designer/widget.html"; // you can place this file anywhere
    designer.widgetJsURL =
      "https://www.webrtc-experiment.com/Canvas-Designer/widget.js";
  },
  methods: {
    clicked() {
      if(!this.is_canvas) {
        this.is_canvas = true
        let a = document.getElementById('gg');
        console.log(a);
        a.style.background = 'skyblue';
        designer.appendTo(a);
      }
    }
  }
}
</script>

<style>

</style>