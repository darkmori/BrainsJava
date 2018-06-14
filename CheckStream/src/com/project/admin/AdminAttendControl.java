package com.project.admin;

import java.sql.SQLException;

import com.project.dao.*;
import com.project.admin.AdminControlMenu;
import com.project.util.StudentMethod;
import com.project.dto.AttendDto;

public class AdminAttendControl {

	public void attendControl() {

		System.out.println("--------------------------------------------------");
		System.out.println("\t\t출석 정보 관리 ");
		System.out.println("--------------------------------------------------");
		System.out.println(" 1. 추가");
		System.out.println(" 2. 수정");
		System.out.println(" 9. 뒤로 가기");
		System.out.println("--------------------------------------------------");

		String code = "";
		code = StudentMethod.input();

		if (code.equals("1")) {
			int rp = 1;
			String id = "";
			while (rp == 1) {
				System.out.println("ID를 입력하세요");
				id = StudentMethod.input();
				StudentDao sd = new StudentDao();
				if (!sd.hasId(id)) {
					System.out.println("없는 ID입니다.");
				} else {
					rp = 0;
				}
			}
			System.out.println("출석여부를 입력하세요");
			String attend = StudentMethod.input();
			System.out.println("지각여부를 입력하세요");
			String late = StudentMethod.input();
			System.out.println("조퇴여부을 입력하세요");
			String early = StudentMethod.input();
			System.out.println("퇴근여부을 입력하세요");
			String finish = StudentMethod.input();
			System.out.println("날짜와 시간을 입력하세요.(월/일 시각:분)");
			String aDate = StudentMethod.input();

			AttendDao ad = new AttendDao();
			boolean result = false;
			try {
				result = ad.addAttend(id, attend, late, early, finish, aDate);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (result) {
				AttendDto aDto = new AttendDto();
				try {
					aDto = ad.getAttend(id, aDate);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				System.out.println();
				System.out.println();
				StudentMethod.show(aDto);
				System.out.println("출석정보 추가를 성공했습니다.");
			} else {
				System.out.println();
				System.out.println();
				System.out.println("출석정보 추가를 실패했습니다.");
			}
			attendControl();
			// StudentMethod.close();

		} else if (code.equals("2")) {
			int rp = 1;
			String id = "";
			while (rp == 1) {
				StudentDao sd = new StudentDao();
				System.out.println("수정할 데이터의 ID와 시각을 입력하세요.");
				System.out.println("ID를 입력하세요");
				id = StudentMethod.input();
				if (!sd.hasId(id)) {
					System.out.println("없는 ID입니다.");
				} else {
					rp = 0;
				}
			}

			System.out.println("adate을 입력하세요.(월/일)");
			String adate = StudentMethod.input();
			System.out.println("--------------------------------------------------");
			System.out.println("수정할 데이터를 입력하세요");
			System.out.println("--------------------------------------------------");

			String attend = "";
			String late = "";
			String early = "";
			String finish = "";
			String bdate = "";
			while (rp == 0) {
				System.out.println("수정할 출석을 입력하세요(1: 출석 0: 결석)");
				attend = StudentMethod.input();
				if (attend.equals("0") || attend.equals("1")) {
					rp = 1;
				} else {
					System.out.println("0 또는 1 만 입력해 주세요.");
				}
			}

			while (rp == 1) {
				System.out.println("지각여부를 입력하세요(1: 지각)");
				late = StudentMethod.input();
				if (late.equals("0") || late.equals("1")) {
					rp = 0;
				} else {
					System.out.println("0 또는 1 만 입력해 주세요.");
				}
			}

			while (rp == 0) {
				System.out.println("조퇴을 입력하세요(1: 조퇴)");
				early = StudentMethod.input();
				if (early.equals("0") || early.equals("1")) {
					rp = 1;
				} else {
					System.out.println("0 또는 1 만 입력해 주세요.");
				}
			}

			while (rp == 1) {
				System.out.println("퇴근을 입력하세요(1: 퇴근)");
				finish = StudentMethod.input();
				if (early.equals("0") || early.equals("1")) {
					rp = 0;
				} else {
					System.out.println("0 또는 1 만 입력해 주세요.");
				}
			}
			System.out.println("시간을 입력하세요.(월/일 시각:분)");
			bdate = StudentMethod.input();

			AttendDao ad = new AttendDao();
			boolean result = false;
			try {
				result = ad.updateAttend(id, attend, late, early, finish, adate, bdate);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (result) {
				AttendDto aDto = new AttendDto();
				try {
					aDto = ad.getAttend(id, adate);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				System.out.println();
				System.out.println();
				StudentMethod.show(aDto);
				System.out.println("출석정보 수정을 성공했습니다.");
			} else {
				System.out.println();
				System.out.println();
				System.out.println("출석정보 수정을 실패했습니다.");
			}
			attendControl();
			// StudentMethod.close();

		} else if (code.equals("9")) {
			AdminControlMenu acm = new AdminControlMenu();
			acm.controlMenu();
		} else {
			System.out.println("다시 입력하세요");
			attendControl();
		}
	}

}
