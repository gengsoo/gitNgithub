package net.daum;

import java.util.Scanner;

import com.naver.Command;

public class DepInsertCom implements Command {

	@Override
	public void execute(Scanner sc) {
		
		System.out.println("---학과 정보 등록---");
		
		String did;
		do {
			System.out.println("did를 입력하세요");
			did = sc.nextLine();
		} while (did.isEmpty());
		
		
		
		System.out.println("dname을 입력하세요");
		String dname = sc.nextLine();
		
		DepartDAO dao = new DepartDAO();
		DepartDTO dto = new DepartDTO(did, dname);
		dao.insert(dto);
		
	}

}
