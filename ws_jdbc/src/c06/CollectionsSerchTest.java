package c06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsSerchTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		
		list.add("홍길동");
		list.add("전우치");
		list.add("손오공");
		
		Collections.sort(list);
		
		
		int idx1 = Collections.binarySearch(list, "홍길동");
		if(idx1 == -1) {
			System.out.println("해당 데이터는 리스트에 없습니다...");
		}else {
			System.out.println("현재 위치>> "+idx1);
		}
		
		

	}

}
