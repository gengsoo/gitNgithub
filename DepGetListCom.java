package net.daum;

import java.util.ArrayList;
import java.util.Scanner;

import com.naver.Command;

public class DepGetListCom implements Command {

	@Override
	public void execute(Scanner sc) {

		DepartDAO dao = new DepartDAO();
		ArrayList<DepartDTO> list = dao.getList();
		
		System.out.println("DB에서 모든 학과 정보를 가져옵니다.");
		System.out.println("학과번호\t학과명");
		for(int i = 0; i < list.size(); i++) {
			DepartDTO dto = list.get(i);
			System.out.println(dto);
		}
	}

}
