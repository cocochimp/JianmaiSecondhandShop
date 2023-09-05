import requests from "./ajax";
//注册
export const reqRegister = (userImage,userPwd,nickName) => {
    return requests({ url: `User/insert/user?userImage=${userImage}&userPwd=${userPwd}&nickName=${nickName}`, method: 'post'});
};
//登录
export const reqLogin = (nickName,userPwd) => {
    return requests({ url: `User/login/${nickName}/${userPwd}`, method: 'post'});
};
//用户修改
export const requpdateuser = (userImage,userPwd,nickName,userId) => {
    return requests({ url: `/User/update/userInfo?userImage=${userImage}&userPwd=${userPwd}&nickName=${nickName}&userId=${userId}`, method: 'post'});
};
 