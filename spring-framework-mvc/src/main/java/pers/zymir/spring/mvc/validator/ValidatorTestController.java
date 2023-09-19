package pers.zymir.spring.mvc.validator;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.zymir.spring.mvc.validator.group.LoginGroup;
import pers.zymir.spring.mvc.validator.group.RegisterGroup;

@RestController
@RequestMapping("/api/validator")
public class ValidatorTestController {

    @PostMapping("/register")
    public String register(@RequestBody @Validated(RegisterGroup.class) User user) {
        return "OK";
    }

    @PostMapping("/login")
    public String login(@RequestBody @Validated(LoginGroup.class) User user) {
        return "OK";
    }
}
