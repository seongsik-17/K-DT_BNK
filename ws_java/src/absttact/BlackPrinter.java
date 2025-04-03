package absttact;

public class BlackPrinter implements Printable {

	@Override
	public void print(Document doc) {
		System.out.print(doc.a);
		System.out.println("을(를) 흑백으로 출력합니다.");
		
	}

}
