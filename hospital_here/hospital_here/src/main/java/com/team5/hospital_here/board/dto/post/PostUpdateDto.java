package com.team5.hospital_here.board.dto.post;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostUpdateDto {
    private Long id;
    private String title;
    private String content;
    private List<String> imageUrls;
}
