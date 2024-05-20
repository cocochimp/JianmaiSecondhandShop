
import { reqIdlegoods} from "@/api/Idle";

const state = { 
    goodsInfo: [],
    ListInfo:[],    
}
const mutations = {
    PUBLISHGOODS(state, data) {
        state.goodsInfo = data;
    },
  
}
const actions = {
  //发布商品
    async publishsuccess({ commit }, {goodsUserId,goodsName,goodsPrice,goodsCategory,goodsImage}) {
        let result = await reqIdlegoods(goodsUserId,goodsName,goodsPrice,goodsCategory,goodsImage);        
        if (result.ok==true) {
            commit('PUBLISHGOODS', result.data);            
            return 'ok';
        } else {
            return Promise.reject(new Error('faile'))
        }
    },
}
//简化数据
const getters = {
    
}

export default {
    state,
    actions,
    mutations,
    getters,
}