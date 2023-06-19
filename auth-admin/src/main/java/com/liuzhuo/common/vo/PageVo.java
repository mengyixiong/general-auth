package com.liuzhuo.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageVo<T> {
    private int pageNum; // 当前页码
    private int pageSize; // 每页记录数
    private long total; // 总记录数
    private List<T> data; // 当前页的数据
}
