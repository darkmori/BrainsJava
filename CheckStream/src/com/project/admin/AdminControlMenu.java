package com.project.admin;

import com.project.admin.AdminAttendControl;
import com.project.admin.AdminGradeControl;
import com.project.admin.AdminPenaltyControl;
import com.project.admin.AdminStudentControl;
import com.project.util.StudentMethod;

public class AdminControlMenu {

	public void controlMenu() {

		System.out.println("--------------------------------------------------");
		System.out.println("\t\t包府 皋春 急琶 ");
		System.out.println("--------------------------------------------------");
		System.out.println(" 1. 切积 脚惑 包府");
		System.out.println(" 2. 切积 己利 包府");
		System.out.println(" 3. 切积 国陛 包府");
		System.out.println(" 4. 切积 免籍 包府");
		System.out.println(" 9. 第肺 啊扁");
		System.out.println("--------------------------------------------------");

		String code = "";
		code = StudentMethod.input();

		if (code.equals("1")) {
			AdminStudentControl asc = new AdminStudentControl();
			asc.studentControl();

		} else if (code.equals("2")) {
			AdminGradeControl agc = new AdminGradeControl();
			agc.gradeControl();

		} else if (code.equals("3")) {
			AdminPenaltyControl apc = new AdminPenaltyControl();
			apc.penaltyControl();

		} else if (code.equals("4")) {
			AdminAttendControl aac = new AdminAttendControl();
			aac.attendControl();

		} else if (code.equals("9")) {
			AdminMenu am = new AdminMenu();
			am.adminMenu();
		}
	}

}
