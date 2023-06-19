package com.liuzhuo.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuzhuo.common.vo.AccountTitleVo;
import com.liuzhuo.common.vo.PageVo;
import com.liuzhuo.domain.AccountTitles;
import com.liuzhuo.service.AccountTitlesService;
import com.liuzhuo.mapper.AccountTitlesMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * @author Administrator
 * @description 针对表【fx_account_titles(会计科目表)】的数据库操作Service实现
 * @createDate 2023-06-19 17:17:51
 */
@Service
public class AccountTitlesServiceImpl extends ServiceImpl<AccountTitlesMapper, AccountTitles>
        implements AccountTitlesService {

    @Resource
    private AccountTitlesMapper accountTitlesMapper;

    public PageVo<AccountTitles> selectList(int pageNum, int pageSize) {
        Page<AccountTitles> page = new Page<>(pageNum, pageSize);
        Page<AccountTitles> accountTitlesPage = accountTitlesMapper.selectPage(page, null);

        // 返回分页对象
        PageVo<AccountTitles> pageVo = new PageVo<>(
                pageNum,
                pageSize,
                accountTitlesPage.getTotal(),
                accountTitlesPage.getRecords()
        );
        return pageVo;
    }
}




