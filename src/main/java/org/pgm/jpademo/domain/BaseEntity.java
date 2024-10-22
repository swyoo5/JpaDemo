package org.pgm.jpademo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

//엔터티를 만들 때 공통되는 부분 부모 엔터티로 빼냄
@Getter
@MappedSuperclass // 부모 클래스임을 알림
@EntityListeners(value = {AuditingEntityListener.class}) // 자동으로 리스너를 만들어서 사용
abstract public class BaseEntity {
    @CreationTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name="regdate", updatable=false)
    private LocalDate regDate;

    @UpdateTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name="moddate")
    private LocalDateTime modDate;
}
