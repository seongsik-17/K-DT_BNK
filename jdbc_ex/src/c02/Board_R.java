package c02;

import java.util.Scanner;

public class Board_R {
	private int bon;
	private String title;
	private String content;
	private String writer;
	private String regdate;
	Scanner sc = new Scanner(System.in);
	public Board_R(){
		System.out.println("제목을 입력해주세요>> ");
		title = sc.nextLine();
		System.out.println("내용을 입력해주세요>> ");
		content = sc.nextLine();
		
	}
	
	public int getBon() {
		return bon;
	}
	public void setBon(int bon) {
		this.bon = bon;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public void setDate(String regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "Board_R\n"+"게시번호"+ bon +"\n"+ "제목>>" + title+"\n" + "내용>>" + content+"\n" + "작성자>>" + writer+"\n" + "작성일자>>"
				+ regdate;
	}
	
	

}
