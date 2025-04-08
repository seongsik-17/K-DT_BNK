package r14;

import java.util.ArrayList;
import java.util.Scanner;

public class Student_main { 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Student st1 = new Student("James", 93);
		Student st2 = new Student("Ann", 95);
		Student st3 = new Student("Candy", 100);
		Student st4 = new Student("Bruce", 64);
		Student st5 = new Student("Ben", 56);

		ArrayList<Student> sList = new ArrayList<>();
		sList.add(st1);
		sList.add(st2);
		sList.add(st3);
		sList.add(st4);
		sList.add(st5);
		
		for(Student s : sList) {
			System.out.println(s.toString());
		}
		while(true) {
			System.out.print("번호를 입력해주세요>> ");
			int in_num = sc.nextInt();
			sc.nextLine();
			System.out.print("이름을 입력해주세요>> ");
			String in_name = sc.nextLine();

			for (int i = 0; i < sList.size(); i++) {
				if(sList.get(i).getSno()==in_num && sList.get(i).getSname().equals(in_name)) {
					System.out.println(sList.get(i).toString());
					break;
				}
				else {
					System.out.println("번호와 이름을 확인해주세요");
					continue;
				}
			}
			break;
		}


		

	}

}
