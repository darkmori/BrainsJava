// Logic부분에서 공통적으로 사용할 메서드를 위한 클래스.

package com.project.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

import com.project.dto.*;

public class StudentMethod {

	public static String input() {

		String s = "";
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			s = br.readLine().trim();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return s;
	}

	// public static void close(){
	// try {
	// br.close();
	// isr.close();
	// } catch (IOException e) {
	// }

	// }

	public static void showStudent(Vector v) {
		for (int i = 0; i < v.size(); i++) {
			StudentDto dto = (StudentDto) v.get(i);
			show(dto);
		}
	} // show

	public static void showGrade(Vector v) {
		for (int i = 0; i < v.size(); i++) {
			GradeDto dto = (GradeDto) v.get(i);
			show(dto);
		}
	} // show

	public static void showAttend(Vector v) {
		for (int i = 0; i < v.size(); i++) {
			AttendDto dto = (AttendDto) v.get(i);
			show(dto);
		}
	} // show

	public static void showPenalty(Vector v) {
		for (int i = 0; i < v.size(); i++) {
			PenaltyDto dto = (PenaltyDto) v.get(i);
			show(dto);
		}
	} // show

	public static void show(StudentDto dto) {
		System.out.println(dto);
	}

	public static void show(GradeDto dto) {
		System.out.println(dto);
	}

	public static void show(AttendDto dto) {
		System.out.println(dto);
	}

	public static void show(PenaltyDto dto) {
		System.out.println(dto);
	}

	public static String toStrNull(String str) {
		String ss = "";
		if (str == null || str.equals("null") || str.equals("")) {
			ss = "";
		} else {
			ss = str.trim();
		}
		return ss;
	}
}
