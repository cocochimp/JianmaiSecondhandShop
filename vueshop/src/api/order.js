import requests from "./ajax";
//交易列表展示
export const showorder=(orderBuyUserId)=>{
    return requests({url:`/Order/query/orderList/${orderBuyUserId}`,method:"post"})};

//修改订单状态
export const updateorderstate=(orderId,orderStatus)=>{
    return requests({url:`/Order/update/orderStatus/${orderId}/${orderStatus}`,method:"post"})};

//交易评价
export const evaluationorder=(orderId)=>{
    return requests({url:`/Order/update/orderFinalStatus/${orderId}`,method:"post"})};

   