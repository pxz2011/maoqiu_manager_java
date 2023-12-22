package com.pxzq.maoqiumanager.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author pxz
 * @version 1.0
 * @project maoqiu-manager
 * @description 用户信息表Entity
 * @date 2023/12/21 18:45:29
 */
@Data
@Entity
@Table(name = "user_info")
public class UserInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "USER_NAME", nullable = false)
    private String userName;

    @Column(name = "PASS_WORD", nullable = false)
    private String passWord;

    @Column(name = "E-MAIL", nullable = false)
    private String email;

    @Column(name = "USER_PERMISSION", nullable = false)
    private Integer userPermission;

    @Column(name = "CREATE_TIME", nullable = false)
    private LocalDateTime createTime;

    @Column(name = "UPDATE_TIME", nullable = false)
    private LocalDateTime updateTime;
}
