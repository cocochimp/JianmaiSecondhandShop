<template>
  <div class="container">
    <el-form ref="form"  label-width="80px" class="from">
      <el-form-item label="用户名" >
        <el-input v-model="form.name" style="width:300px" :placeholder='username'></el-input>
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="form.password" style="width:300px" :placeholder='pwd'></el-input>
      </el-form-item>
      <el-form-item label="头像" >
        <el-input v-model="form.image" style="width:300px" :placeholder='userimage'></el-input>
      </el-form-item>
      <el-button type="danger" style="margin-left:81px;" @click="updateInfo">确认修改</el-button>
    </el-form>   
  </div>
</template>

<script>
import { mapState } from "vuex";
export default {
  name: "UserInfo",
  data() {
    return {
       form:{
        name:'',      
        password:'',
        image:'',
       }
    }
  },
  methods: {
    //用户信息修改
    async updateInfo(){
      const{name,password,image}=this.form;
      if(name==''||password==''||image==''){
        this.$message('修改失败');
        return;        
      }    
      const {userid}=this;
      let result= await this.$API.user.requpdateuser(image,password,name,userid);
      if(result.ok==true){
        this.$message('修改成功');
        this.$router.push('/login')
      }
    }
  },
  computed: {
    //拿到用户id
      ...mapState({
         userid: (state) => state.user.userInfo[0].user_id,
         username: (state) => state.user.userInfo[0].nickname,
         userimage: (state) => state.user.userInfo[0].user_image,
         pwd: (state) => state.user.userInfo[0].user_pwd,
      })
    },
};
</script>

<style  scoped>
.container{
  position: relative;
}
.from{
  position: absolute;
  top:50px;
  left: 50px;
}
</style>