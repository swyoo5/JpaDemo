package org.pgm.jpademo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {
    private Long bno;
    @NotEmpty
    @Size(min = 2, max = 200)
    private String title;
    @NotEmpty
    private String content;
    @NotEmpty
    private String writer;
    private int visitcount;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
}
