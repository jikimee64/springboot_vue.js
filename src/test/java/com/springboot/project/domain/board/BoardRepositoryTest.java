package com.springboot.project.domain.board;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTest {

    @Autowired
    BoardRepository boardRepository;

    @After
    public void cleanup() {
        boardRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
        String title = "테스트 게시글";
        String content = "테스트 본문";

        boardRepository.save(Board.builder()
                .writer("jojoldu@gmail.com")
                .title(title)
                .content(content)
                .build());

        List<Board> boardList = boardRepository.findAll();

        Board board = boardList.get(0);
        assertThat(board.getTitle()).isEqualTo(title);
        assertThat(board.getContent()).isEqualTo(content);

    }

    @Test
    public void TimeEntity_등록() {
        //given
        LocalDateTime now = LocalDateTime.of(2019, 6, 4, 0, 0, 0);
        boardRepository.save(Board.builder()
                .writer("jojolssdu@gmail.com")
                .title("title")
                .content("content")
                .build());
        //when
        List<Board> postsList = boardRepository.findAll();

        //then
        Board posts = postsList.get(0);

        System.out.println(">>>>>>>>> createDate=" + posts.getCreated_date() + ", modifiedDate=" + posts.getUpdated_date());

        assertThat(posts.getCreated_date()).isAfter(now);
        assertThat(posts.getUpdated_date()).isAfter(now);
    }

}
