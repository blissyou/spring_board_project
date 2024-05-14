package com.vueSpring.board_project.web;

import com.vueSpring.board_project.entity.BoardEntity;
import com.vueSpring.board_project.model.Header;
import com.vueSpring.board_project.services.BoardService;
import com.vueSpring.board_project.web.dtos.BoardDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController

@RequestMapping("/board")
public class BoardController{
    private final BoardService boardService;

    @GetMapping("/")
    public Header<List<BoardDto>> boardList(
            @PageableDefault(sort = {"idx"}) Pageable pageable
    ) {
        return boardService.getBoardList(pageable);
    }
    @GetMapping("/{id}")
    public BoardDto getBoard(@PathVariable Long id) {
        return boardService.getBoard(id);
    }

    @PostMapping("/list")
    public BoardEntity create(@RequestBody BoardDto boardDto){
        return boardService.create(boardDto);
    }

    @PatchMapping("/{id}")
    public BoardEntity update(@PathVariable Long id, @RequestBody BoardDto boardDto){return  boardService.update(boardDto);}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        boardService.delete(id);
    }

}