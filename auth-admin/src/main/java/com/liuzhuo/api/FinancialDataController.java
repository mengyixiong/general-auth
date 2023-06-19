package com.liuzhuo.api;

import com.liuzhuo.common.vo.AccountTitleVo;
import com.liuzhuo.common.vo.PageVo;
import com.liuzhuo.domain.AccountTitles;
import com.liuzhuo.service.AccountTitlesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "财务资料")
@RestController
@RequestMapping("/api/financialdata")
public class FinancialDataController {

    @Resource
    private AccountTitlesService accountTitlesService;

    @ApiOperation("获取所有会计科目")
    @GetMapping("/account_titles")
    public PageVo<AccountTitles> accountTitles(int page, int limit) {
        return accountTitlesService.selectList(page, limit);
    }
}
