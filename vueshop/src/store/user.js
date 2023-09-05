//登录模块
import { reqLogin} from "@/api/user";

const state = { 
    userInfo: [], 
    nickName:'',
}
const mutations = {
    USERLOGIN(state, data) {
        state.userInfo = data;
        state.nickName=data[0].nickname;
    },
  
}
const actions = {
  
    //登录业务
    async userLogin({ commit }, {nickName,userPwd}) {
        let result = await reqLogin(nickName,userPwd);
        //服务器下发token,用户唯一标识符
        //将未经常通过带token找服务器要用户信息进行展示
        if (result.ok==true) {
            commit('USERLOGIN', result.data);            
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