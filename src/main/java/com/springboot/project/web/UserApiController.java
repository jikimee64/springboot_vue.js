package com.springboot.project.web;

import com.springboot.project.dto.user.UserSaveRequestDto;
import com.springboot.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
@RestController
public class UserApiController {

    private final UserService userService;

    @PostMapping("signup")
    public String signup(@RequestBody @Valid UserSaveRequestDto requestDto) {
        return userService.signup(requestDto);
    }

    @PostMapping("login")
    public String login(@RequestBody @Valid UserSaveRequestDto requestDto) {
        return userService.save(requestDto);
    }

}
