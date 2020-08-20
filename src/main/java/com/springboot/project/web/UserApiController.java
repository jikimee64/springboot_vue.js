package com.springboot.project.web;

import com.springboot.project.dto.user.UserSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
@RestController
public class UserApiController {

    //private final BoardService boardService;

    /*
     * 회원가입
     *
     * @param param
     * @param result
     * @return
     */
    @PostMapping("signup")
    public void save(@RequestBody @Valid UserSaveRequestDto requestDto) {
        System.out.println("id : " + requestDto.getId());
        System.out.println("password : " + requestDto.getPassword());

        //return boardService.save(requestDto);
    }

}
