package com.naver;

import java.util.Scanner;

import net.daum.DepGetListCom;
import net.daum.DepartDAO;
import net.daum.DepartDTO;

public class InsertCommand implements Command {

	@Override
	public void execute(Scanner sc) {
		// TODO Auto-generated method stub

		System.out.println("---ȸ�� ���---");

		String id = null;
		MemberDTO so = null;
		MemberDAO dao = new MemberDAO();

		while (true) {
			do {
				System.out.println("id�� �Է��ϼ���.");
				id = sc.nextLine();
			} while (id.isEmpty());

			dao = new MemberDAO();
			so = dao.getMemberDTOById(id);

			if (so != null) {
				System.out.println("�ߺ��� id�Դϴ�. id�� �ٽ� �Է��ϼ���.");
			} else {
				break;
			}
		}

		String name;
		do {
			System.out.println("name�� �Է��ϼ���.");
			name = sc.nextLine();
		} while (name.isEmpty());

		int age = 0;
		while (true) {
			try {
				System.out.println("age�� �Է��ϼ���.");
				age = sc.nextInt();

				if (age > 0 && age < 200) {
					break;
				} else {
					System.out.println("0 ~ 200 ������ age���� �ٽ� �Է��ϼ���.");
				}
			} catch (Exception e) {
				System.out.println("���ڸ� �Է� �����մϴ�. �ٽ� �Է��ϼ���.");
			} finally {
				sc.nextLine();
			}

		}

		
		String did = null;
		while(true) {

			do {
				System.out.println("�а� ��ȣ�� �Է��ϼ���.");
				DepGetListCom dglc = new DepGetListCom();
				dglc.execute(sc);
				did = sc.nextLine();
			} while (did.isEmpty());
			
			DepartDAO ddao = new DepartDAO();
			DepartDTO ddto = ddao.getDepartDTOByDid(did);
			
			if(ddto != null) {
				break;
			} else {
				System.out.println("�߸��� �а� ��ȣ �Դϴ�. �ٽ� �Է��ϼ���.");
				continue;
			}
			
		}
			
		dao = new MemberDAO();
		MemberDTO dto = new MemberDTO(id, name, age, did);

		so = dao.getMemberDTOById(id);

		dao.insert(dto);
		System.out.println("ȸ�� ��� �Ϸ�");

	}

}
