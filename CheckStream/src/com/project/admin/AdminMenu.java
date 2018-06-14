package com.project.admin;

import com.project.util.StudentMethod;

public class AdminMenu {

	public void adminMenu() {
		int rp = 0;
		while (rp == 0) {
			System.out.println("--------------------------------------------------");
			System.out.println("\t\t메뉴 선택 ");
			System.out.println("--------------------------------------------------");
			System.out.println(" 1. 관리 메뉴");
			System.out.println(" 2. 열람 메뉴");
			System.out.println(" 9. 뒤로 가기");
			System.out.println("--------------------------------------------------");

			String code = "";
			code = StudentMethod.input();

			if (code.equals("1")) {
				AdminControlMenu acm = new AdminControlMenu();
				acm.controlMenu();
				rp = 1;
			} else if (code.equals("2")) {
				AdminSelectMenu asm = new AdminSelectMenu();
				asm.selectMenu();
				rp = 1;
			} else if (code.equals("9")) {
				rp = 1;
			} else {
				System.out.println("잘못 입력하셨습니다");
			}
		}
	}
}
