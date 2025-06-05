package com.example.rest02.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Getter
public abstract class BaseEntity {
	
	//Board에 있던 내용을 옮긴거
	@Column( name="regdate",updatable = false)
	@CreatedDate
	private LocalDateTime regDate;
	
	
	@Column(name="moddate")
	@LastModifiedDate
	private LocalDateTime modDate;//마지막 수정 일자를 저장

}
