<!-- 商品详情页面 -->
<template>
  <div>
    <div class="show">
      <h2>This good {{ goods.goods_name }}</h2>
      <img :src="goods.goods_image" id="imgstyle" />
      <div class="rightShow">
        <ul class="goodshow">
          <li id="goodsName">商品名称:{{ goods.goods_name }}</li>
          <li>商品价格:{{ goods.goods_price }}</li>
          <li>卖家姓名:{{goods.nickname}}</li>
          <template>
            <el-input-number v-model="num" label="修改商品数量"></el-input-number>
          </template>
          <li>商品总价格:{{ goods.goods_price*num }}</li>
          <li>
            <el-button
              type="danger"
              @click="addshopcart"
              icon="el-icon-circle-plus-outline"
              class="shopcar"
              >加入购物车</el-button
            >
          </li>
        </ul>
      </div>
    </div>
  </div>
</template>
  
  <script>
import { mapState } from "vuex";

export default {
  data() {
    return {
      num: 1,
    };
  },
  name: "GoodsInfo",
  methods: {
    //加入购物车
    async addshopcart() {
      const { nickName, goods } = this;
      if (nickName == "") {
        this.$message("请先登录");
        return;
      }
      let result = await this.$API.shopcart.insertCarshop(
        goods.goods_user_id,
        goods.goods_id
      );
      if (result.ok == true) {
        this.$message("添加成功");
        this.$router.push("/home");
      } else {
        this.$message("该商品已加入购物车");
      }
    },
    handleChange(value) {
      console.log(value);
    },
    
  },
  mounted() {
  },
  computed: {
    ...mapState({
      userid: (state) => state.user.userid,
      goods: (state) => state.goods.ListInfo,
      nickName: (state) => state.user.nickName,
    }),
  },
};
</script>
  


<style  scoped>
#imgstyle {
  width: 760px;
  height: 500px;
  position: absolute;
  left: 50px;
}
.show {
  text-align: center;
  margin-top: 120px;
  margin-left: 200px;
  position: relative;
  display: inline-block;
  height: 600px;
  width: 1500px;
  box-shadow: 2px 2px 2px 2px rgba(15, 15, 30, 0.3);
  background: rgba(101, 56, 61, 0.042);
}
.rightShow {
  display: inline-block;
}
.goodshow {
  font-size: 24px;
  text-align: left;
  position: absolute;
  line-height: 80px;
  display: inline-block;
  margin-left: 85px;
  top: 50px;
  padding-top: 2px;
  height: 410px;
  width: 350px;
  list-style: none;
}
.shopcar {
  width: 200px;
  height: 60px;
  font-size: 17px;
  margin-top: 80px;
}
li {
  list-style: none;
}
</style>