import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify'

import VueRouter from 'vue-router'
import routes from './routes'
import store from './store'

Vue.use(VueRouter);
const router=new VueRouter({
  mode: 'history',
  routes,
  scrollBehavior() { 
    return { x: 0, y: 0 } 
  },
})


Vue.config.productionTip = false


new Vue({
  vuetify,
  router,
  store,
  render: h => h(App)
}).$mount('#app')
