package ex05.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class MemberDTO {//계층간 데이터 전송(서블릿에서 서비스 서비스에서 DAO
	private final String id;
	private final String pw;
	private final String name;
	private final String phone;
	private  String grade;

}
