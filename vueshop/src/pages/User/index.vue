<template>
  <div class="container">
    <div class="sidebar">
      <el-menu
        :default-active="$route.path"
        class="el-menu-vertical-demo"
      >
      <router-link to="/user/mysystem" style="text-decoration:none;"
          >
          <el-menu-item index="/user/mysystem" class="content" id="shouye">
            <span slot="title">首页</span>
          </el-menu-item>
          </router-link
        >
        <router-link to="/user/userInfo" style="text-decoration:none;"
          >
          <el-menu-item index="/user/userInfo" class="content">
            <span slot="title">用户管理</span>
          </el-menu-item>
          </router-link
        >
        <router-link to="/user/myIdle" style="text-decoration:none;">
          <el-menu-item index="/user/myIdle" class="content">
            <span slot="title">商品管理</span>
          </el-menu-item>
        </router-link>

        <router-link to="/user/myshopcart" style="text-decoration:none;" 
          ><el-menu-item index="/user/myshopcart" class="content">
            <span slot="title">购物车管理</span>
          </el-menu-item></router-link
        >
        <router-link to="/user/myorder" style="text-decoration:none;">
          <el-menu-item index="/user/myorder" class="content">
            <span slot="title">订单管理</span>
          </el-menu-item>
        </router-link>
        
      </el-menu>
    </div>
    <router-view class="rightview"></router-view>
  </div>
</template>

<script>
export default {
  name: "UserVue",
  components: {},
  data() {
    return {};
  },
};
</script>

<style  scoped>
.sidebar {
  display: inline-block;
  height: 900px;
  width: 150px; 
  position: absolute;
  left: 0px;
  top: 0px;
  background-color: rgba(152, 148, 151, 0.116);
}
.content{
  background-color: rgba(152, 148, 151, 0.116);
  font-size: 18px;
}
.container {
  position: relative;
}
.rightview{
  margin-left: 150px;
}
#shouye{
  background-color: rgb(196, 220, 238);
}
</style>