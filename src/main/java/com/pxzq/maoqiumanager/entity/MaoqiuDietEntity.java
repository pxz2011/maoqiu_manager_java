package com.pxzq.maoqiumanager.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author pxz
 * @version 1.0
 * @project maoqiu-manager
 * @description 饮食信息
 * @date 2023/12/22 18:43:32
 */
@Data
@Entity
@Table(name = "maoqiu_diet")
public class MaoqiuDietEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "DIET_QUANTITY", nullable = false)
    private Integer dietQuantity;

    @Column(name = "FOOD")
    private String food;

    @Column(name = "IS_NORMAL", nullable = false)
    private Integer isNormal;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "EXPENDITURE", precision = 10, scale = 2)
    private BigDecimal expenditure;

    @Column(name = "DATE", nullable = false)
    private LocalDateTime date;

    @Column(name = "CREATE_TIME", nullable = false)
    private LocalDateTime createTime;

    @Column(name = "UPDATE_TIME", nullable = false)
    private LocalDateTime updateTime;

    @Column(name = "USER_ID", nullable = false)
    private Long userId;
}
