package com.liuzhuo.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuzhuo.common.AccountTitleDto;
import com.liuzhuo.common.vo.AccountTitleVo;
import com.liuzhuo.common.vo.PageVo;
import com.liuzhuo.domain.AccountTitles;
import com.liuzhuo.service.AccountTitlesService;
import com.liuzhuo.mapper.AccountTitlesMapper;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

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

    public PageVo<AccountTitles> selectList(AccountTitleDto dto) {
        Page<AccountTitles> page = new Page<>(dto.getPage(), dto.getLimit());

        // 组装条件
        LambdaQueryWrapper<AccountTitles> where = new LambdaQueryWrapper<>();
        where.like(StringUtils.isNotBlank(dto.getCnName()), AccountTitles::getCnName, dto.getCnName()); // 中文名称
        where.like(StringUtils.isNotBlank(dto.getEnName()), AccountTitles::getEnName, dto.getEnName()); // 英文名称
        where.like(StringUtils.isNotBlank(dto.getCode()), AccountTitles::getCode, dto.getCode()); // 代码
        where.like(StringUtils.isNotBlank(dto.getType()), AccountTitles::getType, dto.getType()); // 会计科目类别
        where.eq(ObjectUtils.isNotEmpty(dto.getLevel()), AccountTitles::getLevel, dto.getLevel()); // 会计科目级别
        where.eq(StringUtils.isNotBlank(dto.getFormat()), AccountTitles::getFormat, dto.getFormat()); // 账页格式

        // 查询分页数据
        Page<AccountTitles> accountTitlesPage = accountTitlesMapper.selectPage(page, where);

        // 返回分页对象
        return new PageVo<>(
                dto.getPage(),
                dto.getLimit(),
                accountTitlesPage.getTotal(),
                accountTitlesPage.getRecords()
        );
    }
}




