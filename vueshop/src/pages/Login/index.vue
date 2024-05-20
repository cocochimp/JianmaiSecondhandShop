<template>
  <div class="container">
    <div class="login-container">
    <!-- 登录 -->
    <div class="login">
      <h3 style="text-align:center; background-color: skyblue ">登录</h3>
      <div class="content">
        <input type="text" placeholder="用户名" v-model="nickName" />
      </div>
      <div class="content">
        <input type="text" placeholder="请输入密码" v-model="userPwd" />
      </div>
      <div class="setting">
        <label>
          <input name="m1" type="checkbox" />
          自动登录
        </label>
        <span>忘记密码？</span>
      </div>
      <button class="btn" @click="userLogin">登&nbsp;&nbsp;录</button>
    </div>
  </div>
  </div>
</template>

<script>
export default {
  name: "loginVue",
  data() {
    return {
      nickName: "",
      userPwd: "",
    };
  },
  methods: {
   async userLogin() {
     try {
       const { nickName, userPwd } = this;
        await this.$store.dispatch('userLogin',{ nickName, userPwd});
        this.$message('登录成功');
        this.$router.push('/home');
     } catch (error) {
       this.$message('登录失败')
     }
      // const { nickName, userPwd } = this;
      // let result = await this.$API.user.reqLogin(nickName,userPwd);
      // if(result.ok==true){
      //   this.$message('登录成功');
      //   this.$router.push('/home');
      // }else{
      //   this.$message('登录失败')       
      // }
    },
  },
};
</script>

<style  scoped>

 
.login-container{
  margin-top: 100px;
  background:-webkit-linear-gradient(left,rgba(123, 162, 193,.2),rgba(220, 128, 221, 0.3));
}
.content {
  padding-left: 440px;
  margin-bottom: 18px;
  position: relative;
  margin-top: 20px;
}
.login {
  width: 1200px;
  height: 445px;
  border: 1px solid rgb(51, 134, 151);
  margin: 0 auto;
  background:-webkit-linear-gradient(left,rgba(87, 124, 155, 0.2),rgb(121, 191, 231));
  background:url('@/utils/01.webp') no-repeat ;
  background-size: 100%;
}
h3 {
  background: #ececec;
  margin: 0;
  padding: 6px 15px;
  color: #333;
  font-size: 20.04px;
  line-height: 30.06px;
}
input {
  width: 270px;
  height: 38px;
  padding-left: 8px;
  box-sizing: border-box;
  margin-left: 5px;
  outline: none;
  border: 1px solid #999;
}
.btn {
  line-height: 36px;
  margin: 17px 0 0 450px;
  outline:none;
  border: none;
  width: 150px;
  height: 36px;
  background: #e45f58;
  color: #fff !important;
  display: inline-block;
  font-size: 16px;
}
.setting {
  text-align: center;
  margin: 0 130px 0 0;
}
.setting input {
  vertical-align: middle;
  height: 20px;
  width: 40px;
}
</style>