package net.daum;

import java.util.Scanner;

import com.naver.Command;

public class DepDeleteCom implements Command{

	@Override
	public void execute(Scanner sc) {
		System.out.println("학과 정보 삭제");
		
		System.out.println("did를 입력하세요");
		String did = sc.nextLine();
		
		DepartDAO dao = new DepartDAO();
		dao.delete(did);
		
	}

}
