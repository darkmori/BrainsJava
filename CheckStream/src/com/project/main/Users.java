/**
 * 
 * <pre>
 * 로그인한 사용자가 no가 1 -> 사용자일때 호출되는 클래스
*
*---------------------------------------------------
*             class Users
*---------------------------------------------------
*public Users()							   -> 생성자 
*public void userFirstMenu(StudentDto dto) -> 사용자일때 메인에서 호출됨 
*public void usersAttend(StudentDto stDto) -> 1번메뉴 출근
*public void usersFinish(StudentDto stDto) -> 2번메뉴 퇴근
*public void showInfo(StudentDto stDto)    -> 3번메뉴  정보보기
*public void modifyInfo(StudentDto stDto)  -> 4번메뉴 정보수정
*public boolean moveMenu()				   -> 각 메뉴끝내고 이동여부 처리
* </pre>
*/

package com.project.main;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Vector;

import com.project.dto.*;
import com.project.util.StudentMethod;

import com.project.dao.*;

//로그인후 사용자 처리
public class Users {

	public Users() {
	} // Constructor

	// StudentTestMain에서 사용자일 경우 처음 홀수할 메서드.
	public void userFirstMenu(StudentDto dto) throws SQLException {
		String str = "";

		boolean bool = false; // 잘못입력되었을때 반복하기 위한 변수
		while (bool == false) { // 메뉴 잘못 선택했을때 메뉴 반복을 위해 while로 감싸준다.
			System.out.println(); // 사용자 메뉴 출력
			System.out.println();
			System.out.println("1. 출근");
			System.out.println("2. 퇴근");
			System.out.println("3. 개인정보 보기");
			System.out.println("4. 개인정보 수정");
			System.out.println("9. 끝내기");
			System.out.print("메뉴를 선택해 주세요. => ");
			str = StudentMethod.input();

			if (str.equals("1")) { // 출근일때
				this.usersAttend(dto); // 출근 처리를 위한 메서드 호출
			} else if (str.equals("2")) { // 퇴근
				this.usersFinish(dto); // 퇴근처리를 위한 메서드 호출
			} else if (str.equals("3")) { // 개인정보 보기
				this.showInfo(dto); // 정보보기를 위한 메서드 호출
			} else if (str.equals("4")) { // 개인정보 수정
				this.modifyInfo(dto); // 정보수정을 위한 메서드 호출
			} else if (str.equals("9")) { // 뒤로가기
				bool = true; // while문 빠져 나가 끝낸다.
			} else {
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
			} // if-else
		} // while
	}

	// 1번 메뉴 - 출근체크
	/**
	 * 학생에 대한 정보를 수정한다.
	 * 
	 * @param stDto
	 *            학생정보를 담은 DTO
	 */
	public void usersAttend(StudentDto stDto) {
		Calendar cal = Calendar.getInstance();
		AttendDao atDao = new AttendDao();

		if (!atDao.isAttend(stDto, cal)) { // 오늘 출석한 내역이 있는지 확인
			boolean chk = false; // 출석처리 성공여부
			boolean late = false; // 지각인지 확인
			int amount = 0; // 벌금 금액

			PenaltyDao peDao = new PenaltyDao();

			if ((cal.get(Calendar.HOUR_OF_DAY) >= 9) && (cal.get(Calendar.MINUTE) >= 1)) {// 9시 1분이 넘었으면 지각으로 처리
				late = true; // 지각했음을 표시
				if ((cal.get(Calendar.HOUR_OF_DAY) - 9) == 1) { // 시간별로 벌금 금액정함
					amount = 2000;
				} else if ((cal.get(Calendar.HOUR_OF_DAY) - 9) == 2) {
					amount = 3000;
				} else if ((cal.get(Calendar.HOUR_OF_DAY) - 9) >= 3) {
					amount = 4000;
				} else {
					amount = 1000;
				}
			}

			try {
				chk = atDao.checkAttend(stDto.getId(), late, cal.get(Calendar.MONTH) + 1 + "/" + cal.get(Calendar.DATE)
						+ " " + cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE)); // 출석체크하기

				if ((chk == true) && (late == false)) { // 출석체크 성공하고 지각안했으면
					System.out.println("출석처리가 완료되었습니다.");
				} else if ((chk == true) && (late == true)) {
					peDao.AddPenalty(stDto.getId(), amount, "약 " + (cal.get(Calendar.HOUR_OF_DAY) - 9) + "시간 지각",
							cal.get(Calendar.MONTH) + 1 + "/" + cal.get(Calendar.DATE) + " "
									+ cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE));
					System.out.println("지각했군요. 빨리 좀 다니세요.");
				} else {
					System.out.println("출석처리를 실패하였습니다. 다시 로그인 해주세요.");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} // try-catch
		} else {
			System.out.println("오늘은 이미 출근하셨습니다.");
		} // if-else : isAttend
	} // usersAttend

	// 2번 메뉴 - 퇴근처리
	public void usersFinish(StudentDto stDto) throws SQLException {
		Calendar cal = Calendar.getInstance();
		AttendDao atDao = new AttendDao();
		if (atDao.isAttend(stDto, cal)) { // 오늘 출석했을때만 퇴근처리
			if (!atDao.isGohome(stDto, cal)) { // 오늘 퇴근처리 했으면 또 안하기
				boolean chk = false; // 퇴근처리 성공여부
				boolean early = false; // 조퇴인지 확인
				int amount = 0; // 벌금 금액

				PenaltyDao peDao = new PenaltyDao();

				if (cal.get(Calendar.HOUR_OF_DAY) < 21) {
					early = true;
					if ((21 - cal.get(Calendar.HOUR_OF_DAY)) == 1) {
						amount = 1000;
					} else if ((cal.get(Calendar.HOUR_OF_DAY) - 9) == 2) {
						amount = 2000;
					} else {
						amount = 3000;
					}
				}

				chk = atDao.checkFinish(stDto.getId(), early, cal.get(Calendar.MONTH) + 1 + "/" + cal.get(Calendar.DATE)
						+ " " + cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE)); // 퇴근처리하기
				if ((chk == true) && (early == false)) { // 퇴근처리 했고 조퇴아니면
					System.out.println("퇴근처리가 완료되었습니다.");
				} else if ((chk == true) && (early == true)) {
					peDao.AddPenalty(stDto.getId(), amount, "약 " + (21 - cal.get(Calendar.HOUR_OF_DAY)) + "시간일찍 조퇴",
							cal.get(Calendar.MONTH) + 1 + "/" + cal.get(Calendar.DATE) + " "
									+ cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE));
					System.out.println("조퇴처리 되었습니다. 벌금은 " + amount + "원 입니다.");
				} else {
					System.out.println("퇴근처리를 실패하였습니다. 다시 로그인 해주세요.");
				} // if-else
			} else {
				System.out.println("오늘은 이미 퇴근하셨는데요.");
			} // if-else : isGohome
		} else {
			System.out.println("오늘은 아직 출근도 안했습니다.");
		} // if-else : isAttend
	} // usersFinish

	// 3번메뉴 개인정보 보기
	public void showInfo(StudentDto stDto) throws SQLException {
		StudentDao stDao = new StudentDao();
		stDto = stDao.getStudent(stDto.getId());
		Vector v = new Vector(5, 5);
		AttendDao atDao = new AttendDao();
		PenaltyDao peDao = new PenaltyDao();
		GradeDao grDao = new GradeDao();
		String str = "";

		System.out.println();
		System.out.println("--------------------------------------------------");
		System.out.println("\t\t개인 신상 정보  ");
		System.out.println("--------------------------------------------------");
		StudentMethod.show(stDto);

		System.out.println();
		System.out.println();
		System.out.print("계속 보시려면 Enter를 눌러주세요. (그만 보시려면 q를 눌러주세요.)");

		str = StudentMethod.input();

		if (!str.equals("q") && !str.equals("Q")) { // 정보 별로 끊어서 보기 위해서.
			System.out.println();
			System.out.println("--------------------------------------------------");
			System.out.println("\t\t출석 정보  ");
			System.out.println("--------------------------------------------------");
			v = atDao.getIdAttend(stDto.getId());
			StudentMethod.showAttend(v);
			int att = 0, lat = 0, ear = 0;

			for (int i = 0; i < v.size(); i++) { // 벌금 총합 계산
				AttendDto atDto = (AttendDto) v.get(i);
				att += Integer.parseInt(atDto.getAttend());
				lat += Integer.parseInt(atDto.getLate());
				ear += Integer.parseInt(atDto.getEarly());
			}
			System.out.println();
			System.out.println("--------------------------------------------------");
			System.out.println("총 출석일수 : " + att + "회   지각 " + lat + "회   조퇴 " + ear + "회");
			System.out.println("--------------------------------------------------");
			System.out.println();
			System.out.println();
			System.out.print("계속 보시려면 Enter를 눌러주세요. (그만 보시려면 q를 눌러주세요.)");
			str = StudentMethod.input();
		}

		if (!str.equals("q") && !str.equals("Q")) {
			int sum = 0; // 벌금 총합을 위해
			System.out.println();
			System.out.println("--------------------------------------------------");
			System.out.println("\t\t벌금 정보  ");
			System.out.println("--------------------------------------------------");
			v = peDao.getIdPenalty(stDto.getId());
			StudentMethod.showPenalty(v);
			for (int i = 0; i < v.size(); i++) { // 벌금 총합 계산
				PenaltyDto ptDto = (PenaltyDto) v.get(i);
				sum += ptDto.getAmount();
			}
			System.out.println("현재 벌금 총액 : " + sum + "원");
			System.out.println();
			System.out.println();
			System.out.print("계속 보시려면 Enter를 눌러주세요. (그만 보시려면 q를 눌러주세요.");
			str = StudentMethod.input();
		}

		if (!str.equals("q") && !str.equals("Q")) {
			System.out.println("--------------------------------------------------");
			System.out.println("\t\t성적 정보  ");
			System.out.println("--------------------------------------------------");
			v = grDao.getIdGrade(stDto.getId());
			StudentMethod.showGrade(v);
		}
	} // showInfo

	// 4번 메뉴 - 개인 정보 수정
	public void modifyInfo(StudentDto stDto) throws SQLException {
		String str = "";
		boolean bool = false; // 잘못입력되었을때 반복하기 위한 변수
		StudentDao stDao = new StudentDao();

		while (bool == false) {
			System.out.println("--------------------------------------------------");
			System.out.println("\t\t개인정보를 수정합니다.");
			System.out.println("--------------------------------------------------");
			System.out.println("1. 비밀번호 변경");
			System.out.println("2. 주소 변경");
			System.out.println("3. 생일 변경");
			System.out.println("9. 뒤로 가기");
			System.out.println("(ID, 이름은 변경할 수 없습니다.)");
			System.out.println("--------------------------------------------------");
			System.out.print("메뉴를 선택해 주세요. => ");
			str = StudentMethod.input();

			if (str.equals("1")) { // 1번 비밀번호 변경
				boolean tmp = false;

				while (tmp == false) {
					System.out.println("새 비밀번호를 입력하세요."); // 비밀번호 입력받기
					System.out.print("password : ");
					str = StudentMethod.input();
					System.out.print("password 재입력 : ");
					String str2 = StudentMethod.input();

					if (str.equals(str2)) { // 2개 비밀번호 같은지 확인
						stDao.updateStudent(stDto.getId(), str, "", 1, "", "");// 개인정보 수정하기
						tmp = true;
						System.out.println("정보 수정이 완료되었습니다.");
						bool = this.moveMenu(); // while문을 끝내기 위해서.
					} else {
						System.out.println("비밀번호가 잘못 입력되었습니다. 다시 입력해 주세요.");
					} // if-else
				}
			} else if (str.equals("2")) { // 2번 주소 변경
				System.out.println("새 주소를 입력하세요.");
				str = StudentMethod.input();
				stDao.updateStudent(stDto.getId(), "", "", 1, str, ""); // 정보 수정
				System.out.println("정보 수정이 완료되었습니다.");
				bool = this.moveMenu(); // while문을 끝내기 위해서.
			} else if (str.equals("3")) { // 3번 생일 변경
				System.out.println("새 생일을 입력하세요.");
				str = StudentMethod.input();
				stDao.updateStudent(stDto.getId(), "", "", 1, "", str); // 정보 수정
				System.out.println("정보 수정이 완료되었습니다.");
				bool = this.moveMenu(); // while문을 끝내기 위해서.
			} else if (str.equals("9")) { // 9번 뒤로가기
				bool = true; // while문 끝내고 돌아간다.
				// this.userFirstMenu(stDto);
			} else {
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
				System.out.println();
			} // if-else
		} // while
	} // modifyInfo

	// 메뉴 수행뒤 어디로 갈건지를 선택하기 위한 메서드
	public boolean moveMenu() {
		String str = "";
		boolean bool = false;
		System.out.println();
		System.out.println();
		System.out.println("다른 메뉴를 계속 이용하시려면 아무키나 누르세요.");
		System.out.println("(N을 누르면 프로그램을 종료합니다.)");
		str = StudentMethod.input();
		if (str.equals("n") || str.equals("N")) {
			bool = true;
		}
		return bool;
	}
}
