package service;

import VO.Member;

public class MemberService {
	public int logcheck(String id, String pw) {
		MemberDao md = new MemberDao();
		Member m = md.select(id);
		
		if(m.getId().equals(id)&&m.getPw().equals(pw)) {
			return 1;
		}else {
			return 0;
		}
		
	}

}
