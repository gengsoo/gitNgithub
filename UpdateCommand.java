package com.naver;


import java.util.Scanner;

import kr.co.ca.MainEx;
import net.daum.DepGetListCom;
import net.daum.DepartDAO;
import net.daum.DepartDTO;

public class UpdateCommand implements Command {

	@Override
	public void execute(Scanner sc) {
		// TODO Auto-generated method stub

		System.out.println("---회원 정보 수정---");

		boolean isTrue = true;
		String id = null;
		MemberDTO so = null;
		MemberDAO dao = new MemberDAO();
		int count = 0;

		while (isTrue) {

			do {
				System.out.println("id를 입력하세요.");
				id = sc.nextLine();
			} while (id.isEmpty());

			dao = new MemberDAO();
			so = dao.getMemberDTOById(id);

			if (so != null) {
				isTrue = false;
			} else {
				count++;
				System.out.println("존재하지 않는 회원입니다. id를 다시 입력하세요.");
				System.out.println("3번 잘못 입력시 종료됩니다." + "(" + count + "/3)");
			}
			if (count > 2) {
				System.out.println("(" + count + "/3)잘못 입력 하셨습니다. 종료합니다.");
				isTrue = false;
				MainEx.main(null);
			}

		}

		
		System.out.println("수정할 name을 입력하세요.");
		String name = sc.nextLine();

		int age = 0;
		
		while (true) {
			try {
				System.out.println("수정할 age를 입력하세요.");
				age = sc.nextInt();

				if (age > 0 && age < 200) {
					break;
				} else {
					System.out.println("0 ~ 200 사이의 age값을 다시 입력하세요.");
				}
			} catch (Exception e) {
				System.out.println("숫자를 입력 가능합니다. 다시 입력하세요.");
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

		MemberDTO dto = new MemberDTO(id, name, age, did);

		dao.update(dto);
		System.out.println(id + "의 회원 정보 수정 완료");

	}

}
