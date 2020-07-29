<template>
  <v-app>
    <v-main id="bg">
      <Header :isHeader="isHeader"/>
      
      <div v-if="isSidebar"><Sidebar/></div>

      <router-view id="container"/>
    </v-main>
  </v-app>
</template>

<script>
import './assets/css/style.scss' 
import Header from './components/common/Header.vue'
import Sidebar from './components/common/Sidebar'
import CreateModal from './components/CreateModal'
import constants from './lib/constants' 
import axios from 'axios'

export default {
  name: 'App',
  components: { 
    Header,
    CreateModal,
    Sidebar

  },
  created() {
      let url = this.$route.name;

      this.checkUrl(url);
      this.checkSide(url);
  },
  watch: {
      $route (to){

          this.checkUrl(to.name);
          this.checkSide(to.name)
      }
  },
  methods : {
      checkUrl(url) { 

          let array = [
              constants.URL_TYPE.USER.LOGIN,
              constants.URL_TYPE.USER.JOIN,
              constants.URL_TYPE.USER.JOINDONE
          ];

          let isHeader = true;
         
          // array.map(path => {
          //     if (url === path)
          //         isHeader = false;
          //         isSidebar = false;
          // })
          this.isHeader = isHeader;
    

      },
      checkSide(url) {
        let array = [
          "members","test_vue","base","chat"
        ];
        console.log(url)
        let isSidebar = false;
        array.map(path => {
              if (url === path)
              
                  isSidebar = true;
          })
        this.isSidebar = isSidebar;

      }
  },
  data: function () {
        return {
            isHeader: true,
            isSidebar: false,
            constants,
        } 
    }
}
</script>

<style >
  #container{
    /* width: 90vw; */
    float: center;
    /* border: solid gray 1px; */
    background-color: white;
    border-radius: 2%;
    height: 100%;
    text-align: center;
    margin: 2.5vh 2vw;
  }
  #bg{
    background-color: rgba(180, 179, 179, 0.26);
  }
</style>