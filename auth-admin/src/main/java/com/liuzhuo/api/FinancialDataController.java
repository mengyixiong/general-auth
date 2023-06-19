package com.liuzhuo.api;

import com.liuzhuo.common.AccountTitleDto;
import com.liuzhuo.common.vo.AccountTitleVo;
import com.liuzhuo.common.vo.PageVo;
import com.liuzhuo.domain.AccountTitles;
import com.liuzhuo.service.AccountTitlesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "财务资料")
@RestController
@RequestMapping("/api/financialdata")
public class FinancialDataController {

    @Resource
    private AccountTitlesService accountTitlesService;

    @ApiOperation("获取所有会计科目")
    @PostMapping("/account_titles")
    public PageVo<AccountTitles> accountTitles(AccountTitleDto dto) {
        return accountTitlesService.selectList(dto);
    }
}
