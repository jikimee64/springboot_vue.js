package com.springboot.project.dto.user;

import com.springboot.project.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class UserSaveRequestDto {

    @Size(max = 10, message = "아이디는 10글자 이하 입력해주세요")
    private String id;

    @NotBlank
    private String password;

    @Builder
    public UserSaveRequestDto(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public User toEntity() {
        return User.builder()
                .id(id)
                .password(password)
                .build();
    }
}
