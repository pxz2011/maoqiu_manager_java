package com.pxzq.maoqiumanager.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author pxz
 * @version 1.0
 * @project maoqiu-manager
 * @description 生活信息表
 * @date 2023/12/22 18:39:40
 */

@Data
@Entity
@Table(name = "maoqiu_live")
public class MaoqiuLiveEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "ID", nullable = false)
   private Long id;

   @Column(name = "BATH")
   private String bath;

   @Column(name = "GROOMING")
   private String grooming;

   @Column(name = "NAIL")
   private String nail;

   @Column(name = "ACTIVITY")
   private String activity;

   @Column(name = "DAILYUSE_EXPENDITURE")
   private String dailyUseExpenditure;

   @Column(name = "CREATE_TIME", nullable = false)
   private LocalDateTime createTime;

   @Column(name = "UPDATE_TIME", nullable = false)
   private LocalDateTime updateTime;

   @Column(name = "USER_ID", nullable = false)
   private Long userId;

   @Column(name = "DATE", nullable = false)
   private LocalDateTime date;
}
