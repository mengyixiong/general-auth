package com.liuzhuo.common.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountTitleVo {

    private Long id;

    /**
     * 上一级，0为顶级
     */
    private Integer pid;

    /**
     * 级次1,2,3,4,5
     */
    private Long level;

    /**
     * 科目代码
     */
    private String code;

    /**
     * 中文名
     */
    private String cnName;

    /**
     * 英文名
     */
    private String enName;

    /**
     * 科目类型asset:资产类,profit:损益类,cost:成本类,common:共同类,ownership:所有者权益类,liabilities:负债类,settlement:结算对象类
     */
    private String type;

    /**
     * 账页格式amount:金额式,currencyAmount:外币式金额
     */
    private String format;

    /**
     * 助记码
     */
    private String abb;

    /**
     * 核算币种
     */
    private String currency;

    /**
     * 主体ID
     */
    private Long comId;

    /**
     * 是否是外币核算Y是N否
     */
    private String foreign;

    /**
     * 余额方向Y借方N贷方
     */
    private String dn;

    /**
     * 是否冻结Y是N否
     */
    private String freezed;

    /**
     * 期末余额
     */
    private BigDecimal foreignBalance;

    /**
     * 核算币种余额统计
     */
    private BigDecimal balance;

    /**
     * 是否末级科目Y是N否
     */
    private String isLast;

    /**
     * 年初余额
     */
    private BigDecimal yearBegining;

    /**
     * 年初余额
     */
    private BigDecimal foreignYearBegining;

    /**
     * 是否现金流科目Y是N否
     */
    private String cash;

    /**
     * 开户时的余额
     */
    private BigDecimal accountOpening;

    /**
     * 开户时的外部余额
     */
    private BigDecimal foreignAccountOpening;

    /**
     * 往来单位
     */
    private String venderRequired;

    /**
     * 员工
     */
    private String clerkRequired;

    /**
     * 部门
     */
    private String teamRequired;

    /**
     * 分公司
     */
    private String branchRequired;
}
