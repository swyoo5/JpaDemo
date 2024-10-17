package org.pgm.jpademo.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Board {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increment
    private Long bno;
    private String title;
    private String content;
    private String writer;
    private Date postdate;
    private int visitcount;
}
