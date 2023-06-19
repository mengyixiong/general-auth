package com.liuzhuo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liuzhuo.common.AccountTitleDto;
import com.liuzhuo.common.vo.PageVo;
import com.liuzhuo.domain.AccountTitles;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【fx_account_titles(会计科目表)】的数据库操作Service
 * @createDate 2023-06-19 17:17:51
 */
public interface AccountTitlesService extends IService<AccountTitles> {

    /**
     * 查询会计科目表列表
     *
     * @param dto
     * @return
     */
    PageVo<AccountTitles> selectList(AccountTitleDto dto);
}
