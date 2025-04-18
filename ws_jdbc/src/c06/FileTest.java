package c06;

import java.io.File;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) {
		File file = new File("C:/temp/jv_test/test.txt");
		
		if(file.exists()) {
			System.out.println("파일이름>> "+file.getName());
			System.out.println("절대경로>> "+file.getAbsolutePath());
			System.out.println("파일크기>> "+file.length());
		}
		else {
			System.out.println("파일 없음");
		}
		
		File file2 = new File("C:/temp/jv_test/test.txt");
		try {
			if(file2.createNewFile()) {
				System.out.println("파일이 생성되었습니다..."+file2.getName());
			}else {
				System.out.println("파일이 이미 존재 합니다...");
			}
		}catch(IOException e) {
			System.out.println("파일 생성중 문제가 발생");
			e.printStackTrace();
		}
		
		

	}

}
