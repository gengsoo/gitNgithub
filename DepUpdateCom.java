package net.daum;

import java.util.Scanner;

import com.naver.Command;

public class DepUpdateCom implements Command {

	@Override
	public void execute(Scanner sc) {
		System.out.println("�а� ���� ����");
		
		System.out.println("did�� �Է��ϼ���");
		String did = sc.nextLine();
		
		System.out.println("������ dname�� �Է��ϼ���");
		String dname = sc.nextLine();
		
		DepartDAO dao = new DepartDAO();
		DepartDTO dto = new DepartDTO(did, dname);
		dao.update(dto);
	}
	
}
