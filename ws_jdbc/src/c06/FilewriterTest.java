package c06;

import java.io.FileWriter;
import java.io.IOException;

public class FilewriterTest {

	public static void main(String[] args) throws IOException {
		try {
			FileWriter fw = new FileWriter("C:/temp/jv_test/test1.txt");
			
			fw.write("Hello, java File IO 연습");
			fw.close();//->DB의 COMMIT과 같음, 없으면 위에 구문을 적용안시킴
			
			System.out.println("파일에 문자열을 성공적으로 썼음");
			
			fw = new FileWriter("C:/temp/jv_test/test1.txt");
			fw.write("\n이어서 씁니다 Java I/O 연습중 ");
			fw.close();

		}catch(IOException e) {
			e.printStackTrace();
			
		}
		
	}

}
