<template>
  <div id="gg">
    Hello! This is Canvas Test Page.
    <button @click="clicked">button</button>
  </div>
</template>

<script src="https://www.webrtc-experiment.com/Canvas-Designer/canvas-designer-widget.js"></script>
<script>
var designer = new CanvasDesigner();
export default {
  
  created() {
    designer.widgetHtmlURL =
      "https://www.webrtc-experiment.com/Canvas-Designer/widget.html"; // you can place this file anywhere
    designer.widgetJsURL =
      "https://www.webrtc-experiment.com/Canvas-Designer/widget.js";
  },
  methods: {
    clicked() {
      let a = document.getElementById('gg');
      console.log(a);
      a.style.background = 'red';
      designer.appendTo(a);
    }
  }
}
</script>

<style>

</style>