package com.project.admin;

import java.sql.SQLException;

import com.project.util.StudentMethod;
import com.project.dao.*;
import com.project.dto.StudentDto;

public class AdminStudentControl {

	public void studentControl() {

		System.out.println("--------------------------------------------------");
		System.out.println("\t\t신상 정보 관리 ");
		System.out.println("--------------------------------------------------");
		System.out.println(" 1. 추가");
		System.out.println(" 2. 수정");
		System.out.println(" 3. 삭제");
		System.out.println(" 9. 뒤로 가기");
		System.out.println("--------------------------------------------------");

		String code = "";
		code = StudentMethod.input();

		if (code.equals("1")) { // 회원 추가
			System.out.println("ID를 입력하세요");
			String id = StudentMethod.input();
			System.out.println("비밀번호를 입력하세요");
			String pass = StudentMethod.input();
			System.out.println("이름을 입력하세요");
			String name = StudentMethod.input();
			System.out.println("숫자 입력을 입력하세요");
			int no = Integer.parseInt(StudentMethod.input());
			System.out.println("주소를 입력하세요");
			String addr = StudentMethod.input();
			System.out.println("생일을 입력하세요");
			String birth = StudentMethod.input();

			StudentDao sd = new StudentDao();
			boolean result = false;
			try {
				result = sd.joinStudent(id, pass, name, no, addr, birth);
				System.out.println("추가되었습니다.");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (result) {
				StudentDto sDto = new StudentDto();
				try {
					sDto = sd.getStudent(id);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				System.out.println();
				System.out.println();
				StudentMethod.show(sDto);
				System.out.println("회원 추가를 성공했습니다.");
			} else {
				System.out.println();
				System.out.println();
				System.out.println("회원 추가를 실패했습니다.");
			}
			studentControl();
			// StudentMethod.close();

		} else if (code.equals("2")) { // 회원 정보 수정
			int rp = 0;
			String id = "";
			StudentDao sd = new StudentDao();
			while (rp == 0) {
				System.out.println("수정할 회원의 ID를 입력하세요");
				id = StudentMethod.input();
				if (!sd.hasId(id)) {
					System.out.println("없는 ID입니다.");
				} else {
					rp = 1;
				}
			}
			System.out.println();
			System.out.println("수정할 데이터를 입력하세요.");
			System.out.println("비밀번호를 입력하세요");
			String pass = StudentMethod.input();
			System.out.println("이름을 입력하세요");
			String name = StudentMethod.input();
			rp = 0;
			String no = "";
			while (rp == 0) {
				System.out.println("사용자 권한 입력을 입력하세요 (0:관리자, 1:사용자)");
				no = StudentMethod.input();
				if (no.equals("0") || no.equals("1")) {
					rp = 1;
				} else {
					System.out.println("0 또는 1 만 입력해 주세요.");
				}
			}
			System.out.println("주소를 입력하세요");
			String addr = StudentMethod.input();
			System.out.println("생일을 입력하세요 (월/일 시각:분)");
			String birth = StudentMethod.input();

			boolean result = false;
			try {
				result = sd.updateStudent(id, pass, name, Integer.parseInt(no), addr, birth);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (result) {
				StudentDto sDto = new StudentDto();
				try {
					sDto = sd.getStudent(id);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				System.out.println();
				System.out.println();
				StudentMethod.show(sDto);
				System.out.println("회원 추가를 성공했습니다.");
			} else {
				System.out.println();
				System.out.println();
				System.out.println("회원 추가를 실패했습니다.");
			}
			studentControl();
			// StudentMethod.close();

		} else if (code.equals("3")) { // 회원 삭제

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

			StudentDao sd = new StudentDao();
			boolean result = false;
			try {
				result = sd.deleteStudent(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (result) {
				System.out.println();
				System.out.println();
				System.out.println("회원 삭제를 성공했습니다.");
			} else {
				System.out.println();
				System.out.println();
				System.out.println("회원 삭제를 실패했습니다.");
			}
			studentControl();
			// StudentMethod.close();

		} else if (code.equals("9")) {
			AdminControlMenu acm = new AdminControlMenu();
			acm.controlMenu();
		} else {
			System.out.println("코드를 다시 입력하세요");
			studentControl();
		}
	}

}
