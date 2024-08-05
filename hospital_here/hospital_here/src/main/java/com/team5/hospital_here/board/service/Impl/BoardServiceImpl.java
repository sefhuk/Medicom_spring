package com.team5.hospital_here.board.service.Impl;

import com.team5.hospital_here.board.domain.Board;
import com.team5.hospital_here.board.dto.board.BoardRequestDto;
import com.team5.hospital_here.board.dto.board.BoardResponseDto;
import com.team5.hospital_here.board.dto.board.BoardUpdateDto;
import com.team5.hospital_here.board.repository.BoardRepository;
import com.team5.hospital_here.board.service.BoardService;
import com.team5.hospital_here.common.exception.CustomException;
import com.team5.hospital_here.common.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    @Transactional
    @Override
    public BoardResponseDto createBoard(BoardRequestDto boardRequestDto) {
        Board board = boardRequestDto.toEntity();
        Board createdBoard = boardRepository.save(board);
        return createdBoard.toResponseDto();
    }
    @Transactional
    @Override
    public BoardResponseDto updateBoard(BoardUpdateDto boardUpdateDto) {
        Board board = boardRepository.findById(boardUpdateDto.getId())
                .orElseThrow(() -> new CustomException(ErrorCode.BOARD_NOT_FOUND));
        board.update(boardUpdateDto);
        Board updatedBoard = boardRepository.save(board);
        return updatedBoard.toResponseDto();
    }
    @Transactional
    @Override
    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }

    @Override
    public Page<BoardResponseDto> findAllBoards(Pageable pageable) {
        Page<Board> boards = boardRepository.findAll(pageable);
        return boards.map(Board::toResponseDto);
    }

    @Override
    public Optional<BoardResponseDto> findBoardById(Long id) {
        Optional<Board> optionalBoard = boardRepository.findById(id);
        if (optionalBoard.isPresent()) {
            Board board = optionalBoard.get();
            return Optional.ofNullable(board.toResponseDto());
        }
        return Optional.empty();
    }

    @Override
    public Page<BoardResponseDto> findBoardsByName(String name, Pageable pageable) {
        Page<Board> boards = boardRepository.findByNameContainingIgnoreCase(name, pageable);
        return boards.map(Board::toResponseDto);
    }
}
