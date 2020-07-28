<template>

    <div id="paper" >


        <textarea 
        name="" id="paperTitle"
        cols="30" rows="1"
        >Title</textarea>

        <textarea
        name="" id="paperContent"
        cols="30" rows="5"
        >Content</textarea>
    </div>
</template>

<script>
import image from '../../assets/img/postIt.png'
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
    },
    methods: {
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
  /* height: 10%; */
  height: auto;
  resize:none;
  padding: 20px 20px 1px 20px;
}
#paperContent{
  height: 90%;
  resize:none;
  padding: 20px;
  overflow: hidden;
}
</style>