package net.daum;

import java.util.Scanner;

import com.naver.Command;

public class DepDeleteCom implements Command{

	@Override
	public void execute(Scanner sc) {
		System.out.println("�а� ���� ����");
		
		System.out.println("did�� �Է��ϼ���");
		String did = sc.nextLine();
		
		DepartDAO dao = new DepartDAO();
		dao.delete(did);
		
	}

}
