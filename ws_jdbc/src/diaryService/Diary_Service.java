package diaryService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Diary_Service {
	File file;
	FileReader fr;
	BufferedReader br;
	FileWriter fw;

	// 일기 생성
	public Diary_Service() {
	}

	Scanner sc = new Scanner(System.in);

	public String newDiary() {

		System.out.println("오늘의 날짜를 입력헤주세요");
		System.out.print(">> ");
		String date = sc.nextLine();
		file = new File("C:/temp/jv_test/" + date + ".txt");
		try {
			if (file.createNewFile()) {
				System.out.println(date + "의 일기가 생성되었습니다...");
			} else {
				System.out.println("해당 날짜의 일기가 이미 존재합니다");
				
			}
		} catch (IOException e) {
			System.out.println("---------------");
			System.out.println("일기 생성중 문제 발생");
			System.out.println("다시 시도해주세요...");
			System.out.println("---------------");
		}
		return date;
	}

	// 일기쓰기
	public void writeDiary(String s) throws IOException {
		try {

			System.out.println("일기 내용을 작성합니다...");
			fw = new FileWriter("C:/temp/jv_test/" + s + ".txt");
			System.out.println("작성하실 내용을 입력해주세요\n엔터를 누르면 기록이 종료됩니다 ▼ ");
			String detail = sc.nextLine();
			fw.write(detail);
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// 일기 조회
	public void readDiary() throws IOException {
		while (true) {
			System.out.println("조회를 원하는 날짜를 입력해주세요");
			String date = sc.nextLine();
			file = new File("C:/temp/jv_test/" + date + ".txt");

			if (file.exists()) {
				try {
					fr = new FileReader("C:/temp/jv_test/" + date + ".txt");
					br = new BufferedReader(fr);
					String s = null;
					System.out.println(date + "의 내용▼");
					while ((s = br.readLine()) != null) {

						System.out.println(s);
					}

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					fr.close();
					br.close();
				}
				break;
			} else {
				System.out.println("해당 날짜에 일기가 없습니다.");
				System.out.println("메인으로 나가시겠습니까? 1.예 2.아니오");
				System.out.print(">> ");
				int menu = sc.nextInt();
				if (menu == 1) {
					break;
				} else if (menu == 2) {
					continue;
				} else {
					System.out.println("잘못된 입력입니다...");
					break;
				}
			}

		}

	}

}
