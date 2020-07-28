<template>
  <v-app>
    <v-main>
      <!-- <Header :isHeader="isHeader"/> -->
      <router-view/>
    </v-main>
  </v-app>
</template>

<script>
import './assets/css/style.scss' 
import Header from './components/common/Header.vue'
import constants from './lib/constants' 
import axios from 'axios'

export default {
  name: 'App',
  components: { 
    Header
  },
  created() {
      let url = this.$route.name;

      this.checkUrl(url);
  },
  watch: {
      $route (to){

          this.checkUrl(to.name);
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
          array.map(path => {
              if (url === path)
                  isHeader = false;
          })
          this.isHeader = isHeader;

      },
  },
  data: function () {
        return {
            isHeader: true,
            constants,
        } 
    }
}
</script>
