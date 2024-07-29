package com.team5.hospital_here.board.controller;

import com.team5.hospital_here.board.dto.board.BoardRequestDto;
import com.team5.hospital_here.board.dto.board.BoardResponseDto;
import com.team5.hospital_here.board.dto.board.BoardUpdateDto;
import com.team5.hospital_here.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    public ResponseEntity<BoardResponseDto> createBoard(@RequestBody BoardRequestDto boardRequestDto) {
        BoardResponseDto boardResponseDto = boardService.createBoard(boardRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(boardResponseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BoardResponseDto> updateBoard(@PathVariable Long id, @RequestBody BoardUpdateDto boardUpdateDto) {
        boardUpdateDto.setId(id);
        BoardResponseDto boardResponseDto = boardService.updateBoard(boardUpdateDto);
        return ResponseEntity.ok(boardResponseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoard(@PathVariable Long id) {
        boardService.deleteBoard(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<BoardResponseDto>> getAllBoards() {
        List<BoardResponseDto> boards = boardService.findAllBoards();
        return ResponseEntity.ok(boards);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardResponseDto> getBoardById(@PathVariable Long id) {
        return boardService.findBoardById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}