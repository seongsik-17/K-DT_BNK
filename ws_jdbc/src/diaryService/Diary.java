package diaryService;

import java.io.IOException;
import java.util.Scanner;

public class Diary {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		Diary_Service ds = new Diary_Service();
		while(true) {
			System.out.println("-----------Main Menu-----------");
			System.out.println("1.일기쓰기 2.일기 조회하기 3.일기 이어쓰기");
			System.out.println("-------------------------------");
			System.out.print("원하는 항목을 선택해주세요>> ");
			int menu = sc.nextInt();
			switch(menu) {
			case 1 -> ds.writeDiary(ds.newDiary());
			case 2 -> ds.readDiary();
			default -> System.out.println("잘못된 입력입니다.");
			
			}
		}
		
		
		
		

	}

}
