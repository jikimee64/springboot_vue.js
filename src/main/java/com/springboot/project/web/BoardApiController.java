package com.springboot.project.web;

import com.springboot.project.dto.board.BoardSaveRequestDto;
import com.springboot.project.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/api/v1/board")
@RestController
public class BoardApiController {

    private final BoardService boardService;

    @PostMapping("")
    public Long save(@Valid @RequestBody BoardSaveRequestDto requestDto) {
        return boardService.save(requestDto);
    }

}
