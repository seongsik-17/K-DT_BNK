package absttact;

public class ColorPrinter implements Printable {

	@Override
	public void print(Document doc) {
		System.out.print(doc.a);
		System.out.println("을(를) 컬러로 출력합니다.");
		
	}

}
