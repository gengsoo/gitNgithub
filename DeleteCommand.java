package com.naver;

import java.util.Scanner;

public class DeleteCommand implements Command {
	
	@Override
	public void execute(Scanner sc) {
		// TODO Auto-generated method stub
	
		System.out.println("---ȸ�� ���� ����---");
		
		boolean isTrue = true;
		int count = 0;
		
		while(isTrue) {
			
			String id;
			do {
				System.out.println("id�� �Է��ϼ���.");
				id = sc.nextLine();
			} while (id.isEmpty());
			
			MemberDAO dao = new MemberDAO();
			MemberDTO so = dao.getMemberDTOById(id);
			
			if(so != null) {
			dao.delete(id);
			System.out.println(id +"ȸ�� ���� �Ϸ�");
			isTrue = false;
			} else if(count > 2) {
				System.out.println("(" + count+"/3)�߸� �Է� �ϼ̽��ϴ�. �����մϴ�.");
				isTrue = false;
			} else {
				count++;
				System.out.println("�������� �ʴ� ȸ���Դϴ�. id�� �ٽ� �Է��ϼ���.");
				System.out.println("3�� �߸� �Է½� ����˴ϴ�."+ "(" + count+"/3)");
			}
			
		}
		
	}

}