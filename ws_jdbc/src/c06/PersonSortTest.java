package c06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PersonSortTest {

	public static void main(String[] args) {
		Person p1 = new Person("aaa",16);
		Person p2 = new Person("ccc",29);
		Person p3 = new Person("ddd",30);
		Person p4 = new Person("bbb",24);
		Person p5 = new Person("eee",35);
		
		
		List<Person>list_p = new ArrayList<>();
		list_p.add(p1);
		list_p.add(p2);
		list_p.add(p3);
		list_p.add(p4);
		list_p.add(p5);
		System.out.println(list_p);
		Collections.sort(list_p);
		System.out.println(list_p);
		
		
		
//		System.out.println(p1.getAge());
//		System.out.println(p1.getName());

	}

}
