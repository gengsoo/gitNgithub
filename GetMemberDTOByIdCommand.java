package com.naver;

import java.util.Scanner;

public class GetMemberDTOByIdCommand implements Command {
	
	@Override
	public void execute(Scanner sc) {
		// TODO Auto-generated method stub
	
		System.out.println("---ȸ�� ��ȸ---");
		
		boolean isTrue = true;
		int count = 0;
		
		while(isTrue) {
			
			String id;
			do {
				System.out.println("id�� �Է��ϼ���.");
				id = sc.nextLine();
			} while (id.isEmpty());
			
			MemberDAO dao = new MemberDAO();
			MemberDTO dto = dao.getMemberDTOById(id);
			
			if(dto != null) {
				System.out.println(id + "�� ȸ������");
				System.out.println( "ID" + "\t" + "Name" + "\t" + "Age" + "\t" + "DID");
				System.out.println(dto);
				isTrue = false;
			}  else {
				count++;
				System.out.println("�������� �ʴ� ȸ���Դϴ�. �ٽ� �Է��ϼ���.");
				System.out.println("3�� �߸� �Է½� ����˴ϴ�."+ "(" + count+"/3)");
			} 
			
			if (count > 2) {
				System.out.println("(" + count+"/3)�߸� �Է� �ϼ̽��ϴ�. �����մϴ�.");
				isTrue = false;
			}
			
		}
		
	}

}
