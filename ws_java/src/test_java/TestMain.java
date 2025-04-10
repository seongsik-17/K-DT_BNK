package test_java;

import java.util.List;
import java.util.Scanner;

public class TestMain {

	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("어느 DBMS를 사용하겠습니까?");
		System.out.println("1. 오라클 \t 2. 마리아디비");
		int answer = sc.nextInt();
		
		
		
		IMapper_crud mapper = null;//인터페이스 타입의 변수 mapper생성
		
		if(answer == 1) {
			mapper = new Mapper_Oracle();
		}else if(answer == 2) {
			mapper = new Mapper_Maria();
		}
		
		
		//멤버 데이터 입력
		Member member = new Member();
		mapper.create(member);
		
	    //멤버 전체조회
		List<Member> list = mapper.readAll();
		
		//멤버 목록 콘솔 출력
		for(Member m : list) {
			System.out.println(m.toString());
		}
		
		//멤버 한명 조회(멤버번호(정수))
		Member m = mapper.read(10);
		
		
		
		
	}

}
