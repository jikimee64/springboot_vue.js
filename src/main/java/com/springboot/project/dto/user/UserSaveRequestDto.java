package com.springboot.project.dto.user;

import com.springboot.project.domain.board.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class UserSaveRequestDto {

    @NotBlank
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
