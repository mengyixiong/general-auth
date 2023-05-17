package com.liuzhuo.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RouterVo {
    // 路由地址
    private String path;

    private String component;
    //是否显示
    private boolean alwaysShow;
    //路由名称
    private String name;
    //路由meta信息
    private Meta meta;
    //子路由
    private List<RouterVo> children = new ArrayList<RouterVo>();

    @Data
    @AllArgsConstructor
    public class Meta {
        private String title;// 标题
        private String icon;// 图标
        private Object[] roles; // 角色列表
    }
}
