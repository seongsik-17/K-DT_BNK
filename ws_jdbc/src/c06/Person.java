package c06;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

//타입별로 생성자를 만들어줌 -> 기본 생성자가 안만들어짐
@AllArgsConstructor
@Getter
@ToString
public class Person implements Comparable<Person> {
	private String name;
	private int age;

	@Override
	public int compareTo(Person o) {

		return this.age - o.age;//오름차순
		//return o.age - this.age; ->내림차순
	}

}
