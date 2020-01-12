package com.naver;

import java.util.Scanner;

public class GetMemberDTOByIdCommand implements Command {
	
	@Override
	public void execute(Scanner sc) {
		// TODO Auto-generated method stub
	
		System.out.println("---회원 조회---");
		
		boolean isTrue = true;
		int count = 0;
		
		while(isTrue) {
			
			String id;
			do {
				System.out.println("id를 입력하세요.");
				id = sc.nextLine();
			} while (id.isEmpty());
			
			MemberDAO dao = new MemberDAO();
			MemberDTO dto = dao.getMemberDTOById(id);
			
			if(dto != null) {
				System.out.println(id + "의 회원정보");
				System.out.println( "ID" + "\t" + "Name" + "\t" + "Age" + "\t" + "DID");
				System.out.println(dto);
				isTrue = false;
			}  else {
				count++;
				System.out.println("존재하지 않는 회원입니다. 다시 입력하세요.");
				System.out.println("3번 잘못 입력시 종료됩니다."+ "(" + count+"/3)");
			} 
			
			if (count > 2) {
				System.out.println("(" + count+"/3)잘못 입력 하셨습니다. 종료합니다.");
				isTrue = false;
			}
			
		}
		
	}

}
