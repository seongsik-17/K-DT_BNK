package r14;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Login_main {

	public static void main(String[] args) {
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		ArrayList<Create_Acc> sList = new ArrayList<>();
		
		Create_Acc ca1 = new Create_Acc();
		Create_Acc ca2 = new Create_Acc();
		
		sList.add(ca1);
		sList.add(ca2);
		
		
		
		boolean flag = true;
		while(flag) {
			System.out.print("Id>> ");
			String id = sc.nextLine();
			System.out.print("Pw>> ");
			String pw = sc.nextLine();
			for(int i = 0; i < sList.size(); i++) {
				if(sList.get(i).getId().equals(id)&& sList.get(i).getPw().equals(pw)) {
					System.out.println("로그인에 성공하였습니다!");
					System.out.println(sList.get(i).getName()+"님 환영합니다!");
					flag = false;
					break;
				}else {
					System.out.println("아이디와 비밀번호를 확인해주세요");
					continue;
				}
				
			}
		}
		
		
		
		
		
		
		

	}

}
