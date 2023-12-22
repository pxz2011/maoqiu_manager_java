package com.pxzq.maoqiumanager.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author pxz
 * @version 1.0
 * @project maoqiu-manager
 * @description 生活作息
 * @date 2023/12/22 18:46:28
 */
@Data
@Entity
@Table(name = "maoqiu_dailyschedule")

public class MaoqiuDailyScheduleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "SLEEP_TIME")
    private String sleepTime;

    @Column(name = "MAKE_STOOL")
    private String makeStool;

    @Column(name = "USER_ID", nullable = false)
    private Long userId;

    @Column(name = "CREATE_TIME", nullable = false)
    private LocalDateTime createTime;

    @Column(name = "UPDATE_TIME", nullable = false)
    private LocalDateTime updateTime;

    @Column(name = "DATE")
    private LocalDateTime date;
}
