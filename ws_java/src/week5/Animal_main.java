package week5;

public class Animal_main {

	public static void main(String[] args) {
		
		Animal[] arr_a = new Animal[3];
		Cat c = new Cat();
		Dog d = new Dog();
		Tiger t = new Tiger();
		
		
		arr_a[0] = c;
		arr_a[1] = d;
		arr_a[2] = t;
		
		for(int i = 0; i < 3; i++) {
			arr_a[i].cry();
		}
		

		
		
		
	
	}

}
