package com.project.admin;

import java.sql.SQLException;

import com.project.admin.AdminSelectMenu;
import com.project.util.StudentMethod;
import com.project.dao.*;

public class AdminAttendSelect {

	public void attendSelect() {

		System.out.println("--------------------------------------------------");
		System.out.println("\t\t출석 정보 열람 ");
		System.out.println("--------------------------------------------------");
		System.out.println(" 1. 전체보기");
		System.out.println(" 2. ID 로 검색");
		System.out.println(" 9. 뒤로 가기");
		System.out.println("--------------------------------------------------");

		String code = "";
		code = StudentMethod.input();

		if (code.equals("1")) {
			AttendDao ad = new AttendDao();
			try {
				StudentMethod.showAttend(ad.getAllAttend());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			attendSelect();
			// StudentMethod.close();

		} else if (code.equals("2")) {
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
			AttendDao ad = new AttendDao();
			try {
				StudentMethod.showAttend(ad.getIdAttend(id));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			attendSelect();
			// StudentMethod.close();

		} else if (code.equals("9")) {
			AdminSelectMenu asm = new AdminSelectMenu();
			asm.selectMenu();
		} else {
			System.out.println("다시 입력하세요");
			attendSelect();
		}
	}
}
