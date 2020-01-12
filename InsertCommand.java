package com.naver;

import java.util.Scanner;

import net.daum.DepGetListCom;
import net.daum.DepartDAO;
import net.daum.DepartDTO;

public class InsertCommand implements Command {

	@Override
	public void execute(Scanner sc) {
		// TODO Auto-generated method stub

		System.out.println("---회원 등록---");

		String id = null;
		MemberDTO so = null;
		MemberDAO dao = new MemberDAO();

		while (true) {
			do {
				System.out.println("id를 입력하세요.");
				id = sc.nextLine();
			} while (id.isEmpty());

			dao = new MemberDAO();
			so = dao.getMemberDTOById(id);

			if (so != null) {
				System.out.println("중복된 id입니다. id를 다시 입력하세요.");
			} else {
				break;
			}
		}

		String name;
		do {
			System.out.println("name를 입력하세요.");
			name = sc.nextLine();
		} while (name.isEmpty());

		int age = 0;
		while (true) {
			try {
				System.out.println("age를 입력하세요.");
				age = sc.nextInt();

				if (age > 0 && age < 200) {
					break;
				} else {
					System.out.println("0 ~ 200 사이의 age값을 다시 입력하세요.");
				}
			} catch (Exception e) {
				System.out.println("숫자만 입력 가능합니다. 다시 입력하세요.");
			} finally {
				sc.nextLine();
			}

		}

		
		String did = null;
		while(true) {

			do {
				System.out.println("학과 번호를 입력하세요.");
				DepGetListCom dglc = new DepGetListCom();
				dglc.execute(sc);
				did = sc.nextLine();
			} while (did.isEmpty());
			
			DepartDAO ddao = new DepartDAO();
			DepartDTO ddto = ddao.getDepartDTOByDid(did);
			
			if(ddto != null) {
				break;
			} else {
				System.out.println("잘못된 학과 번호 입니다. 다시 입력하세요.");
				continue;
			}
			
		}
			
		dao = new MemberDAO();
		MemberDTO dto = new MemberDTO(id, name, age, did);

		so = dao.getMemberDTOById(id);

		dao.insert(dto);
		System.out.println("회원 등록 완료");

	}

}
