package net.daum;

import java.util.Scanner;

import com.naver.Command;

public class DepUpdateCom implements Command {

	@Override
	public void execute(Scanner sc) {
		System.out.println("학과 정보 수정");
		
		System.out.println("did를 입력하세요");
		String did = sc.nextLine();
		
		System.out.println("수정할 dname을 입력하세요");
		String dname = sc.nextLine();
		
		DepartDAO dao = new DepartDAO();
		DepartDTO dto = new DepartDTO(did, dname);
		dao.update(dto);
	}
	
}
