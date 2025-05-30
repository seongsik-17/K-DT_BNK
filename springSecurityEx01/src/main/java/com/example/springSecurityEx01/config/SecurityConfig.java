package com.example.springSecurityEx01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration//Security 권한,인가 부분을 담당
@EnableWebSecurity
public class SecurityConfig {
	@Bean//패스워드 암호화 객체
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		
		return new BCryptPasswordEncoder();
	};
	@Bean//사용권한이 없어도 접근 가능하도록 만들어짐
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http.authorizeHttpRequests((auth) -> auth
				.requestMatchers("/","/regMember","/regist").permitAll()
				.requestMatchers("/member/**").hasAnyRole("ADMIN","MEMBER")//하위 페이지는 전부다 로그인이 필요해요
				.requestMatchers("/admin").hasRole("ADMIN")//접근 권한 설정
				.anyRequest().authenticated()
				);				
		http.csrf(csrf -> csrf.disable());
		
		http.formLogin((auth) -> auth
				.loginPage("/login")
				.loginProcessingUrl("/loginProc")
				.defaultSuccessUrl("/member/welcome")
				.failureUrl("/fail")
				.permitAll());
		return http.build();
		 
	}
}
