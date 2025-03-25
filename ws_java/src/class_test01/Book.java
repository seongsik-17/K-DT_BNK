package class_test01;

public class Book {
	String title;
	String genre;
	String publisher;
	String writer;
	int price;
	
	
	//자동으로 생성된 
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	
	
	Book(){}
	Book(String title, String publisher, String writer){
		this.title = title;
		this.publisher = publisher;
		this.writer = writer;
	}
	void setTitle(String title) {
		this.title = title;
		System.out.println(title+"로 변경됨");
	}
	
	
	String bookinfo() {
		return "Book [title=" + title + ", publisher=" + publisher + ", writer=" + writer + "]";
	}
	@Override
	public String toString() {
		return "Book [title=" + title + ", publisher=" + publisher + ", writer=" + writer + "]";
	}
	
	


}
