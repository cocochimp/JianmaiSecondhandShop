# 简麦二手商城（毕设、课设）

🌈基于SpringBoot，Mybatis Plus，Swagger，fastjson，Vue&Element框架开发的的简麦二手商城平台

github地址：https://github.com/cocochimp/JianmaiSecondhandShop

⚠⚠

近期发现有很多无良商家没有征得我的同意，私自盗取我的开源项目作为毕设、课设以及论文去高价卖！！！因此将数据库闭源！

如果有需要可以留言我并说明用意，如果有毕设项目、毕业论文、课设的用途，请私聊我

![](https://cocochimp-img.oss-cn-beijing.aliyuncs.com/13.png)

# 启动命令

> 运行环境

- java:8（jdk1.8）
- mysql:5.6.35



# 项目结构

> 后端技术栈

| 依赖                 | 版本          |
| -------------------- | ------------- |
| Spring Boot          | 2.2.1.RELEASE |
| mysql-connector-java | 8.0.16        |
| Mybatis Plus         | 3.4.3         |
| junit                | 4.12          |
| swagger              | 1.5.13        |
| fastjson             | 1.2.28        |
| lombok               | 1.18.12       |



# 📚页面展示📚

## 系统登录

> 用户登录

打开浏览器，在地址栏输入服务器的IP地址：http://localhost:8080/#/login

进入系统登录界面。用户输入用户名和密码信息，点击【登录】按钮即可完成登录，进入到到首页商品展示页面，如图1-1所示：

![img](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/clip_image002.jpg)

 

> 用户注册

当新用户进入到系统时，需要事先注册新账号，新用户输入用户名和密码信息，并且上传自己的头像地址信息，如图1-2所示：

![img](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/clip_image004.jpg)

 

## 主页

### 商品界面

本简麦闲置交易平台主界面如下图所示，主要分为3个主要模块，最上方是功能菜单，用户可以实现“注销”、“进入首页”、“发布宝贝”、“登录账号”和“注册账号”的功能；中间的为闲置商品的搜索功能，可以通过“商品名称”、“商品发布者姓名”、“商品价格区间”等筛选出特定的闲置商品，如图2-1所示: 

![img](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/clip_image006.jpg)



> 查询指定闲置商品：（模糊查询）

![img](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/clip_image008.jpg)

 

 

### 商品详情界面

上述简麦闲置交易平台的最下方是各个闲置商品的展示页面，用户可以点击指定商品进入到闲置商品的详情页面。

进入到闲置商品的详情页面后，前端会展示闲置商品的“商品名称”、“商品价格”以及“商品总价格”属性，用户可以通过选定数量将其加入到购物车内，如图2-3所示：

![img](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/clip_image010.jpg)

 

## 用户管理系统

点击右上角的“用户个人信息”按钮后进入到简麦闲置交易后台管理系统的主界面，如图3-1所示：

![img](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/clip_image012.gif)



点击左方导航栏的“用户管理”，用户进入简麦闲置交易后台管理系统的“用户管理”模块，输入其专属的用户名，再输入其新的“密码”、“用户头像”，若不输入新的“密码”或“用户头像”，则系统会维持默认的原始信息，如图3-2所示：

![img](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/clip_image014.gif)

 

 

## 商品管理系统

用户可以点击右上方导航栏的“发布宝贝”进行闲置商品的发布，如图4-1所示：

![img](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/clip_image016.gif)

 

用户发布完新商品后，会在“商品管理”中展示自己所发布的新商品，并且发布该闲置商品的用户可以对该商品进行“修改”与“删除”的操作，如图4-2所示：

![img](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/clip_image018.gif)

 

> 修改商品

用户点击修改商品，系统弹出“修改商品信息”的信息提示栏，用户输入该商品的新数据对该发布的商品进行“商品类型”、“商品名称”、“商品价格”以及“商品图片”的修改，如图4-3所示：

![img](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/clip_image020.gif)

 

发布该商品的用户点击“确定”按钮后，商品管理系统显示出新的闲置商品的信息，修改商品成功，如图4-4所示：

![img](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/clip_image022.gif)

 

> 删除商品

用户点击商品管理系统中某个指定商品的“删除”按钮，系统会将该商品信息进行删除，在系统中弹出“删除成功”的提示信息，如图4-5所示：

![img](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/clip_image024.gif)

 

## 购物车管理系统

用户在商品展示首页中点击某个特定商品进入该商品的“商品详情页面”，点击“加入购物车”按钮将商品放入购物车内，再进入到简麦闲置交易后台管理系统的“购物车管理”系统中，其展示出用户加入购物车的商品信息，以及给予用户进行“购买商品”和“删除商品”的权限，如图5-1所示：

![img](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/clip_image026.gif)

 

> 购买商品

用户点击某个存在于购物车的商品中的“购买商品”按钮，系统会将此商品转跳到“订单管理”系统中，表示该商品已经购买成功，如图5-2所示：

![img](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/clip_image028.gif)

 

> 将商品移除出“购物车”

用户点击购物车管理系统中某个指定商品的“删除”按钮，系统会将该商品信息进行删除，在系统中弹出“删除成功”的提示信息，如图5-3所示：

![img](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/clip_image030.gif)

 

## 订单管理系统

用户进入到简麦闲置交易后台管理系统的“订单管理”系统中，其展示出用户所购买的所有闲置商品数据信息，系统会展示出每个闲置商品订单信息的“商品图片”、“商品名称”、“商品状态”等，以及给予用户进行“修改商品状态”的权限，如图6-1所示：

![img](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/clip_image032.gif)

购买某个闲置商品的用户可以通过“订单管理系统”对相应商品进行状态修改操作，其状态分别为“未发货”、“正在路上”、“已确认收货”和“已评价”四种状态，如图6-2所示：

 

![img](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/clip_image034.gif)

 

> 修改订单商品状态

当用户将订单商品状态修改为“已确认收货”时，后面会弹出用户对该订单的评分系统标准，用户可以输入其分数（1~10分不等），如图6-3所示：

![img](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/clip_image036.gif)

 

当用户将上述评分信息填写好后点击“完成”按钮，闲置商品的状态就会变为“已评价”，系统会将该数据进行存储，并在前端返回“评价成功”信息，如图6-4所示：

![img](https://cocochimp-markdown-img.oss-cn-beijing.aliyuncs.com/clip_image038.gif)