<template>
  <div class="container">
    <div class="poll-container">
      <h2>투표 before</h2>
      <hr />
      <div>
        <div class="poll-title">
          <h3>투표 제목</h3>
          <input v-model="poll.question" type="text" placeholder="Your Question..." />
          <hr />
        </div>
        <div class="poll-content">
          <h3>투표 항목</h3>
          <div
            v-for="(answer, index) in poll.answers"
            :key="index"
            class="answer"
            :style="{zIndex: poll.answers.length - index}"
          >
          
            <div class="d-flex">
              <input
                :placeholder="'Answer ' + (index + 1)"
                v-model="poll.answers[index].answer"
                type="text"
              />
              <div class="d-flex" @click="deleteInput(index)">
                <v-icon>mdi-minus-circle-outline</v-icon>
                <h3>삭제</h3>
              </div>
            </div>
          </div>
          <v-btn class="d-flex" @click="createNewInput()">
            <v-icon>mdi-plus-circle-outline</v-icon>
            <h3>항목 추가</h3>
          </v-btn><hr>
        </div>
        <div>
          <v-btn @click="reset">리셋</v-btn>
          <v-btn @click="save">저장</v-btn>
        </div>
      </div>
    </div>
    
    <div>
      {{ this.poll }}
    </div><br><br>

    <div class="poll-container">
       <h2>투표 after</h2>
      <hr />
      <div>
        <div class="poll-title">
          <h3>투표 제목</h3>
          <input v-model="poll.question" type="text" placeholder="Your Question..." />
          <hr />
        </div>
        <div class="poll-content">
          <h3>투표 항목</h3>
          <div
            v-for="(answer, index) in poll.answers"
            :key="index"
            class="answer"
            :style="{zIndex: poll.answers.length - index}"
          >
            <div  @click="voted=index">
              <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios1" value="option1">
              <!-- <label class="form-check-label" for="exampleRadios1">
                {{ answer.answer }}
              </label> -->
              <div v-if="voted === index">
                <h2>{{ answer.answer }}</h2>
              </div>
              <div v-else>
                {{ answer.answer }}
              </div>
            </div>
          </div><hr>
        </div>
        <div>
          <v-btn @click="vote">투표</v-btn>
        </div>
      </div>
    </div> <br><br>


    <div class="poll-container">
       <h2>투표 result</h2>
      <hr />
      <div>
        <div class="poll-title">
          <h3>투표 제목</h3>
          <input v-model="poll.question" type="text" placeholder="Your Question..." />
          <hr />
        </div>
        <div class="poll-content">
          <h3>투표 항목</h3>
          <div
            v-for="(answer, index) in poll.answers"
            :key="index"
            class="answer"
            :style="{zIndex: poll.answers.length - index}"
          >
            <div>
              {{ answer.answer }}
              {{ answer.voted }}
            </div>
          </div>
        </div><hr>
        <div>
          <h3>투표 결과</h3>
          많이 투표된 사람 띄워주기
        </div>
      </div>
    </div> 
  </div>
</template>

<script>
export default {
  data() {
    return {
      poll: {
        question: "프론트 팀장은 누가 좋을까요?",
        answers: [ {answer: "김강현", voted: 0}, {answer: "강현 Kim", voted: 0}],
        multipleVotes: false,
        totalVotes: 0,
        userVoted: [],
      },
      test: [],
      voted: null,
    };
  },
  methods: {
    createNewInput() {
      // if (this.poll.answers.length - 1 === index) {
      //   this.poll.answers.push("");
      // }
      this.poll.answers.push({answer: "", voted: 0});
    },
    deleteInput(index) {
      if (index > 0 || this.poll.answers.length > 1) {
        this.poll.answers.splice(index, 1);
      }
    },
    reset() {
      this.poll = {
        question: "",
        answers: [{answer:"", voted: 0}],
        multipleVotes: false,
      }
    },
    save() {
      //서버로 보내서 투표 저장
    },
    vote() {
      this.poll.answers[this.voted].voted++;
    },
  },
};
</script>

<style>
.poll-container {
  width: 500px;
  border: 2px solid gray;
  border-radius: 5px;
}


.form-check-input {
  width: 20px;
  height: 20px;
  color: black;
}
</style>