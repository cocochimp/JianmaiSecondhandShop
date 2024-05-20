package com.atguigu.aclservice.helper;

import com.alibaba.fastjson.JSONObject;
import com.atguigu.aclservice.entity.Permission;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 根据权限数据构建登录用户左侧菜单数据
 * </p>
 *
 * @author qy
 * @since 2019-11-11
 */
public class MemuHelper {//菜单生成助手

    /**
     * 构建菜单 其实菜单本可以递归的
     * @param treeNodes
     * @return
     */
    public static List<JSONObject> bulid(List<Permission> treeNodes) {//这里的treeNodes是list组成的 要转换成json形式
        List<JSONObject> meuns = new ArrayList<>();
        if(treeNodes.size() == 1) {//如果树大小不为1 就返回menus即返回空树
            Permission topNode = treeNodes.get(0);//获得第一个大整体
            //左侧一级菜单
            List<Permission> oneMeunList = topNode.getChildren();//一级子菜单
            for(Permission one :oneMeunList) {
                JSONObject oneMeun = new JSONObject();//Json对象
                oneMeun.put("path", one.getPath());//前端路径
                oneMeun.put("component", one.getComponent());//前端组件
                oneMeun.put("redirect", "noredirect");//没有重定向
                oneMeun.put("name", "name_"+one.getId());//Permission id
                oneMeun.put("hidden", false);//不隐藏

                JSONObject oneMeta = new JSONObject();
                oneMeta.put("title", one.getName());//设置标题
                oneMeta.put("icon", one.getIcon());//设置图标
                oneMeun.put("meta", oneMeta);

                List<JSONObject> children = new ArrayList<>();//一级子菜单
                List<Permission> twoMeunList = one.getChildren();//二级子菜单
                for(Permission two :twoMeunList) {
                    JSONObject twoMeun = new JSONObject();
                    twoMeun.put("path", two.getPath());
                    twoMeun.put("component", two.getComponent());
                    twoMeun.put("name", "name_"+two.getId());
                    twoMeun.put("hidden", false);

                    JSONObject twoMeta = new JSONObject();
                    twoMeta.put("title", two.getName());
                    twoMeun.put("meta", twoMeta);

                    children.add(twoMeun);//二级子菜单

                    List<Permission> threeMeunList = two.getChildren();//三级子菜单
                    for(Permission three :threeMeunList) {
                        if(StringUtils.isEmpty(three.getPath())) continue;

                        JSONObject threeMeun = new JSONObject();
                        threeMeun.put("path", three.getPath());
                        threeMeun.put("component", three.getComponent());
                        threeMeun.put("name", "name_"+three.getId());
                        threeMeun.put("hidden", true);

                        JSONObject threeMeta = new JSONObject();
                        threeMeta.put("title", three.getName());
                        threeMeun.put("meta", threeMeta);

                        children.add(threeMeun);////三级子菜单
                    }
                }
                oneMeun.put("children", children);//一级子菜单装二级子菜单
                meuns.add(oneMeun);//一级JSONObject装一级子菜单
            }
        }
        return meuns;//返回JSONObject的菜单

    }
}
