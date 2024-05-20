import requests from "./ajax";
//加入购物车
export const insertCarshop=(carUserId,carShopId)=>{
    return requests({url:`/Car/insert/carGoods?carUserId=${carUserId}&carShopId=${carShopId}`,method:"post"})};
//展示购物车数据
export const showCarshop=(carUserId)=>{
    return requests({url:`/Car/query/carList/${carUserId}`,method:"post"})};
//删除购物车商品
export const deleteCarshop=(goods_id,carUserId)=>{
    return requests({url:`/Car/delete/carGoods/${goods_id}/${carUserId}`,method:"post"})};
//购买商品
export const buyCarshop=(goodsid,userid)=>{
    return requests({url:`/Car/update/carGoods?orderGoodsId=${goodsid}&orderBuyUserId=${userid}&orderPrice=${1}`,method:"post"})};
