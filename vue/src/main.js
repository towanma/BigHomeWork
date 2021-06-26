import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

import Element from 'element-ui'
import "element-ui/lib/theme-chalk/index.css"

import axios from 'axios'

Vue.prototype.$axios=axios //设置全局axios 使用$axios用来使用axios库
Vue.config.productionTip = false

require("./mock.js")

Vue.use(Element)
new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
