package absttact;

public class BlackPrinter implements Printable {

	@Override
	public void print(Document doc) {
		System.out.print(doc.getA().substring(0,doc.getA().length()-3));
		System.out.println("--------------------");
		System.out.println("위 내용을 흑백으로 출력합니다.");
		
	}

}
