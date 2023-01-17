package com.AkhilDev.ecommerce.Controller;

import com.AkhilDev.ecommerce.Dto.SignUpDto;
import com.AkhilDev.ecommerce.Dto.User.SignUpResponse;
import com.AkhilDev.ecommerce.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public SignUpResponse signUp(@RequestBody SignUpDto signUpDto){
        return userService.signUp(signUpDto);
    }

}
