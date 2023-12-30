package com.pxzq.maoqiumanager.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author pxz
 * @version 1.0
 * @project maoqiu-manager
 * @description 生活信息表
 * @date 2023/12/22 18:39:40 
 */

@TableName("maoqiu_live")
@Data
public class MaoqiuLiveEntity implements Serializable {

   @Serial
   private static final long serialVersionUID = 1L;

   /**
    * id
    */
   @TableId(value = "ID", type = IdType.AUTO)
   private Long id;

   /**
    * 洗澡情况
    */
   @TableField("BATH")
   private String bath;

   /**
    * 梳毛情况
    */
   @TableField("GROOMING")
   private String grooming;

   /**
    * 剪指甲情况
    */
   @TableField("NAIL")
   private String nail;

   /**
    * 活动情况
    */
   @TableField("ACTIVITY")
   private String activity;

   /**
    * 支出
    */
   @TableField("DAILYUSE_EXPENDITURE")
   private String dailyuseExpenditure;

   /**
    * 创建时间
    */
   @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
   @TableField(value = "CREATE_TIME", fill = FieldFill.INSERT)
   private Date createTime;

   /**
    * 更新时间
    */
   @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
   @TableField(value = "UPDATE_TIME", fill = FieldFill.INSERT_UPDATE)
   private Date updateTime;

   /**
    * 用户ID
    */
   @TableField("USER_ID")
   private Long userId;

   /**
    * 日期
    */
   @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd")
   @TableField("DATE")
   private Date date;
}