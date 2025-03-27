package class_test4;

public class Human_main {
	static int maleCnt = 0;
	static int femaleCnt = 0;
	
	
	
	

	public  void find(Human[]Humans) {
		for (int i = 0; i < 10; i++) {
			if (Humans[i].getGender() == 'M') {
				maleCnt++;
			} else {
				femaleCnt++;
			}
			
		}
		System.out.println(maleCnt);
		System.out.println(femaleCnt);
	}

	public static void main(String[] args) {
		Human h1 = new Human('M');
		Human h2 = new Human('M');
		Human h3 = new Human('M');
		Human h4 = new Human('M');
		Human h5 = new Human('F');
		Human h6 = new Human('F');
		Human h7 = new Human('F');
		Human h8 = new Human('F');
		Human h9 = new Human('F');
		Human h10 = new Human('F');

		 Human[] Human = new Human[10];
		Human[0] = h1;
		Human[1] = h2;
		Human[2] = h3;
		Human[3] = h4;
		Human[4] = h5;
		Human[5] = h6;
		Human[6] = h7;
		Human[7] = h8;
		Human[8] = h9;
		Human[9] = h10;

		for (int j = 0; j < 10; j++) {
			if (Human[j].gethumanNum() == 4) {
				System.out.println(Human[j].getGender());
			}

		}
		Human_main at = new Human_main();
		at.find(Human);
		
		

		// System.out.println("남자: "+maleCnt+"명");
		// System.out.println("여자: "+femaleCnt+"명");

	}

}
