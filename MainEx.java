package kr.co.ca;

import java.util.Scanner;

import com.naver.Command;
import com.naver.DeleteCommand;
import com.naver.GetListCommand;
import com.naver.GetMemberDTOByIdCommand;
import com.naver.InsertCommand;
import com.naver.UpdateCommand;

import net.daum.DepDeleteCom;
import net.daum.DepGetListCom;
import net.daum.DepInsertCom;
import net.daum.DepUpdateCom;

public class MainEx {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Command[] com = { new InsertCommand(), new GetListCommand(), new GetMemberDTOByIdCommand(), new UpdateCommand(),
				new DeleteCommand() };

		Command[] dcom = { new DepInsertCom(), new DepGetListCom(), new DepUpdateCom(), new DepDeleteCom() };

		int count = 0;
		int menu = 0;
		int dcount = 0;
		while (true) {
			System.out.println("***ȸ�� ���� �޴�***");
			System.out.println("�޴��� �����ϼ���.");
			System.out.println("1: ȸ�� ��� / 2: ��ü ȸ�� ��ȸ / 3: ȸ�� ��ȸ / 4: ȸ�� ���� / 5: ȸ�� ���� / 6: *�а� ���� ����* / 7: ���� ");

			try {
				menu = sc.nextInt();
			} catch (Exception e) {
				count++;
				if (count > 2) {
					System.out.println("(" + count + "/3)�߸� �Է� �ϼ̽��ϴ�.�����մϴ�.");
					break;
				}

				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				System.out.println("3�� �߸� �Է½� ����˴ϴ�." + "(" + count + "/3)");
				continue;
			} finally {
				sc.nextLine();
			}

			if (menu < com.length + 1) {
				com[menu - 1].execute(sc);
			} else if (menu == com.length + 1) {
				while (true) {
					System.out.println("***�а� ���� ���� �޴�***");
					System.out.println("�޴��� �����ϼ���.");
					System.out.println(
							"1: �а� ���� ��� / 2: ��ü �а� ���� ��ȸ / 3: �а� ���� ���� / 4: �а� ���� ���� / 5: *ȸ�� ���� ����* / 6:���� ");
					try {
						menu = sc.nextInt();
					} catch (Exception e) {
						dcount++;
						if (dcount > 2) {
							System.out.println("(" + dcount + "/3)�߸� �Է� �ϼ̽��ϴ�.�����մϴ�.");
							break;
						}

						System.out.println("�߸� �Է��ϼ̽��ϴ�.");
						System.out.println("3�� �߸� �Է½� ����˴ϴ�." + "(" + dcount + "/3)");
						continue;
					} finally {
						sc.nextLine();
					}

					if (menu < dcom.length + 1) {
						dcom[menu - 1].execute(sc);
					} else if (menu == dcom.length + 1) {
						break;
					} else if (menu == dcom.length +2) {
						System.out.println("�����մϴ�.");
						System.exit(0);
					} else {
						dcount++;
						if (dcount > 2) {
							System.out.println("(" + dcount + "/3)�߸� �Է� �ϼ̽��ϴ�.�����մϴ�.");
							break;
						}

						System.out.println("�߸� �Է��ϼ̽��ϴ�.");
						System.out.println("3�� �߸� �Է½� ����˴ϴ�." + "(" + dcount + "/3)");
					}

				}
			} else if (menu == com.length + 2) {
				System.out.println("�����մϴ�");
				break;
			} else {
				count++;
				if (count > 2) {
					System.out.println("(" + count + "/3)�߸� �Է� �ϼ̽��ϴ�.�����մϴ�.");
					break;
				}

				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				System.out.println("3�� �߸� �Է½� ����˴ϴ�." + "(" + count + "/3)");
			}

		}

		sc.close();

	}

}
/*
 * MemberDAO dao = new MemberDAO();
 * 
 * 
 * MemberDTO dto = new MemberDTO("t001", "kim", 33); dto = new MemberDTO("z001",
 * "kim", 33); dao.insert(dto);
 * 
 * 
 * 
 * ArrayList<MemberDTO> list = dao.getList();
 * 
 * for(int i = 0; i < list.size(); i++) { System.out.println(list.get(i)); }
 * 
 * 
 * 
 * dto = dao.getMemberDTOById("p009"); System.out.println(dto);
 * 
 * 
 * dto = new MemberDTO("z001", "lee", 55); dao.update(dto);
 * 
 * dao.delete("t001");
 * 
 * }
 * 
 * }
 */
