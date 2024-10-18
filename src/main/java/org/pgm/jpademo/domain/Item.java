package org.pgm.jpademo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Table(name="tbl_item")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="item_id")
    private Long id;
    @Column(nullable = false, length = 50)
    private String itemNn;
    @Column(nullable = false, name="item_price")
    private int price;
    @Column(nullable = false)
    private int stockNumber;
    @Lob
    @Column(nullable = false)
    private String itemDetail;
    @CreationTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime regDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @UpdateTimestamp
    private LocalDateTime updateDate;
}
