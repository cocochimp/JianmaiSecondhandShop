<!--  -->
<template>
  <div>
    <el-table :data="List" style="width: 100%">
      <el-table-column prop="goods_name" label="商品名称" width="180px" border>
      </el-table-column>
      <el-table-column prop="goods_price" label="商品价格" width="180px">
      </el-table-column>
      <el-table-column prop="goods_id" label="商品id" width="180px" border>
      </el-table-column>
      <el-table-column
        prop="goods_user_id"
        label="商品发布者id"
        width="200px"
        border
      >
      </el-table-column>
      <el-table-column prop="goods_category" label="商品类型" width="180px">
      </el-table-column>
      <el-table-column prop="goods_image" label="商品图片" width="180px">
        <template slot-scope="{row}">
          <img :src="row.goods_image" alt="" style="width: 100px; height: 100px" />
        </template>
      </el-table-column>
      <el-table-column prop="prop" label="操作" width="width">
        <template slot-scope="{ row, $index }">
          <el-button type="danger" @click="updateitem(row)">修改</el-button>
          <el-button type="danger" @click="deletegoods(row, $index)"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>
    <!-- 修改框 -->
    <el-dialog title="修改商品信息" :visible.sync="dialogFormVisible">
      <el-form :model="form">
        <el-form-item label="商品类型" :label-width="formLabelWidth">
          <el-select
            v-model="form.goodsCategory"
            placeholder="商品类型"
            class="input"
          >
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.goods_category"
              :value="item.goods_category"
            >
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="商品名称" :label-width="formLabelWidth">
          <el-input v-model="form.goodsName" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="商品价格" :label-width="formLabelWidth">
          <el-input v-model="form.goodsPrice" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="商品图片地址" :label-width="formLabelWidth">
          <el-input v-model="form.goodsImage" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="deleteform">取 消</el-button>
        <el-button type="primary" @click="updategoods">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>
 
<script>
import { mapState } from "vuex";

export default {
  name: "MyIdle",
  data() {
    return {
      List: [],
      dialogFormVisible: false,
      form: {
        goodsImage: "",
        goodsPrice: "",
        goodsName: "",
        goodsCategory: "",
      },
      goodsid: "",
      formLabelWidth: "100px",
      options: [],
    };
  },
  mounted() {
    this.showgoods();
    //展示商品类型
    this.showcategory();
  },
  methods: {
    // 展示商品
    async showgoods() {
      const{goods_user_id}=this;
      // const goods_user_id = this.$store.state.goods.goodsInfo[0].goods_user_id;
      let result = await this.$API.Idle.reqgoodsList(goods_user_id);
      if (result.ok == true) {
        this.List = result.data;
      }
    },
    //删除商品信息
    async deletegoods(row) {
      const GoodId = row.goods_id;
      let result = await this.$API.Idle.reqgoodsdelete(GoodId);
      if (result.ok == true) {
        this.$message("删除成功");
        this.showgoods();
      } else {
        this.$message("删除失败");
      }
    },
    //修改商品信息(按下确定)
    async updategoods() {
      const { goodsImage, goodsPrice, goodsName, goodsCategory } = this.form;
      const { goodsid } = this;
      let result = await this.$API.Idle.reqgoodsupdate(
        goodsid,
        goodsName,
        goodsPrice,
        goodsCategory,
        goodsImage
      );
      if (result.ok == true) {
        this.$message("修改成功");
        this.showgoods();
      } else {
        this.$message("修改失败");
      }

      this.form.goodsPrice = "";
      this.form.goodsName = "";
      this.form.goodsImage = "";
      this.form.goodsCategory = "";
      this.dialogFormVisible = false;
    },
    //取消弹框
    deleteform() {
      this.form.goodsPrice = "";
      this.form.goodsName = "";
      this.form.goodsImage = "";
      this.form.goodsCategory = "";
      this.dialogFormVisible = false;
    },
    //修改按钮
    updateitem(row) {
      this.dialogFormVisible = true;
      this.goodsid = row.goods_id;
    },
    //展示商品类型
    async showcategory() {
      let result = await this.$API.home.reqshowcategory();
      if (result.ok == true) {
        this.options = result.data;
      }
    },
  },
  computed: {
    ...mapState({
      goods_user_id: (state) => state.goods.goodsInfo[0].goods_user_id,
      userid: (state) => state.user.userInfo[0].user_id,
    }),
  },
};
</script>

<style  scoped>
</style>