package net.daum;

import java.util.Scanner;

import com.naver.Command;

public class DepInsertCom implements Command {

	@Override
	public void execute(Scanner sc) {
		
		System.out.println("---�а� ���� ���---");
		
		String did;
		do {
			System.out.println("did�� �Է��ϼ���");
			did = sc.nextLine();
		} while (did.isEmpty());
		
		
		
		System.out.println("dname�� �Է��ϼ���");
		String dname = sc.nextLine();
		
		DepartDAO dao = new DepartDAO();
		DepartDTO dto = new DepartDTO(did, dname);
		dao.insert(dto);
		
	}

}
