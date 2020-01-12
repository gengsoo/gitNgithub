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

		System.out.println("---ȸ�� ���� ����---");

		boolean isTrue = true;
		String id = null;
		MemberDTO so = null;
		MemberDAO dao = new MemberDAO();
		int count = 0;

		while (isTrue) {

			do {
				System.out.println("id�� �Է��ϼ���.");
				id = sc.nextLine();
			} while (id.isEmpty());

			dao = new MemberDAO();
			so = dao.getMemberDTOById(id);

			if (so != null) {
				isTrue = false;
			} else {
				count++;
				System.out.println("�������� �ʴ� ȸ���Դϴ�. id�� �ٽ� �Է��ϼ���.");
				System.out.println("3�� �߸� �Է½� ����˴ϴ�." + "(" + count + "/3)");
			}
			if (count > 2) {
				System.out.println("(" + count + "/3)�߸� �Է� �ϼ̽��ϴ�. �����մϴ�.");
				isTrue = false;
				MainEx.main(null);
			}

		}

		
		System.out.println("������ name�� �Է��ϼ���.");
		String name = sc.nextLine();

		int age = 0;
		
		while (true) {
			try {
				System.out.println("������ age�� �Է��ϼ���.");
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

		MemberDTO dto = new MemberDTO(id, name, age, did);

		dao.update(dto);
		System.out.println(id + "�� ȸ�� ���� ���� �Ϸ�");

	}

}
