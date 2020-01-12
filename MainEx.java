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
			System.out.println("***회원 관리 메뉴***");
			System.out.println("메뉴를 선택하세요.");
			System.out.println("1: 회원 등록 / 2: 전체 회원 조회 / 3: 회원 조회 / 4: 회원 수정 / 5: 회원 삭제 / 6: *학과 정보 관리* / 7: 종료 ");

			try {
				menu = sc.nextInt();
			} catch (Exception e) {
				count++;
				if (count > 2) {
					System.out.println("(" + count + "/3)잘못 입력 하셨습니다.종료합니다.");
					break;
				}

				System.out.println("잘못 입력하셨습니다.");
				System.out.println("3번 잘못 입력시 종료됩니다." + "(" + count + "/3)");
				continue;
			} finally {
				sc.nextLine();
			}

			if (menu < com.length + 1) {
				com[menu - 1].execute(sc);
			} else if (menu == com.length + 1) {
				while (true) {
					System.out.println("***학과 정보 관리 메뉴***");
					System.out.println("메뉴를 선택하세요.");
					System.out.println(
							"1: 학과 정보 등록 / 2: 전체 학과 정보 조회 / 3: 학과 정보 수정 / 4: 학과 정보 삭제 / 5: *회원 정보 관리* / 6:종료 ");
					try {
						menu = sc.nextInt();
					} catch (Exception e) {
						dcount++;
						if (dcount > 2) {
							System.out.println("(" + dcount + "/3)잘못 입력 하셨습니다.종료합니다.");
							break;
						}

						System.out.println("잘못 입력하셨습니다.");
						System.out.println("3번 잘못 입력시 종료됩니다." + "(" + dcount + "/3)");
						continue;
					} finally {
						sc.nextLine();
					}

					if (menu < dcom.length + 1) {
						dcom[menu - 1].execute(sc);
					} else if (menu == dcom.length + 1) {
						break;
					} else if (menu == dcom.length +2) {
						System.out.println("종료합니다.");
						System.exit(0);
					} else {
						dcount++;
						if (dcount > 2) {
							System.out.println("(" + dcount + "/3)잘못 입력 하셨습니다.종료합니다.");
							break;
						}

						System.out.println("잘못 입력하셨습니다.");
						System.out.println("3번 잘못 입력시 종료됩니다." + "(" + dcount + "/3)");
					}

				}
			} else if (menu == com.length + 2) {
				System.out.println("종료합니다");
				break;
			} else {
				count++;
				if (count > 2) {
					System.out.println("(" + count + "/3)잘못 입력 하셨습니다.종료합니다.");
					break;
				}

				System.out.println("잘못 입력하셨습니다.");
				System.out.println("3번 잘못 입력시 종료됩니다." + "(" + count + "/3)");
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
