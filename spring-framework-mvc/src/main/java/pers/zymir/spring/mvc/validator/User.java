package pers.zymir.spring.mvc.validator;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import pers.zymir.spring.mvc.validator.group.LoginGroup;
import pers.zymir.spring.mvc.validator.group.RegisterGroup;

import javax.validation.constraints.NotBlank;

@Data
public class User {
    // 指定分组，如果不指定则为Default分组
    @NotBlank(message = "用户名不能为空", groups = {RegisterGroup.class, LoginGroup.class})
    @Length(min = 1, max = 10, message = "用户名长度在1-10之间")
    private String username;

    @NotBlank(message = "密码不能为空", groups = {RegisterGroup.class, LoginGroup.class})
    @Length(min = 1, max = 10, message = "用户名长度在1-10之间")
    private String password;

    @NotBlank(message = "确认密码不能为空", groups = RegisterGroup.class)
    private String checkPassword;

    // 自定义校验器
    @Gender(groups = {RegisterGroup.class, LoginGroup.class})
    private Integer gender;
}
