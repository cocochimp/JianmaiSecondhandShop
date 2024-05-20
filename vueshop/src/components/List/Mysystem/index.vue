<!-- 后台管理系统首页 -->
<template>
  <div class="box-container">
    <div class="title">个人后台</div>    
    <div class="image">
        <i class="el-icon-house"></i>
        <div >welcome,{{nickname}}</div>
    </div>
    <div class="container">

    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
export default {
  name: "MySystem",
  data() {
    return {};
  },
   computed: {
    ...mapState({
      nickname: (state) => state.user.userInfo[0].nickname, 
    }),
  },
};
</script>

<style  scoped>
.title {
  font-size: 50px;
  font-family: "Trebuchet MS", "Lucida Sans Unicode", "Lucida Grande",
    "Lucida Sans", Arial, sans-serif;
  text-align: center;
}

.image {
  text-align: center;
  font-size: 80px;
  margin-top: 30px;
  font-family: "Trebuchet MS", "Lucida Sans Unicode", "Lucida Grande",
    "Lucida Sans", Arial, sans-serif;
    color: rgba(240, 110, 110, 0.752);
   
}
.container{
  width: 800px;
  height: 500px;
  background:url('@/utils/02.webp') no-repeat ;
  background-size: 100%;
  text-align: center;
  position:absolute;
  top: 300px;
  left: 50%;
  margin-left: -400px;
}
.box-container{
  position: relative;
  background:-webkit-linear-gradient(left,rgba(123, 162, 193,.2),pink);
  box-shadow: 2px 2px 2px 2px rgba(15,15,30,.3) ;
}
</style>