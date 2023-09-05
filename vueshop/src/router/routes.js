// import listone from '@/pages/User/List/listone.vue';
export default
    [
        {
            path: "/login",
            component: () => import("@/pages/Login")
        },

        {
            path: "/register",
            component: () => import("@/pages/Register")
        },
        {
            path: "/home",
            component: () => import("@/pages/Home")
        },
        {
            path:"/goodsInfo",
            component:()=>import("@/pages/Home/GoodsInfo")

        },
        {
            path: "/publish",
            component: () => import("@/pages/ShopPublish")
        },
        {
            path: "/user",
            component: () => import("@/pages/User"),
            children: [
                {
                    path: 'myshopcart',
                    name: 'Myshopcart',
                    component: () => import("@/components/List/Myshopcart"),
                },
                {
                    path: 'userInfo',
                    name: 'UserInfo',
                    component: () => import("@/components/List/UserInfo"),
                },
                {
                    path: 'myIdle',
                    name: 'MyIdle',
                    component: () => import("@/components/List/MyIdle"),
                },
                {
                    path: 'myorder',
                    name: 'Myorder',
                    component: () => import("@/components/List/Myorder"),
                },
                {
                    path: 'mysystem',
                    name: 'Mysystem',
                    component: () => import("@/components/List/Mysystem"),
                }
            ]
        },
        //重定向，在项目跑起来時，访问/，立马定向到首页
        {
            path: '*',
            redirect: "/home",
        }

    ]