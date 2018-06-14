package com.project.admin;

import java.sql.SQLException;

import com.project.dao.*;
import com.project.admin.AdminControlMenu;
import com.project.util.StudentMethod;
import com.project.dto.GradeDto;

public class AdminGradeControl {

	public void gradeControl() {

		System.out.println("--------------------------------------------------");
		System.out.println("\t\t성적 정보 관리 ");
		System.out.println("--------------------------------------------------");
		System.out.println(" 1. 추가");
		System.out.println(" 2. 수정");
		System.out.println(" 3. 삭제");
		System.out.println(" 9. 뒤로 가기");
		System.out.println("--------------------------------------------------");

		String code = "";
		code = StudentMethod.input();

		if (code.equals("1")) {
			int rp = 0;
			String id = "";
			StudentDao sd = new StudentDao();
			while (rp == 0) {
				System.out.println("ID를 입력하세요");
				id = StudentMethod.input();
				if (!sd.hasId(id)) {
					System.out.println("없는 ID입니다.");
				} else {
					rp = 1;
				}
			}
			System.out.println("성적을 입력하세요");
			String grade = StudentMethod.input();
			System.out.println("과목명을 입력하세요");
			String subject = StudentMethod.input();

			GradeDao gd = new GradeDao();
			boolean result = false;
			try {
				result = gd.AddGrade(id, grade, subject);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (result) {
				GradeDto gDto = new GradeDto();
				try {
					gDto = gd.getGrade(id, subject);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				System.out.println();
				System.out.println();
				StudentMethod.show(gDto);
				System.out.println("성적정보 수정을 성공했습니다.");
			} else {
				System.out.println();
				System.out.println();
				System.out.println("출석정보 수정을 실패했습니다.");
			}
			gradeControl();
			// StudentMethod.close();

		} else if (code.equals("2")) {
			System.out.println("수정할 데이터의 ID와 과목명을 입력하세요.");
			int rp = 0;
			String id = "";
			StudentDao sd = new StudentDao();
			while (rp == 0) {
				System.out.println("ID를 입력하세요");
				id = StudentMethod.input();
				if (!sd.hasId(id)) {
					System.out.println("없는 ID입니다.");
				} else {
					rp = 1;
				}
			}
			System.out.println("과목명을 입력하세요");
			String subject2 = StudentMethod.input();
			System.out.println();
			System.out.println();
			System.out.println("수정할 데이터를 입력하세요");

			System.out.println("성적을 입력하세요");
			String grade = StudentMethod.input();
			System.out.println("과목명을 입력하세요");
			String subject = StudentMethod.input();

			GradeDao gd = new GradeDao();
			boolean result = false;
			try {
				result = gd.updateGrade(id, grade, subject, subject2);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (result) {
				GradeDto gDto = new GradeDto();
				try {
					gDto = gd.getGrade(id, subject2);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				System.out.println();
				System.out.println();
				StudentMethod.show(gDto);
				System.out.println("성적정보 수정을 성공했습니다.");
			} else {
				System.out.println();
				System.out.println();
				System.out.println("출석정보 수정을 실패했습니다.");
			}
			gradeControl();
			// StudentMethod.close();

		} else if (code.equals("3")) {
			int rp = 0;
			String id = "";
			StudentDao sd = new StudentDao();
			while (rp == 0) {
				System.out.println("ID를 입력하세요");
				id = StudentMethod.input();
				if (!sd.hasId(id)) {
					System.out.println("없는 ID입니다.");
				} else {
					rp = 1;
				}
			}
			System.out.println("과목명을 입력하세요");
			String subject = StudentMethod.input();
			GradeDao gd = new GradeDao();
			boolean result = false;
			try {
				result = gd.deleteGrade(id, subject);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (result) {
				System.out.println();
				System.out.println("성적정보를 삭제했습니다.");
			} else {
				System.out.println();
				System.out.println("성적정보를 삭제하지 못했습니다.");
			}
			gradeControl();
			// StudentMethod.close();

		} else if (code.equals("9")) {
			AdminControlMenu acm = new AdminControlMenu();
			acm.controlMenu();
		} else {
			System.out.println("다시 입력하세요");
			gradeControl();
		}
	}

}
