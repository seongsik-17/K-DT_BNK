package c06;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
	
	static FileReader fr;
	static BufferedReader br;
	public static void main(String[] args) throws IOException {
		
		try {
			fr =  new FileReader("C:/temp/jv_test/test1.txt");
			
			int data = 0;
			
			while((data = fr.read()) != -1) {//EOF = file의 끝은 -1
				System.out.print((char)data);
			}
			fr.close();
			fr = new FileReader("C:/temp/jv_test/test1.txt");
			br = new BufferedReader(fr);
			System.out.println();
			System.out.println("--Buffered 시작부분--");
			fr = new FileReader("C:/temp/jv_test/test1.txt");
			//Buffered를 사용하면 문자열(문장)으로 저장됨
			//버퍼는 보조 스트림이다!**
			String s = null;
			while((s = br.readLine()) != null) {
				System.out.println(s);
			}
			

		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			fr.close();
			br.close();
		}
		
	}

}
