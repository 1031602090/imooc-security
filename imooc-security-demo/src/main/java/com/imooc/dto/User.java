package com.imooc.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.imooc.validator.MyConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Past;
import java.util.Date;

/**
 * @author hang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    public interface SimpleView{}
    public interface DetailView extends SimpleView{}

    @JsonView(SimpleView.class)
    @MyConstraint(message = "username 测试")
    private String username;

    @NotBlank(message = "密码不能为空！")
    @JsonView(DetailView.class)
    private String password;

    @JsonView(SimpleView.class)
    private String id;

    @Past(message = "生日必须为之前的时间")
    @JsonView(SimpleView.class)
    private Date date;
}
