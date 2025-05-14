package c06;
enum Scale2{
	//public, static, final 모두 생략됐지만 붙어있음
	DO, RE, MI, PA, SO, RA, TI;

	
}
public class InterfaceBaseConstTest {

	public static void main(String[] args) {
		
		Scale2 sc =  Scale2.DO;
		switch(sc) {
		case DO://상수를 선언할 경우에는 전부다 대문자로 변수명을 작성함
			System.out.println("도");
			break;
		case RE:
			System.out.println("레");
			break;
		case MI:
			System.out.println("미");
			break;
		case PA:
			System.out.println("파");
			break;
		case SO:
			System.out.println("솔");
			break;
		case RA:
			System.out.println("라");
			break;
		case TI:
			System.out.println("시");
			break;
		default :
			System.out.println("잘못된 입력");
		}

	}

}
