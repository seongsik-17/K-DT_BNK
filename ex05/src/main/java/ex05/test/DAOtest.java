package ex05.test;

import ex05.dao.MemberDAO;

public class DAOtest {

	public static void main(String[] args) {
		MemberDAO m1 = 	MemberDAO.getMemberDao();
		MemberDAO m2 = 	MemberDAO.getMemberDao();
		
		System.out.println(m1 == m2);
		

	}

}
