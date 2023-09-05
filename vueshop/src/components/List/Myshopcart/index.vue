<!-- 购物车管理 -->
<template>
  <div>
    <el-table :data="List" style="width: 100%">
      <el-table-column prop="goods_image" label="商品图片" width="180px">
        <template slot-scope="{row}">
          <img :src="row.goods_image" alt="" style="width: 100px; height: 100px" />
        </template>
      </el-table-column>
      <el-table-column prop="goods_name" label="商品名称" width="180px" border>
      </el-table-column>
      <el-table-column prop="goods_price" label="商品价格" width="180px">
      </el-table-column>
      <el-table-column prop="itemNum" label="数量" width="200px">
      </el-table-column> 
      <el-table-column prop="itemNum"  label="总价格" width="200px">
        <template slot-scope="{row}">
          {{(row.goods_price) * (row.itemNum)}}
        </template>
      </el-table-column> -->
      <el-table-column prop="prop" label="操作" width="width">
        <template slot-scope="{row}">
          <el-button type="danger" @click="buygoods(row.goods_id,row.car_userid)"> 购买商品 </el-button>
          <el-button type="danger" @click="deleteCarshop(row.goods_id)"> 删除商品 </el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import 'element-ui/lib/theme-chalk/index.css'
import { mapState } from "vuex";
export default {
  name: "MyShopcart",
  data() {
    return {
      List:[],
    }
  },
  mounted() {
    this.showCarshop();
  },
  computed: {
    //拿到用户购物车数据
      ...mapState({
         caruserid: (state) => state.user.userInfo[0].user_id,
         userid: (state) => state.user.userid,
         goods: (state) => state.goods.ListInfo,
         nickName: (state) => state.user.nickName,
      })
    },
  methods: {
    //展示购物车数据
    async showCarshop(){
      const{caruserid}=this;
       let result=await this.$API.shopcart.showCarshop(caruserid);
       if(result.ok==true){         
         this.List=result.data;
         this.List.forEach((item) => {
        item.itemNum = 2;
       })
       console.log(this.List);
       }
    },
    //删除购物车商品
    async deleteCarshop(goods_id){
      const{caruserid}=this;
      let result=await this.$API.shopcart.deleteCarshop(goods_id,caruserid)
      console.log(goods_id,caruserid);
      if(result.ok==true){
       this.List=result.data;
       this.showCarshop()
        this.$message('删除成功')
      }else{
        this.$message('删除失败')
      }
    },
    //购买商品
    async buygoods(goods_id,car_userid){
     let result= await this.$API.shopcart.buyCarshop(goods_id,car_userid);
     console.log(result);
     console.log(goods_id,car_userid);
     if(result.ok==true){
       console.log(car_userid);
       this.showCarshop();
       this.$message('购买成功');   
       this.$router.push('myorder')    
     }else{
        this.$message('购买失败')
      }
    },
    min (item) {     
      item.itemNum = item.itemNum -1;
      this.ist = this.List.forEach((value) => {
        if(value.goods_id === item.goods_id) {
          value.itemNum = item.itemNum;
        }
      })
      console.log(this.List,"减");
    },
    add (item) {
      item.itemNum = item.itemNum +1;
      this.list = this.List.forEach((value) => {
        if(value.goods_id === item.goods_id) {
          value.itemNum = item.itemNum;
        }
      })
      console.log(this.List,"加");
    },
    handleChange(value) {
        console.log(value);
    }
  },
};
</script>

<style  scoped>
</style>