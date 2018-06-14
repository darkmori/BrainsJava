package com.project.admin;

import java.sql.SQLException;

import com.project.util.StudentMethod;
import com.project.dao.*;

public class AdminStudentSelect {

	public void studentSelect() {

		System.out.println("--------------------------------------------------");
		System.out.println("\t\t신상 정보 열람 ");
		System.out.println("--------------------------------------------------");
		System.out.println(" 1. 전체보기");
		System.out.println(" 2. ID 로 검색");
		System.out.println(" 9. 뒤로 가기");
		System.out.println("--------------------------------------------------");

		String code = "";
		code = StudentMethod.input();

		if (code.equals("1")) {
			StudentDao sd = new StudentDao();
			try {
				StudentMethod.showStudent(sd.getAllStudent());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			studentSelect();
			// StudentMethod.close();

		} else if (code.equals("2")) {
			int rp = 0;
			String id = "";
			StudentDao sd = new StudentDao();
			while (rp == 0) {
				System.out.println("검색할 회원의 ID를 입력하세요");
				id = StudentMethod.input();
				if (!sd.hasId(id)) {
					System.out.println("없는 ID입니다.");
				} else {
					rp = 1;
				}
			}

			try {
				StudentMethod.show(sd.getStudent(id));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			studentSelect();
			// StudentMethod.close();

		} else if (code.equals("9")) {
			AdminSelectMenu asm = new AdminSelectMenu();
			asm.selectMenu();
		} else {
			System.out.println("코드를 다시 입력하세요");
			studentSelect();
		}
	}
}
