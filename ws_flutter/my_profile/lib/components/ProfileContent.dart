import 'package:flutter/material.dart';

class Profilecontent extends StatelessWidget {
  const Profilecontent({super.key});

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(10.0),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          
          SizedBox(height: 10),
          Text(" 연락처: 010-4499-5295"),
          Text(" 이메일: mss9810@naver.com"),
          Text(" GitHub: https://github.com/seongsik-17"),
          SizedBox(height: 10),
          Text(" 소개:"),
          Text("NCS 기반 백엔드 자바/스프링 웹 개발자 양성과정 이수 중입니다."),
          SizedBox(height: 10),
          Text("보유 스킬"),
          Text("Java, C, Python, Spring, OracleDB, MariaDB",style: TextStyle(fontSize: 20),)
          
        ],
      ),
    );
    
  }

 
}
