import requests from "./ajax";
//发布商品
export const reqIdlegoods = (goodsUserId,goodsName,goodsPrice,goodsCategory,goodsImage) => {
    return requests({ url: `Goods/insert/goods?goodsUserId=${goodsUserId}&goodsName=${goodsName}&goodsPrice=${goodsPrice}&goodsCategory=${goodsCategory}&goodsImage=${goodsImage}`, method: 'post'});
};
//展示商品管理商品
export const reqgoodsList = (goodsUserId) => {
    return requests({ url: `/Goods/query/goodsList/${goodsUserId}`, method:'post'});
};
//删除商品信息的删除
export const reqgoodsdelete=(GoodId)=>{
    return requests({url:`/Goods/delete/goods/${GoodId}`,method:'post'});}
    
 //修改已发布商品信息
export const reqgoodsupdate=(goodsId,goodsName,goodsPrice,goodsCategory,goodsImage)=>{
    return requests ({url:`/Goods/update/goods?goodsId=${goodsId}&goodsName=${goodsName}&goodsPrice=${goodsPrice}&goodsCategory=${goodsCategory}&goodsImage=${goodsImage}`,method:'post'});
}