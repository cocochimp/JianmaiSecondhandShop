<template>
  <header class="header">
    <!-- 头部的第一行 -->
    <div class="container">
      <div>
        <el-button type="danger" class="loginout" @click="reload">注销</el-button>
      </div>
      <div>
        <i class="el-icon-house" id="iconhouse"></i>
        <router-link to="/home" class="homepage" @click="gohome">主页</router-link>
      </div>
      <div>
        <el-button
          type="danger"
          round
          class="shoppublish"
          @click.native="shoppublish()"
          >发布宝贝</el-button
        >
      </div>

      <div class="loginList">
        <p v-if="!nickname">
          <!-- 未登陆时 -->
          <i class="el-icon-user"></i>
          <router-link to="/login" class="clear" 
            >登录</router-link
          >
          <i>\</i>
          <router-link to="/register" class="clear">注册</router-link>
        </p>
        <p v-else>
          <i class="el-icon-user"></i>
          <router-link to="/user/mysystem" class="clear">{{ nickname }}</router-link>         
        </p>
      </div>
    </div>
  </header>
</template>

<script>
// import { mapState } from "vuex";
export default {
  name: "HeaderVue",

  data() {
    return {
      
    };
  },
  methods: {
    //发布商品
    shoppublish() {
      this.$router.push("/publish");
    },
    //注销
    reload(){
      window.location.reload();      
    },
    gohome(){
      
    }
  },
  computed: {
    nickname() {
      return this.$store.state.user.nickName;
    },
  },
};
</script>

<style  scoped>
.header {
  position: relative;
  display: inline-block;
  height: 70px;
  width: 100%;
  background:-webkit-linear-gradient(left,rgb(196, 220, 238),pink);
  box-shadow: -8px 0px 3px 3px rgba(182, 182, 240, 0.3) ;
}
.loginList {
  position: absolute;
  right: 20px;
  top: 16px;
  height: 40px;
  background-color: #fff;
  width: 130px;
  line-height: 10px;
  text-align: center;
  border-radius: 30px;
  font-size: 15px;
}
.shoppublish {
  position: absolute;
  right: 190px;
  top: 16px;
  height: 40px;
  font-size: 15px;
}
.homepage {
  position: absolute;
  top: 26px;
  right: 350px;
  color: #fff;
  text-decoration: none;
}
.clear {
  text-decoration: none;
  color: red;
  margin-left: 5px;
}
.loginout{
  position: absolute;
  left: 20px;
  top: 16px; 
  text-align: center;
  border-radius: 30px;
  font-size: 15px;
}
#iconhouse{
  position: absolute;
  top: 29px;
  right: 389px;
  font-size: 20px;
}
</style>