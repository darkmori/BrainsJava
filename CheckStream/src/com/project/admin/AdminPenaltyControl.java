package com.project.admin;

import java.sql.SQLException;

import com.project.admin.AdminControlMenu;
import com.project.util.StudentMethod;
import com.project.dao.*;
import com.project.dto.PenaltyDto;

public class AdminPenaltyControl {

	public void penaltyControl() {

		System.out.println("--------------------------------------------------");
		System.out.println("\t\t벌금 정보 관리 ");
		System.out.println("--------------------------------------------------");
		System.out.println(" 1. 추가");
		System.out.println(" 2. 수정");
		System.out.println(" 3. 삭제");
		System.out.println(" 9. 뒤로 가기");
		System.out.println("--------------------------------------------------");

		String code = "";
		code = StudentMethod.input();

		if (code.equals("1")) { // 벌금 입력
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
			System.out.println("벌금 금액을 입력하세요");
			int amount = Integer.parseInt(StudentMethod.input());
			System.out.println("사유를 입력하세요");
			String why = StudentMethod.input();
			System.out.println("날짜 및 시간울 입력하세요.(월/일 시각:분)");
			String pDate = StudentMethod.input();

			PenaltyDao pd = new PenaltyDao();
			boolean result = false;
			try {
				result = pd.AddPenalty(id, amount, why, pDate);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (result) {
				PenaltyDto pDto = new PenaltyDto();
				try {
					pDto = pd.getPenalty(id, why, pDate);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				System.out.println();
				System.out.println();
				StudentMethod.show(pDto);
				System.out.println("벌금정보 추가를 성공했습니다.");
			} else {
				System.out.println();
				System.out.println();
				System.out.println("벌금정보 추가를 실패했습니다.");
			}
			penaltyControl();
			// StudentMethod.close();

		} else if (code.equals("2")) { // 벌금 수정
			System.out.println("수정할 데이터의 ID와 날짜와 사유를 적으세요.");
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

			System.out.println("날짜를 입력하세요.(월/일 시각:분)");
			String pdate = StudentMethod.input();
			System.out.println("사유를 입력하세요");
			String why = StudentMethod.input();
			System.out.println();
			System.out.println();
			System.out.println("수정할 내용을 입력하세요.");
			System.out.println("벌금 금액을 입력하세요");
			int amount = Integer.parseInt(StudentMethod.input());
			System.out.println("사유를 입력하세요");
			String why2 = StudentMethod.input();

			PenaltyDao pd = new PenaltyDao();
			boolean result = false;
			try {
				result = pd.updatePenalty(id, why, pdate, amount, why2);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (result) {
				PenaltyDto pDto = new PenaltyDto();
				try {
					pDto = pd.getPenalty(id, why, pdate);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				System.out.println();
				System.out.println();
				StudentMethod.show(pDto);
				System.out.println("벌금정보 수정을 성공했습니다.");
			} else {
				System.out.println();
				System.out.println();
				System.out.println("벌금정보 수정을 실패했습니다.");
			}
			penaltyControl();
			// StudentMethod.close();

		} else if (code.equals("3")) { // 벌금 삭제
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
			System.out.println("사유를 입력하세요");
			String why = StudentMethod.input();
			System.out.println("날짜를 입력하세요.(월/일 시각:분)");
			String pdate = StudentMethod.input();

			PenaltyDao pd = new PenaltyDao();
			boolean result = false;
			try {
				result = pd.deletePenalty(id, why, pdate);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (result) {
				System.out.println();
				System.out.println();
				System.out.println("벌금정보 삭제를 성공했습니다.");
			} else {
				System.out.println();
				System.out.println();
				System.out.println("벌금정보 삭제를 실패했습니다.");
			}
			penaltyControl();
			// StudentMethod.close();

		} else if (code.equals("9")) {
			AdminControlMenu acm = new AdminControlMenu();
			acm.controlMenu();
		} else {
			System.out.println("다시 입력하세요");
			penaltyControl();
		}
	}

}
