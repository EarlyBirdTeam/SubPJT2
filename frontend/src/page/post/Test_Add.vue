<template>
  <div id="add">
    Hello, This is Add Test Page<br><br>
    <div>
      <button @click="createText">Text</button>
      <button @click="createScheduler">Scheduler</button>
      <button @click="createCanvas">Canvas</button>
    </div><br>
    <div class="container">
      <Canvas/>Ggg
    </div>
  </div>
</template>

<script>
// import Scheduler from '../../components/common/Scheduler'
import Canvas from '../../components/common/Canvas'

export default {
  name: 'add',
  component: {
    Canvas,
  },
  data() {
    return {
      counter: 0,
    }
  },
  methods: {
    createText() {
      var x = document.createElement("TEXTAREA");
      var t = document.createTextNode("Sample TextArea");
      x.appendChild(t);
      document.getElementById('add').appendChild(x)
    },
    createScheduler() {
      console.log('create SC!');

    },
    createCanvas() {
      console.log('create Canvas!');
     },
  }

}
</script>

<style>
#add button {
  border: 1px solid black;
  border-radius: 5px;
  margin-right: 5px;
}
#add textarea {
  width: 100px;
  height: 100px;
  border: 1px solid black;
}
</style>