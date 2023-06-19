package com.liuzhuo.service;

import com.liuzhuo.common.AccountTitleDto;
import com.liuzhuo.common.vo.PageVo;
import com.liuzhuo.domain.AccountTitles;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class AccountTitlesServiceTest {

    @Resource
    private AccountTitlesService accountTitlesService;

    @Test
    public void testList(){
        AccountTitleDto dto = new AccountTitleDto(1, 10);
        PageVo<AccountTitles> accountTitlesPageVo = accountTitlesService.selectList(dto);
        accountTitlesPageVo.getData().forEach(System.out::println);

    }
}
