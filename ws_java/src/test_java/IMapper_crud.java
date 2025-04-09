package test_java;

import java.util.List;

public interface IMapper_crud {

	Member read(int mno);

	List<Member> readAll();

	void create(Member member);

}
