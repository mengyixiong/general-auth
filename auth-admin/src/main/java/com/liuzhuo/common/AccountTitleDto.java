package com.liuzhuo.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountTitleDto {
    private int page;
    private int limit;
    private String cnName;
    private String enName;
    private String code;
    private String type;
    private String format;
    private Integer level;

    public AccountTitleDto(int page ,int limit){
        this.page = page;
        this.limit = limit;
    }
}
