package com.pxzq.maoqiumanager.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
@TableName("maoqiu_diet")
public class MaoqiuDietEntity {

    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;
    @TableField("DIET_QUANTITY")
    private Integer dietQuantity;
    @TableField("FOOD")
    private String food;
    @TableField("IS_NORMAL")
    private Integer isNormal;
    @TableField("DESCRIPTION")
    private String description;
    @TableField("EXPENDITURE")
    private BigDecimal expenditure;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date date;
    @TableField(value = "CREATE_TIME", fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @TableField(value = "UPDATE_TIME", fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
    @TableField("USER_ID")
    private Long userId;
}
