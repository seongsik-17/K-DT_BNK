package com.example.rest_jwt_ex01.utils;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;

@Component
public class JWTUtil {
	private SecretKey secretKey;
	
	public JWTUtil(@Value("${spring.jwt.secret}")String secret) {
		this.secretKey = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8),
				Jwts.SIG.HS256.key().build().getAlgorithm());//암호화
		
		System.out.println("SecretKey: " + secretKey.toString()+", Algritm: "+ secretKey.getAlgorithm());
	}
	
	//토큰에서 사용자 정보 추출
	public String getUsername(String token) {
		String username = Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token)
				.getPayload().get("username", String.class);
		
		return username;
	}
	
	//로그인 성공시 토큰 생성
	public String createJwt(String username) {//JSON이 문자열이라서 String타입임
		String token = Jwts.builder()//메서드 체이닝
						.claim("username",username)
						.issuedAt(new Date(System.currentTimeMillis()))
						.signWith(secretKey)
						.compact();
		return token;
	}
}

