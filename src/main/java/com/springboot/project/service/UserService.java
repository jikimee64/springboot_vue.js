package com.springboot.project.service;

import com.springboot.project.domain.user.AuthoritiesRepository;
import com.springboot.project.domain.user.Role;
import com.springboot.project.domain.user.UserRepository;
import com.springboot.project.dto.user.UserRoleSaveRequestDto;
import com.springboot.project.dto.user.UserSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    private final AuthoritiesRepository authoritiesRepository;

    /**
     * 회원정보 저장
     *
     * @param requestDto 회원정보가 들어있는 DTO
     * @return 저장되는 회원의 PK
     */
    public String save(UserSaveRequestDto requestDto) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        requestDto.setPassword(encoder.encode(requestDto.getPassword()));
        return userRepository.save(requestDto.toEntity()).getId();
    }

    /**
     * 회원Role 저장
     *
     * @param requestDto 회원정보가 들어있는 DTO
     * @return 저장되는 회원의 PK
     */
    public String saveAuthorities(UserSaveRequestDto requestDto) {
        UserRoleSaveRequestDto roleDto = new UserRoleSaveRequestDto();
        roleDto.setId(requestDto.getId());
        if(requestDto.getId().equals("admin")){
            roleDto.setAuthority(Role.ADMIN.getValue());
        }else{
            roleDto.setAuthority(Role.USER.getValue());
        }
        return authoritiesRepository.save(roleDto.toEntity()).getId();
    }

    @Transactional
    public String signup(UserSaveRequestDto requestDto){
        save(requestDto);
        saveAuthorities(requestDto);
        return "ss";
    }

}
