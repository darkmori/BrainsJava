package com.project.admin;

import com.project.util.StudentMethod;

public class AdminSelectMenu {

	public void selectMenu() {

		System.out.println("--------------------------------------------------");
		System.out.println("\t\t열람 메뉴 선택 ");
		System.out.println("--------------------------------------------------");
		System.out.println(" 1. 학생 신상 열람");
		System.out.println(" 2. 학생 성적 열람");
		System.out.println(" 3. 학생 벌금 열람");
		System.out.println(" 4. 학생 출석 열람");
		System.out.println(" 9. 뒤로 가기");
		System.out.println("--------------------------------------------------");

		String code = "";
		code = StudentMethod.input();

		if (code.equals("1")) {
			AdminStudentSelect ass = new AdminStudentSelect();
			ass.studentSelect();

		} else if (code.equals("2")) {
			AdminGradeSelect ags = new AdminGradeSelect();
			ags.gradeSelect();

		} else if (code.equals("3")) {
			AdminPenaltySelect aps = new AdminPenaltySelect();
			aps.penaltySelect();

		} else if (code.equals("4")) {
			AdminAttendSelect aas = new AdminAttendSelect();
			aas.attendSelect();

		} else if (code.equals("9")) {
			AdminMenu am = new AdminMenu();
			am.adminMenu();
		} else {
			System.out.println("다시 입력해 주세요.");
			this.selectMenu();
		}
	}

}
