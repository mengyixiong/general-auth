package com.liuzhuo.service;

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
        PageVo<AccountTitles> accountTitlesPageVo = accountTitlesService.selectList(1, 10);
        accountTitlesPageVo.getData().forEach(System.out::println);

    }
}
