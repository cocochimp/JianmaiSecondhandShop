/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50635
 Source Host           : localhost:3306
 Source Schema         : shopdb

 Target Server Type    : MySQL
 Target Server Version : 50635
 File Encoding         : 65001

 Date: 10/10/2022 08:41:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for car
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car`  (
  `car_id` varchar(19) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '购物车id',
  `car_userid` varchar(19) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '购物车的用户id',
  `car_shopid` varchar(19) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '购物车的商品id'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '购物车表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of car
-- ----------------------------
INSERT INTO `car` VALUES ('277259026553634818', '277259026553634816', '0');
INSERT INTO `car` VALUES ('277259026557829148', '277259026557829140', '277259026557829242');
INSERT INTO `car` VALUES ('277259026557829158', '277259026557829150', '0');
INSERT INTO `car` VALUES ('277524456866316289', '277524456866316288', '0');
INSERT INTO `car` VALUES ('277259026553634818', '277259026553634816', '277259026557829240');
INSERT INTO `car` VALUES ('277259026557829148', '277259026557829140', '0');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `goods_id` varchar(19) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品id',
  `goods_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品所属人id',
  `goods_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `goods_price` int(255) NULL DEFAULT NULL COMMENT '价格',
  `goods_category` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类型',
  `goods_image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图像地址',
  PRIMARY KEY (`goods_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('277259026557829232', '277259026557829140', '冰箱', 1, '彩电', 'xxx');
INSERT INTO `goods` VALUES ('277259026557829234', '277259026553634816', '笔记本电脑', 120, '高科技产品', 'xxx');
INSERT INTO `goods` VALUES ('277259026557829236', '277259026553634816', '手机', 180, '电子产品', 'xxx');
INSERT INTO `goods` VALUES ('277259026557829238', '277259026557829150', '手表', 300, '电子产品', 'xxx');
INSERT INTO `goods` VALUES ('277259026557829240', '277259026557829140', '电视机', 250, '彩电', 'xxx');
INSERT INTO `goods` VALUES ('277259026557829242', '277259026557829150', '小天才电话手表', 666, '电子产品', 'xxx');
INSERT INTO `goods` VALUES ('278707475165741056', '277259026553634816', '一一一', 188, '好宝贝', 'xxx');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `order_id` varchar(19) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单id',
  `order_buy_user_id` varchar(19) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单的买家用户id',
  `order_sale_user_id` varchar(19) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单的卖家用户id',
  `order_goods_id` varchar(19) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单的商品id',
  `order_price` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单价格',
  `order_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单状态',
  `order_data` datetime(0) NULL DEFAULT NULL COMMENT '订单日期',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('277259026557829268', '277259026553634816', '277259026557829140', '277259026557829232', '1', '未发货', '2022-10-02 17:33:11');
INSERT INTO `order` VALUES ('277259026557829270', '277259026557829150', '277259026553634816', '277259026557829234', '120', '正在路上', '2022-10-19 17:33:14');
INSERT INTO `order` VALUES ('277259026557829272', '277259026557829140', '277259026553634816', '277259026557829236', '180', '已确认收货', '2022-10-22 17:33:19');
INSERT INTO `order` VALUES ('277259026557829274', '277259026553634816', '277259026557829150', '277259026557829238', '300', '已评价', '2022-10-05 17:33:23');

-- ----------------------------
-- Table structure for status
-- ----------------------------
DROP TABLE IF EXISTS `status`;
CREATE TABLE `status`  (
  `status_id` varchar(19) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '订单状态id',
  `status_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单状态姓名',
  PRIMARY KEY (`status_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of status
-- ----------------------------
INSERT INTO `status` VALUES ('1', '未发货');
INSERT INTO `status` VALUES ('2', '正在路上');
INSERT INTO `status` VALUES ('3', '已确认收货');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` varchar(19) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `user_car_id` varchar(19) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户的购物车id',
  `user_image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户头像地址',
  `user_pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户昵称',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('277259026553634816', '277259026553634818', 'xxx', '123456', 'cocochimp01');
INSERT INTO `user` VALUES ('277259026557829140', '277259026557829148', '???', '111111', 'cocochimp02');
INSERT INTO `user` VALUES ('277259026557829150', '277259026557829158', 'yyy', '666666', 'cocochimp03');
INSERT INTO `user` VALUES ('277524456866316288', '277524456866316289', 'hhh', '777777', 'cocochimp04');
INSERT INTO `user` VALUES ('277688490387308544', '277688490387308545', 'xxx', 'xxx', 'cocochimp05');
INSERT INTO `user` VALUES ('277889193512796160', '277889193512796161', '???', '111', 'cocochimp06');

SET FOREIGN_KEY_CHECKS = 1;
