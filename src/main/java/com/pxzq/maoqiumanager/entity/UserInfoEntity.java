package com.pxzq.maoqiumanager.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author pxz
 * @version 1.0
 * @project maoqiu-manager
 * @description 用户信息表Entity
 * @date 2023/12/21 18:45:29
 */
@Data
@TableName("user_info")
public class UserInfoEntity {
    @TableId(value = "ID",type = IdType.AUTO)
    private Long id;
    @TableField("USER_NAME")
    private String userName;
    @TableField("PASS_WORD")
    private String passWord;
    @TableField("E_MAIL")
    private String email;
    @TableField("USER_PERMISSION")
    private Integer userPermission;
    @TableField(value = "CREATE_TIME",fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(value = "UPDATE_TIME",fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
