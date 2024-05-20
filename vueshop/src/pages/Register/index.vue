<template>
  <div class="register-container">
    <!-- 注册内容 -->
    <div class="register">
      <h3>
        注册新用户
        <span class="go"
          >我有账号，去 <router-link to="/login">登录</router-link>
        </span>
      </h3>
      
      <div class="content">
        <label>用户名:</label>
        <input placeholder="请输入你的用户名" v-model="nickName" name="nickName" />
      </div>
      <div class="content">
        <label>登录密码:</label>
        <input
          placeholder="请输入你的密码"
          v-model="userPwd"
          name="userPwd"
        />
      </div>
       <div class="content">
        <label>用户头像地址:</label>
        <input placeholder="请输入你的用户头像地址" v-model="userImage" name="userImage" />
      </div>   
      <div class="controls">
        <input type="checkbox" v-model="agree" name="agree" />
        <span>同意协议并注册《用户协议》</span>
      </div>
      <div class="btn">
        <button @click="userRegister">完成注册</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "registerVue",
  data() {
    return {    
      //密码
      userPwd:"",    
      //是否同意
      agree: true,
      //用户名
      nickName:'',
      userImage:'',
    };
  },
  methods: {
    async userRegister() {   
      const{userImage,userPwd,nickName}=this;  
      let result=await this.$API.user.reqRegister(userImage,userPwd,nickName)
      if(result.ok==true){
        this.$message("注册成功");
        this.$router.push("/login");
      } else {
        this.$message("注册失败");
      }
    }, 
  },
};
</script>

<style  scoped>
.register-container{
  background:-webkit-linear-gradient(left,rgba(123, 162, 193,.2),rgba(143, 72, 117, 0.3));
}
.register {
  width: 1200px;
  height: 445px;
  border: 1px solid rgb(223, 223, 223);
  margin: 0 auto;
  margin-top: 30px;
  background:url('@/utils/01.webp') no-repeat ;
  background-size: 100%;
}

h3 {
  background: #ececec;
  margin: 0;
  padding: 6px 15px;
  color: #333;
  border-bottom: 1px solid #dfdfdf;
  font-size: 20.04px;
  line-height: 30.06px;
}
h3 span {
  font-size: 14px;
  float: right;
}
.go {
  color: #e1251b;
}

.content {
  padding-left: 390px;
  margin-bottom: 18px;
  position: relative;
  margin-top: 30px;
}
label {
  font-size: 14px;
  width: 96px;
  text-align: right;
  display: inline-block;
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

.controls {
  text-align: center;
}
.controls input {
  vertical-align: middle;
  height: 20px;
  width: 40px;
}

.btn {
  text-align: center;
  line-height: 36px;
  margin: 17px 0 0 55px;
}

.btn button {
  outline: none;
  width: 270px;
  height: 36px;
  background: #e1251b;
  color: #fff !important;
  display: inline-block;
  font-size: 16px;
}
</style>