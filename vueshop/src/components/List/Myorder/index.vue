<!-- 订单管理 -->
<template>
  <div>
    <div class="unshipped">
      <el-table :data="List" style="width: 100%">
        <el-table-column
          prop="goods_image"
          label="商品图片"
          width="180px"
          border
        >
          <template slot-scope="{ row }">
            <img
              :src="row.goods_image"
              alt=""
              style="width: 100px; height: 100px"
            />
          </template>
        </el-table-column>
        <el-table-column
          prop="goods_name"
          label="商品名称"
          width="100px"
          border
        >
        </el-table-column>
        <el-table-column prop="order_price" label="商品价格" width="180px">
        </el-table-column>
        <!-- <el-table-column
          prop="goods_category"
          label="商品类型"
          width="100px"
          border
        >
        </el-table-column>
        
        <el-table-column
          prop="sale_user_name"
          label="卖家姓名"
          width="180px"
          border
        >
        </el-table-column> -->
        <!-- <el-table-column
          prop="order_buy_user_id"
          label="买家用户"
          width="180px"
          border
        >
        </el-table-column>
        <el-table-column
          prop="order_data"
          label="下单时间"
          width="180px"
          border
        >
        </el-table-column> -->

        <el-table-column prop="order_status" label="商品状态" width="180px">
        </el-table-column>
        <el-table-column prop="prop" label="请选择状态" width="460px">
          <template slot-scope="{ row, $index }">
            <el-select
              v-model="state[$index]"
              style="width: 130px"
              v-if="List[$index].order_status != '已评价'"
            >
              <el-option key="1" label="未发货" value="未发货"> </el-option>
              <el-option key="2" label="正在路上" value="正在路上"> </el-option>
              <el-option
                key="3"
                label="已确认收货"
                value="已确认收货"
              ></el-option>
            </el-select>
            <el-button
              type="danger"
              @click="updateorderstate(row.order_id, state[$index])"
              v-if="List[$index].order_status != '已评价'"
              >确定
            </el-button>
            <el-input
              v-model="evaluation[$index]"
              v-if="row.order_status == '已确认收货'"
              placeholder="请作出评价"
              style="width: 150px; margin-left: 10px"
            ></el-input>
            <el-button
              type="danger"
              v-if="row.order_status == '已确认收货'"
              style="margin-left: 10px"
              @click="evaluationorder(row.order_id, row.order_status, $index)"
              >完成</el-button
            >
          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
export default {
  name: "MyOrder",
  data() {
    return {
      List: [],
      state: [],
      options: [],
      evaluation: [],
      flag: [],
    };
  },
  computed: {
    //拿到用户id
    ...mapState({
      userid: (state) => state.user.userInfo[0].user_id,
    }),
  },
  methods: {
    //展示订单数据
    async showorderdata() {
      const { userid } = this;
      let result = await this.$API.order.showorder(userid);
      if (result.ok == true) {
        this.List = result.data;
      }
    },
    //修改订单状态
    async updateorderstate(order_id, orderStatus) {
      let result = await this.$API.order.updateorderstate(
        order_id,
        orderStatus
      );
      if (result.ok == true) {
        this.$message("修改成功");

        this.showorderdata();
      } else {
        this.$message("修改失败");
      }
    },
    //对卖家作出信用评价
    async evaluationorder(orderId, order_status, index) {
      let result = await this.$API.order.evaluationorder(orderId);
      if (result.ok == true) {
        this.$message("对卖家做出信用评价成功!");
        this.List[index].order_status = "已评价";
        this.showorderdata();
      } else {
        this.$message("评价失败");
      }
    },
  },
  mounted() {
    this.showorderdata();
  },
};
</script>

<style  scoped>
</style>