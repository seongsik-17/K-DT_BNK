package com.example.simpleBoard01.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="tbl_user3")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer user_id;
	@Column(length = 30)
	@Size(max = 30)
	private  String username;
	@Size(min=4, message = "비밀번호는 4자리 이상이어야 합니다!!")
	private String password;
	private String name;
	@Column(length=13)
	@Size(max=13,message = "휴대폰 번호는 최대 13자리 까지 입력이 가능합니다.")
	private String phone;	
	
}
