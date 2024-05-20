import requests from "./ajax";
//浏览商品
export const reqgoodlist = () => {
    return requests({ url: `Goods/query/goodsList`, method: 'post'});
};
//商品名称查询
export const reqGoodsName = (goods_name) => {
    return requests({ url: `Goods/query/goodsName/${goods_name}`, method: 'post'});
};
//商品发布者名称查询
export const reqGoodsUserName = (UserName) => {
    return requests({ url: `/Goods/query/userName/${UserName}`, method:'post'});
};
//商品价格查询
export const reqGoodsPrice = (min,max) => {
    return requests({ url: `/Goods/query/goodsPrice/${min}/${max}`, method:'post'});
};
//商品类型查询
export const reqGoodsCategory = (GoodsCategory) => {
    return requests({ url: `/Goods/query/goodsCategory/${GoodsCategory}`, method:'post'});
};

//商品类型全部展示
export const reqshowcategory = () => {
    return requests({ url: `/Goods/query/goodsTitle`, method:'post'});
};


