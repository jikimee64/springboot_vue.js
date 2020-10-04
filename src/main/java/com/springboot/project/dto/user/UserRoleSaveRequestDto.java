package com.springboot.project.dto.user;

import com.springboot.project.domain.user.Authorities;
import com.springboot.project.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class UserRoleSaveRequestDto {

    private String id;

    private String authority;

    @Builder
    public UserRoleSaveRequestDto(String id, String authority) {
        this.id = id;
        this.authority = authority;
    }

    public Authorities toEntity() {
        return Authorities.builder()
                .id(id)
                .authority(authority)
                .build();
    }
}
