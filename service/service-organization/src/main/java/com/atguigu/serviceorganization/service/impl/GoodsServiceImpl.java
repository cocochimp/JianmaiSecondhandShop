package com.atguigu.serviceorganization.service.impl;

import com.atguigu.serviceorganization.entity.Car;
import com.atguigu.serviceorganization.entity.User;
import com.atguigu.serviceorganization.mapper.GoodsMapper;
import com.atguigu.serviceorganization.mapper.UserMapper;
import com.atguigu.serviceorganization.service.GoodsService;
import com.atguigu.serviceorganization.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2020-01-12
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, User> implements GoodsService {

}
