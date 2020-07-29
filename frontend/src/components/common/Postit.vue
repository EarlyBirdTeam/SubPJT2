<template>

    <div id="paper" class="MoveableBox">


        <textarea 
        name="" id="paperTitle"
        class="notMoveBox"
        cols="30" rows="1"
        @click.prevent.self
        >Title</textarea>

        <textarea
        name="" id="paperContent"
        class="notMoveBox"
        cols="30" rows="5"
        >Content</textarea>
    </div>
</template>

<script>
export default {
    data() {
        return {
            poll: {
                question: "",
                answers: [
                    { answer: "" }
                ],
                multipleVotes: false
            },
            title:'',
            content:'',

        };
    }
}
</script>

<style>
#paper{  
  /* background-color: yellow; */
  background-image: url('../../assets/img/postIt.png');
  background-size: 100% 100%;
  width: 300px;
  height: 300px;
  position: relative;
  text-align: center;
  margin: 0 auto;
  font-weight: 100;
  letter-spacing: 1px;
  display: inline-block
}

#paperTitle{
  font-size: 30px;
  min-height: 50px;
  width: 80%;
  height: auto;
  resize:none;
  margin: 20px 20px 1px 20px;
}
#paperContent{
    height: 60%;
    resize: none;
    margin: 20px;
    overflow: hidden;
    width: 80%
}
</style>