package c06;

import java.util.HashSet;

public class Member_Test {

	public static void main(String[] args) {
		Member m1  = new Member();
		m1.setMno(1);
		m1.setName("aaa");
		m1.setPhone("010-1111-2222");
		//System.out.println(m1);
		
		Member m2 =  new Member();
		
		m2.setMno(1);
		m2.setName("aaa");
		m2.setPhone("010-1111-2222");
		//System.out.println(m2);
		
		System.out.println(m1==m2);//false
		//false
		System.out.println(m1.equals(m2));//내용이 같아도 False가 나온다 ------------>true로 바뀜
		//인스턴스를 비교하는 클래스를 만들때는 obj equals를 오버라이딩 해서 써라!!!!!
		//System.out.println(m1 == m3);//주소를 비교중이다.
		
		HashSet<Member> hs1 = new HashSet<>();//중복을 불허하는 알고리즘
		//equals 만 사용해서 비교하는것이 아니라 Hash메소드도 함께 오버라이딩을 해줘야 인스턴스 비교가 올바르게 이루어진다. ->자바의 원칙
		
		hs1.add(m1);
		hs1.add(m2);
		System.out.println(hs1.size()); //---->데이터가 Hash 알고리즘으로 들어갸려면
		

	}

}
