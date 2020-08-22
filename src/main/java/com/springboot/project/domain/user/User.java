package com.springboot.project.domain.user;

import com.springboot.project.domain.TimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User extends TimeEntity {

    @Id
    private String id;

    @Column(length = 500, nullable = false)
    private String password;

    private Long enabled;

    private String snstype;

    @Builder
    public User(String id, String password, Long enabled, String snstype){
        this.id = id;
        this.password = password;
        this.enabled = enabled;
        this.snstype = snstype;
    }

    @PrePersist
    public void prePersist() {
        this.enabled = this.enabled == null ? 1 : this.enabled;
        this.snstype = this.snstype == null ? "normal" : this.snstype;
    }

}
