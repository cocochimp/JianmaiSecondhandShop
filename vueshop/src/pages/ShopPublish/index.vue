<!-- 添加商品 -->
<template>
  <div class="container">
    <el-form ref="form" label-width="100px">
      <el-form-item label="商品名称" class="List">
        <el-input
          v-model="goods.goodsName"
          class="input"
          placeholder="请输入商品名称"
        ></el-input>
      </el-form-item>
      <el-form-item label="商品价格" class="List">
        <el-input
          v-model="goods.goodsPrice"
          placeholder="请输入商品价格"
          class="input"
        ></el-input>
      </el-form-item>
      <el-form-item label="商品类型" class="List">
        <el-select
          v-model="goods.goodsCategory"
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
      <el-form-item label="商品图片" class="List" style="position:relative">
        <el-upload
          class="avatar-uploader"
          action="http://localhost:9109/Goods/uploadAvator"
          :show-file-list="false"
          :on-success="handleAvatarSuccess"
          :before-upload="beforeAvatarUpload"
          id="upload"
        >
          <img v-if="goods.goodsImage" :src="goods.goodsImage" class="avatar" />
          <i v-else class="el-icon-plus avatar-uploader-icon"></i>
        </el-upload>
      </el-form-item>
      <el-button type="danger" @click="publishsuccess" class="list-button">立即创建</el-button>
    </el-form>
  </div>
</template>

<script>
import { mapState } from "vuex";
export default {
  name: "ShopPublish",
  data() {
    return {
      goods: {
        goodsName: "",
        goodsPrice: "",
        goodsCategory: "",
        goodsImage: "",
      },
      options: [],
    };
  },
  methods: {
    //发布新的商品
    async publishsuccess() {
      try {
        const { goodsName, goodsPrice, goodsCategory, goodsImage } = this.goods;
        const { goodsUserId } = this;
        await this.$store.dispatch("publishsuccess", {
          goodsUserId,
          goodsName,
          goodsPrice,
          goodsCategory,
          goodsImage,
        });
        this.$message("发布成功");
        this.$router.push("/user/mysystem");
      } catch (error) {
        alert(error.message);
      }
    },
    //展示商品类型
    async showcategory() {
      let result = await this.$API.home.reqshowcategory();
      if (result.ok == true) {
        this.options = result.data;
      }
    },
    handleAvatarSuccess(res, file) {
        this.goods.goodsImage = file.response.data;
      },
      beforeAvatarUpload(file) {
        const isJPG = file.type === 'image/jpeg';
        const isLt2M = file.size / 1024 / 1024 < 2;

        if (!isJPG) {
          this.$message.error('上传头像图片只能是 JPG 格式!');
        }
        if (!isLt2M) {
          this.$message.error('上传头像图片大小不能超过 2MB!');
        }
        return isJPG && isLt2M;
      }

  },
  mounted() {
    this.showcategory();
  },
  computed: {
    //拿到用户购物车数据
    ...mapState({
      goodsUserId: (state) => state.user.userInfo[0].user_id,
    }),
  },
};
</script>

<style  scoped>
.avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }
  .avatar {
    width: 178px;
    height: 178px;
    display: block;
  }
  #upload{
    position:absolute;
    left: 10px;
  }
.container {
  margin-top: 30px;
  height: 450px;
  text-align: center;
  background:-webkit-linear-gradient(left,rgba(123, 162, 193,.2),pink);
  box-shadow: -8px 0px 3px 3px rgba(182, 182, 240, 0.3) ;

}
.input {
  width: 222px;
  margin-right: 1000px;
}
.upload-demo {
  margin-right: 900px;
}
.List {
  margin-left: 750px;
}
.list-button{
  position: absolute;
  top: 520px;
  left:900px;
}
</style>