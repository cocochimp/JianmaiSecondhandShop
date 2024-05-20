import Vue from 'vue';
import VueRouter from 'vue-router';
import routes from './routes';

Vue.use(VueRouter);

//先把VueRouter原型对象的push，保存一份
let originPush = VueRouter.prototype.push;
let originRepalce = VueRouter.prototype.replace;

//重写push|replace
//第一个参数：告诉原来push方法，你在哪里跳转，(传递哪些参数)
VueRouter.prototype.push = function (location, resolve, reject) {
    if (resolve && reject) {
        originPush.call(this, location, resolve, reject);
    } else {
        originPush.call(this, location, () => { }, () => { });
    }

}
VueRouter.prototype.replace = function (location, resolve, reject) {
    if (resolve && reject) {
        originRepalce.call(this, location, resolve, reject);
    } else {
        originRepalce.call(this, location, () => { }, () => { });
    }

}
let router = new VueRouter({
    routes,
});
export default router;