package com.springboot.project.web;

import com.springboot.project.domain.board.Board;
import com.springboot.project.domain.board.BoardRepository;
import com.springboot.project.dto.board.BoardSaveRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BoardApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private BoardRepository boardRepository;

    @After
    public void tearDown() throws Exception {
        boardRepository.deleteAll();
    }

    @Test //302 Found 에러
    public void Board_등록된다() throws Exception {

        String writer = "writer";
        String title = "title";
        String content = "content";
        BoardSaveRequestDto requestDto = BoardSaveRequestDto.builder()
                .writer(writer)
                .title(title)
                .content(content)
                .build();

        String url = "http://localhost:" + port + "/api/v1/board";

        System.out.println("url : " + url);
        System.out.println("requestDto : " + requestDto.getTitle());
        System.out.println("requestDto : " + requestDto.getContent());
        System.out.println("requestDto : " + requestDto.getWriter());

        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        //assertThat(responseEntity.getBody()).isGreaterThan(0L);
        List<Board> all = boardRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(title);
        assertThat(all.get(0).getContent()).isEqualTo(content);
    }

    private void title() {
    }

}
