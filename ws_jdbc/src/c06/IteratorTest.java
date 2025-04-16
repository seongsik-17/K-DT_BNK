package c06;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorTest {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("aaa","bbb","ccc");
		
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i)+ "\t");
		}
		System.out.println();
		for(String s:list) {//순서대로 처리됨 제어 불가
			System.out.print(s+"\t");
		}
		System.out.println();
		Iterator<String> itr = list.iterator();
		while(itr.hasNext()) {//향상된 for문과 동일하며 같은 단점을 가지고있음(시작과 끝을 제어할 수 없다)
			System.out.print(itr.next()+"\t");
		}

	}

}
