package com.naver;

import java.util.ArrayList;
import java.util.Scanner;

public class GetListCommand implements Command {

	@Override
	public void execute(Scanner sc) {
		// TODO Auto-generated method stub
		
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberDTO> list = dao.getList();

		System.out.println("DB에서 모든 회원 정보를 가져옵니다.");
		System.out.println("ID" + "\t" + "Name" + "\t" + "Age" + "\t" + "DID");
		
		for(int i = 0; i < list.size(); i++) {
			MemberDTO dto = list.get(i);
			System.out.println(dto);
		}
		
	}
	
}
