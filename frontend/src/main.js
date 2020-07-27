import Vue from 'vue'
import App from './App.vue'
import router from './router'
import axios from 'axios'
import {store} from './store'
import cookies from 'vue-cookie';
import constant from './lib/constants'
import vuetify from './plugins/vuetify';

Vue.prototype.$axios = axios;

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  vuetify,
  template: '<App/>'
})
 