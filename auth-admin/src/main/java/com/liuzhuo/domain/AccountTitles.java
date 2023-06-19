package com.liuzhuo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 会计科目表
 * @TableName fx_account_titles
 */
@TableName(value ="fx_account_titles")
@Data
public class AccountTitles implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 上一级，0为顶级
     */
    @TableField(value = "pid")
    private Integer pid;

    /**
     * 级次1,2,3,4,5
     */
    @TableField(value = "level")
    private Long level;

    /**
     * 科目代码
     */
    @TableField(value = "code")
    private String code;

    /**
     * 中文名
     */
    @TableField(value = "cn_name")
    private String cnName;

    /**
     * 英文名
     */
    @TableField(value = "en_name")
    private String enName;

    /**
     * 科目类型asset:资产类,profit:损益类,cost:成本类,common:共同类,ownership:所有者权益类,liabilities:负债类,settlement:结算对象类
     */
    @TableField(value = "type")
    private String type;

    /**
     * 账页格式amount:金额式,currencyAmount:外币式金额
     */
    @TableField(value = "format")
    private String format;

    /**
     * 助记码
     */
    @TableField(value = "abb")
    private String abb;

    /**
     * 核算币种
     */
    @TableField(value = "currency")
    private String currency;

    /**
     * 主体ID
     */
    @TableField(value = "com_id")
    private Long comId;

    /**
     * 是否是外币核算Y是N否
     */
    @TableField(value = "foreign_currency")
    private String foreignCurrency;

    /**
     * 余额方向Y借方N贷方
     */
    @TableField(value = "dn")
    private String dn;

    /**
     * 是否冻结Y是N否
     */
    @TableField(value = "freezed")
    private String freezed;

    /**
     * 期末余额
     */
    @TableField(value = "foreign_balance")
    private BigDecimal foreignBalance;

    /**
     * 核算币种余额统计
     */
    @TableField(value = "balance")
    private BigDecimal balance;

    /**
     * 是否末级科目Y是N否
     */
    @TableField(value = "is_last")
    private String isLast;

    /**
     * 年初余额
     */
    @TableField(value = "year_begining")
    private BigDecimal yearBegining;

    /**
     * 年初余额
     */
    @TableField(value = "foreign_year_begining")
    private BigDecimal foreignYearBegining;

    /**
     * 是否现金流科目Y是N否
     */
    @TableField(value = "cash")
    private String cash;

    /**
     * 开户时的余额
     */
    @TableField(value = "account_opening")
    private BigDecimal accountOpening;

    /**
     * 开户时的外部余额
     */
    @TableField(value = "foreign_account_opening")
    private BigDecimal foreignAccountOpening;

    /**
     * 往来单位
     */
    @TableField(value = "vender_required")
    private String venderRequired;

    /**
     * 员工
     */
    @TableField(value = "clerk_required")
    private String clerkRequired;

    /**
     * 部门
     */
    @TableField(value = "team_required")
    private String teamRequired;

    /**
     * 分公司
     */
    @TableField(value = "branch_required")
    private String branchRequired;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}