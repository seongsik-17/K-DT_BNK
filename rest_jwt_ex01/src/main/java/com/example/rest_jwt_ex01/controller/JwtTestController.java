package com.example.rest_jwt_ex01.controller;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest_jwt_ex01.dto.LoginDto;
import com.example.rest_jwt_ex01.utils.JWTUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class JwtTestController {
	@Value("${spring.jwt.secret}")
	private String secretkey;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@PostMapping("/login")
	public String login(@RequestBody LoginDto loginDto, 
				//HttpServletRequest result,//요청(세션을 사용하지 않아서 필요없음 
				HttpServletResponse response) {//응답
		//로그인 성공
		if("user01".equals(loginDto.getUsername())&& "1234".equals(loginDto.getPassword())) {
			//토큰 준비
			String token = makeJwt(loginDto.getUsername(), "user01@email.com");
			//토큰 발행
			response.setHeader("USER-AUTH", token);
			
			return "Good";
		}
		
		return "Bad";
	}

	private String makeJwt(String username, String email) {
		String jwt = jwtUtil.createJwt(username, email, 1000*60*3L);
		String token = "Bearer "+ jwt;
		
		return token;
	}
	
	@GetMapping("/user")
	public String getUserInfo(HttpServletRequest request) {
		String userAuth = request.getHeader("USER-AUTH");
		if(userAuth == null || userAuth.isEmpty()) {
			return "Bad";
		}
		String jwt = userAuth.split(" ")[1];
		String username = jwtUtil.getUsername(jwt);
		String email = jwtUtil.getEmail(jwt);
		
		SecretKey key = Keys.hmacShaKeyFor(secretkey.getBytes(StandardCharsets.UTF_8));
		JwtParser parser = Jwts.parser()
				.verifyWith(key)
				.build();
		Jws<Claims> jws = parser.parseSignedClaims(jwt);//서명
		Claims claims = jws.getPayload();
		
		Date iat = claims.getIssuedAt();
		Date exp = claims.getExpiration();
		
		System.out.println("발급(iat): "+iat);
		System.out.println("발급(exp): "+exp);
		
		return "현재 접속중인 사용자: "+username+", "+email;
	}
	
}
