package net.daum;

import java.util.ArrayList;
import java.util.Scanner;

import com.naver.Command;

public class DepGetListCom implements Command {

	@Override
	public void execute(Scanner sc) {

		DepartDAO dao = new DepartDAO();
		ArrayList<DepartDTO> list = dao.getList();
		
		System.out.println("DB���� ��� �а� ������ �����ɴϴ�.");
		System.out.println("�а���ȣ\t�а���");
		for(int i = 0; i < list.size(); i++) {
			DepartDTO dto = list.get(i);
			System.out.println(dto);
		}
	}

}
