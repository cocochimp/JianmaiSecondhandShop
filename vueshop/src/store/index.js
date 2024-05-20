import Vue from "vue";
import Vuex from 'vuex';
Vue.use(Vuex)
//引入小仓库

import user from "./user";
import goods from "./goods";

//创建并且暴露store
export default new Vuex.Store({
   //实现Vuex仓库模块化开发存储数据
   
   modules:{     
       user,
       goods,     
   }
})