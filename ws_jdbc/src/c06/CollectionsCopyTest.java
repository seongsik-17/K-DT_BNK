package c06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsCopyTest {
	public static void main(String[] args) {
		List<String> src = Arrays.asList("전우치","홍길동","손오공","멀린");
		//수정 가능한 리스트로 생성
		List<String> dst = new ArrayList<>(src);
		System.out.println(dst);
		//정렬을 수행
		Collections.sort(dst);
		System.out.println(dst);
		
		Collections.copy(dst, src);//오른쪽에 있는 값을 왼쪽으로 넣는다.
		System.out.println(dst);
		
		//수정 가능한 상태인지 확인.Mutable(변경가능한) 객체로 재 생성
		dst.remove(0);
		System.out.println(dst);
		
		
		//수정 가능한 리스트로 생성
	}

}
