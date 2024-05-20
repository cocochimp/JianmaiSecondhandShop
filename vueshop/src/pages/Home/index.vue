<template>
  <div class="container">
    <div class="topshow">
      <h1 style="font-size: 80px;">简麦闲置交易平台</h1>
    <!-- 根据商品名称查询 -->
    <input
      type="text"
      class="search"
      placeholder="根据商品名称搜索"
      v-model="goods_name"
    />
    <el-button type="danger" @click="searchInfo" icon="el-icon-search">搜索</el-button>
    <!-- 根据商品发布者名字查询 -->
    <input
      type="text"
      class="search"
      placeholder="根据商品发布者名字查询"
      v-model="UserName"
    />
    <el-button type="danger" @click="searchUserNameInfo" icon="el-icon-search">搜索</el-button>
    <br>
    <!-- 根据商品价格搜索 -->
    <input
      type="text"
      class="search"
      placeholder="请输入最小价格"
      v-model="minprice"
      style=""
    /><i style="width: 10px">~~~</i>
    <input
      type="text"
      class="search"
      style="margin:5px"
      placeholder="请输入最大价格"
      v-model="maxprice"
    />
    <el-button type="danger" @click="searchPriceInfo" icon="el-icon-search">搜索</el-button>
    <!-- 根据商品类型查询 -->
    <!-- <input
      type="text"
      class="search"
      placeholder="根据商品类型查询"
      v-model="GoodsCategory"
    /> -->
    <el-select v-model="GoodsCategory" placeholder="根据商品类型查询" style="margin-left:10px">
      <el-option
        v-for="item in options"
        :key="item.value"
        :label="item.goods_category"
        :value="item.goods_category"
      >
      </el-option>
    </el-select>
    <el-button type="danger" @click="searchGoodsCategory" icon="el-icon-search">搜索</el-button>
    <div class="shopList">
      <div class="List">
        <ul class="listContainer">
          <li class="ListInfo"><a href="#">闲置数码</a></li>
          <li class="ListInfo"><a href="#">校园代步</a></li>
          <li class="ListInfo"><a href="#">电脑日用</a></li>
          <li class="ListInfo"><a href="#">图书教材</a></li>
          <li class="ListInfo"><a href="#">美妆衣物</a></li>
          <li class="ListInfo"><a href="#">运动棋牌</a></li>
          <li class="ListInfo"><a href="#">票卷小物</a></li>
          <li class="ListInfo"><a href="#">线下交易</a></li>
          <li class="ListInfo"><a href="#">查看全部</a></li>
        </ul>
      </div>
    </div>
    </div>
    <div class="show">
      <h2>All the goods</h2>
      <ul v-for="good in list" :key="good.goods_id" class="goodshow">
        <a href="#" @click="runtogoodsinfo(good)">
        <li><img :src="good.goods_image"  id="imgstyle" alt=""></li>
        <li>商品名称:{{ good.goods_name }}</li>        
        <li>商品价格:{{good.goods_price}}</li>
        </a>
      </ul>
    </div>

    <!-- 分页器 -->
    <el-pagination
      style="margin-buttom: 20px; textalign: center"
      class="pagination"
      :current-page="page"
      layout="prev, pager, next,jumper,->,sizes,total"
      :total="total"
      :page-size="limit"
      :page-sizes="[1]"
      @current-change="getPageList"
      @size-change="handleSizeChange"
      :pager-count="5"
    >
    </el-pagination>
  </div>
</template>

<script>
import { mapState } from "vuex";
export default {
  name: "HomeVue",
  data() {
    return {
      //代表的分页器第几页
      page: 1,
      //当前页数展示数据条数
      limit: 3,
      //总数据条数
      total: 0,
      //列表展示的数据
      list: [],
      //商品名称
      goods_name: "",
      //商品发布者名称
      UserName: "",
      //商品价格
      minprice: "",
      maxprice: "",
      // 商品类型
      GoodsCategory: "",
      //商品类型展示
      options:[],
    };
  },
  methods: {
    //商品详情
    runtogoodsinfo(good){
      this.$store.state.goods.ListInfo='';
      this.$store.state.goods.ListInfo=good;
      this.$router.push('/goodsInfo');

    },
    //商品名称搜索的回调
    async searchInfo() {
      const { goods_name } = this;
      if(goods_name==''){
        this.getPageList();
      }
      let result = await this.$API.home.reqGoodsName(goods_name);
      if (result.ok == true) {
        this.UserName = "";
        this.minprice = "";
        this.maxprice = "";
        this.GoodsCategory = "";
        this.list = "";
        this.list = result.data;
        this.$message('搜索成功')
      }else {
        this.$message("没有此商品");
      }
    },
    //商品发布者名称搜索的回调
    async searchUserNameInfo() {
      const { UserName } = this;
      if(UserName==''){
        this.getPageList();
      }
      let result = await this.$API.home.reqGoodsUserName(UserName);
      if (result.ok == true) {
        this.goods_name = "";
        this.minprice = "";
        this.maxprice = "";
        this.GoodsCategory = "";
        this.list = "";
        this.list = result.data;
        this.$message('搜索成功')
      } else {
        this.$message("没有此商品");
      }
    },
    //商品价格搜索的回调
    async searchPriceInfo() {
      const { minprice, maxprice } = this;
       if(minprice==''||maxprice==''){
        this.getPageList();
      }
      let result = await this.$API.home.reqGoodsPrice(minprice, maxprice);
      if (result.ok == true) {
        this.goods_name = "";
        this.UserName = "";
        this.GoodsCategory = "";
        this.list = "";
        this.list = result.data;
        this.$message('搜索成功')
      } else {
        this.$message("没有此商品");
      }
    },
    //根据商品类型查询
    async searchGoodsCategory() {
      const { GoodsCategory } = this;
       if(GoodsCategory==''){
        this.getPageList();
      }
      let result = await this.$API.home.reqGoodsCategory(GoodsCategory);
      if (result.ok == true) {
        this.goods_name = "";
        this.UserName = "";
        this.minprice = "";
        this.maxprice = "";
        this.list = "";
        this.list = result.data;
        this.$message('搜索成功')
      } else {
        this.$message("没有此商品");
      }
    },
    //获取品牌列表的数据
    async getPageList() {
      let result = await this.$API.home.reqgoodlist();
      this.list=result.data;
      console.log(result.data);
    },
    //加入购物车
    async addshopcart(goodid) {
      const {user_id} = this;
      let result = await this.$API.shopcart.insertCarshop(
        user_id,goodid
      );
      if(user_id==''){
        this.$message('请先登录');
        return;
      }
      if (result.ok == true) {
        this.$message("添加成功");
        // this.$router.push("/user/myshopcart");
      }else{
        this.$message('该商品已加入购物车')
      }
    },
    //购买商品
    async buygoods(goodsid,goods_user_id){
      let result= await this.$API.shopcart.buyCarshop(goodsid,goods_user_id);
     if(result.ok==true){
       this.$message('购买成功');
      //  this.$router.push('/user/myorder')
     }else{
        this.$message('购买失败')
      }
    },
     //展示商品类型
    async showcategory(){
      let result= await this.$API.home.reqshowcategory();
      if(result.ok==true){
        this.options=result.data;
      }
    }
  },
  computed: {
    //拿到用户购物车数据
    ...mapState({
      user_id:(state)=> state.user.userInfo[0].user_id,
      goodsInfo:(state)=> state.goods.goodsInfo,
    }),
  },

  mounted() {
    //获取列表数据方法
    this.getPageList();
    //展示商品类型
    this.showcategory();
  },
};
</script>

<style  scoped>
*{
   font-family:Cambria, Cochin, Georgia, Times, 'Times New Roman', serif, 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;;
}
#imgstyle{
  display: inline-block;
  width: 240px;
  height: 160px;
  margin-right: 30px;
  border-radius: 13px;
  border-style: solid;
  border-width: 1px;
  box-shadow: 2px 1px 1px 2px rgba(15, 15, 30, .3);
}
.search {
  display: inline-block;
  width: 200px;
  height: 35px;
  font-size: 20px;
  border-radius: 10px;
   border-color: #b46a60;
  border-style: solid;
  border-width: 1px;
  margin-left: 10px;
}
.container {
  text-align: center;
  position: relative;
  
}
.listContainer li:hover{
  background-color: rgba(245, 116, 116, 0.761);

}
.listContainer li {
  display: inline-block;
  margin-left: 20px;
  border-color: #ea4a36;
  height: 50px;
  width: 120px;
  line-height: 50px;
  border-radius: 10px;
  background-color: rgba(152, 148, 151, 0.116);
  box-shadow: 2px 1px 1px 2px rgba(15, 15, 30, .3);

}
.pagination {
  position: absolute;
  bottom: 0px;
  left: 42%;
}
.List {
  display: inline-block;
  width: 100%px;
  height: 80px;
  margin-left: -60px;
  padding-right: 20px;
  margin-top: 20px;
  border-style:ridge;
  border-width: 1px;
  border-color: rgba(152, 148, 151, 0.116);
  border-radius: 30px;
  background-color: rgba(152, 148, 151, 0.1);
}
.ListInfo a{
  font-size: 18px;
  text-decoration: none;
  font-family:Arial, Helvetica, sans-serif;
  color: black

}
.publish {
  display: inline-block;
  width: 148px;
  height: 68px;
  margin-left: 10px;
  border-radius: 10px;
  border-style: solid;
  border-width: 1px;
  font-size: 20px;
  background-color: #fff;
  font-style: italic;
}
.topshow{
  background:-webkit-linear-gradient(left,rgba(80, 155, 213,.3),pink);
}
.goodshow {
  position: relative;
  line-height: 20px;
  display: inline-block;
  margin-left: 65px;
  margin-top: 10px;
  padding-top: 2px;
  padding-left: 20px;
  height: 210px;
  width: 250px;
  list-style: none;
  border-style: solid;
  border-width: 3px;
  border-radius: 30px;
  border-color: rgba(152, 148, 151, 0.116);
  box-shadow: 1px 2px 2px 2px rgba(15, 15, 30, .3);
}
.goodshow li {
  position: relative;
  top: 4px;
  left: -6px;
}
.goodshow a{
  color: black;
  font-family:Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
}
.show {
  text-align: left;
  margin-top: 20px;
  position: relative;
  display: inline-block;
  height: 600px;
  width: 1500px;
  box-shadow: 2px 2px 2px 2px rgba(15,15,30,.3) ;
  background:-webkit-linear-gradient(right,rgba(128, 156, 178, 0.2),rgb(150, 202, 233));
}
.show h2{
  text-align: center;
  font-size: 30px;
}
a{
  text-decoration: none;
}
</style>