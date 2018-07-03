package com.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "t_user")
@ApiModel
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ApiModelProperty("用户名")
    @NonNull
    private String username;

    @ApiModelProperty("密码")
    @NonNull
    private String password;
}
