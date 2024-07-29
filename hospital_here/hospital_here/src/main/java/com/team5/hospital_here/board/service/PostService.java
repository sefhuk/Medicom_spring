package com.team5.hospital_here.board.service;

import com.team5.hospital_here.board.domain.Comment;
import com.team5.hospital_here.board.domain.Post;
import com.team5.hospital_here.board.dto.post.PostRequestDto;
import com.team5.hospital_here.board.dto.post.PostResponseDto;
import com.team5.hospital_here.board.dto.post.PostUpdateDto;
import com.team5.hospital_here.board.dto.postImg.PostImgRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PostService {
    PostResponseDto createPost(PostRequestDto postRequestDto);
    PostResponseDto updatePost(PostUpdateDto postUpdateDto);
    void deletePost(Long id);
    Page<PostResponseDto> findAllPosts(Pageable pageable);
    Page<PostResponseDto> findPostsByBoardId(Long boardId, Pageable pageable);
    Optional<PostResponseDto> findPostById(Long id);
    List<PostResponseDto> searchPostsByTitle(String title);

    //void addPostImage(Long postId, PostImgRequestDto postImgRequestDto);
    //List<PostResponseDto> findAllPosts();
    //List<PostResponseDto> findPostsByBoardId(Long boardId);
}
