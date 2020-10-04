package com.springboot.project.domain.user;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Authorities {

    @Id
    private String id;

    @Column(length = 50, nullable = false)
    private String authority;

    @Builder
    public Authorities(String id, String authority){
        this.id = id;
        this.authority = authority;
    }
}
