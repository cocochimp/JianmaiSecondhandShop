import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
Vue.config.productionTip = false
Vue.use(ElementUI)
//引入路由
import router from '@/router';

//引入仓库
import store from '@/store';
import API from '@/api'
Vue.prototype.$API=API;
new Vue({
  render: h => h(App),
  beforeCreate(){
    Vue.prototype.$bus=this;
    Vue.prototype.$API=API;},
  router,
  store,
}).$mount('#app')
