import Vue from 'vue'
import App from './App.vue'
import router from './router/index'
import vuetify from './plugins/vuetify'
import PostListView from './components/PostListView'
Vue.config.productionTip = false
Vue.component('PostListView',PostListView)

new Vue({
  router,
  vuetify,
  render: h => h(App)
}).$mount('#app')
