package com.team5.hospital_here.board.dto.post;

import com.team5.hospital_here.board.domain.PostImg;
import com.team5.hospital_here.board.dto.postImg.PostImgRequestDto;
import com.team5.hospital_here.board.dto.postImg.PostImgResponseDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostResponseDto {
    private Long id;
    private Long boardId;
    private Long userId;
    private String title;
    private String content;
    private List<PostImgResponseDto> imageUrls;
    private String userName;
    private Long viewCount;
    private Long likeCount;
    private String userImg;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
