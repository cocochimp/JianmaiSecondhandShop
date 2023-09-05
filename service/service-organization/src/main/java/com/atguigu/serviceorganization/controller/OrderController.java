package com.atguigu.serviceorganization.controller;

import com.atguigu.serviceorganization.entity.*;
import com.atguigu.serviceorganization.exception.AllException;
import com.atguigu.serviceorganization.mapper.OrderMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//解决跨域问题@CrossOrigin(origins = "*", maxAge = 3600)
@CrossOrigin
@RestController
@RequestMapping("/Order")
@Api(tags = "5、订单管理接口")
public class OrderController {

    ResultVo<Object> resultVo = new ResultVo<>();

    @Autowired
    OrderMapper orderMapper;

    //5.1 交易列表展示
    @ApiOperation(value = "5.1 交易列表展示【输入当前用户id——>orderBuyUserId】")
    @PostMapping("/query/orderList/{orderBuyUserId}")
    public ResultVo<Object> queryOrderList(@PathVariable("orderBuyUserId") String orderBuyUserId)
    {
        try{
            List<Map<String, String>> info = orderMapper.queryOrderList(orderBuyUserId);

            resultVo.setData(info);
            resultVo.setMess("交易列表展示成功！");
            resultVo.setOk(true);
        }
        catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("交易列表展示失败");
            resultVo.setOk(false);
        }
        return resultVo;
    }

    //5.2 交易状态修改
    @ApiOperation(value = "5.2 交易状态修改【输入当前订单id，修改其订单状态orderStatus】")
    @PostMapping("/update/orderStatus/{orderId}/{orderStatus}")
    public ResultVo<Object> updateOrderStatus(@PathVariable("orderId") String orderId,@PathVariable("orderStatus") String orderStatus)
    {
        try{
//            List<Map<String, String>> result = orderMapper.queryOrderStatus();
            orderMapper.updateOrderStatus(orderStatus,orderId);

            resultVo.setMess("交易状态修改成功！");
            resultVo.setOk(true);
        }catch (AllException e){
            resultVo.setMess("交易状态修改失败！");
            resultVo.setOk(false);
        }
        return resultVo;
    }

    //5.3 对卖家做出信用评价（打分）
    @ApiOperation(value = "5.3 对卖家做出信用评价（打分）")
    @PostMapping("/update/orderFinalStatus/{orderId}")
    public ResultVo<Object> updateOrderFinalStatus(@PathVariable("orderId") String orderId)
    {
        try{
            if(orderMapper.queryIfReceive(orderId).equals("已确认收货")){
                orderMapper.updateOrderFinalStatus(orderId);
                resultVo.setMess("对卖家做出信用评价成功！");
                resultVo.setOk(true);
            }else{
                resultVo.setMess("商品状态不为“已确定收货”！");
                resultVo.setOk(false);
            }

        }catch (AllException e){
            resultVo.setMess("对卖家做出信用评价失败！");
        }
        return resultVo;
    }

}

