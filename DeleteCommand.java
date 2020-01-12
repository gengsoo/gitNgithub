package com.naver;

import java.util.Scanner;

public class DeleteCommand implements Command {
	
	@Override
	public void execute(Scanner sc) {
		// TODO Auto-generated method stub
	
		System.out.println("---회원 정보 삭제---");
		
		boolean isTrue = true;
		int count = 0;
		
		while(isTrue) {
			
			String id;
			do {
				System.out.println("id를 입력하세요.");
				id = sc.nextLine();
			} while (id.isEmpty());
			
			MemberDAO dao = new MemberDAO();
			MemberDTO so = dao.getMemberDTOById(id);
			
			if(so != null) {
			dao.delete(id);
			System.out.println(id +"회원 삭제 완료");
			isTrue = false;
			} else if(count > 2) {
				System.out.println("(" + count+"/3)잘못 입력 하셨습니다. 종료합니다.");
				isTrue = false;
			} else {
				count++;
				System.out.println("존재하지 않는 회원입니다. id를 다시 입력하세요.");
				System.out.println("3번 잘못 입력시 종료됩니다."+ "(" + count+"/3)");
			}
			
		}
		
	}

}