package com.springboot.project.domain.user;

import com.springboot.project.domain.board.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

//    @After
//    public void cleanup() {
//        userRepository.deleteAll();
//    }

    @Test
    public void 회원저장_불러오기(){
        String id = "dncjf64";
        String password = "rladncjf1";

        userRepository.save(User.builder()
                .id(id)
                .password(password)
                .enabled((long)1.0)
                .build());

        List<User> userList = userRepository.findAll();

        User user = userList.get(0);
        assertThat(user.getId()).isEqualTo(id);
        assertThat(user.getPassword()).isEqualTo(password);

    }

}

