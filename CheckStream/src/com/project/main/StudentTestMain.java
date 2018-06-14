/* 
 * 
 * ------------------------------------------------------
 *                       기능
 * ------------------------------------------------------
 *      1. 학생 개인정보 간리
 *      2. 출석체크(지각 및 조퇴처리)
 *      3. 학생 성적 관리
 *      4. 벌금 부과
 * 
 * ------------------------------------------------------
 *                         DB (ORACLE)
 * ------------------------------------------------------
 *      student - 메인 테이블, 학생 개인 정보 관리
 *                필드 : ID  NOT NULL  VARCHAR2(15) PRIMARY KEY //회원 아이디  
 						PASSWORD  NOT NULL  VARCHAR2(15)  //비밀번호
 						NAME  NOT NULL  VARCHAR2(15)  //이름
 						NO  NOT NULL  NUMBER(3)  //회원 등급 1:학생 2:관리자
 						ADDR     VARCHAR2(40)  //주소
 						BIRTHDAY     VARCHAR2(20)  //생년월일 (년/월/일)
 * 		attend - 출석을 위한 테이블
 * 				 필드 : 	SEQ  NOT NULL  NUMBER(5) PRIMARY KEY // attend_seq 시퀀스 사용  
 						ID  NOT NULL  VARCHAR2(15) FOREIGN KEY REFERENCE STUDENT //아이디 
 						ATTEND     VARCHAR2(10)   // 출석체크, 출석하면 1, 아니면 0 or null
 						LATE     VARCHAR2(10)  //지각체크, 지각하면 1, 아니면 0 or null
 						EARLY     VARCHAR2(10)  //조퇴체크, 조퇴하면 1, 아니면 0 or null
 						FINISH     VARCHAR2(10)  //퇴근체크, 퇴근하면 1, 아니면 0 or null
 						ADATE     VARCHAR2(20)  //시간 기록 (월/일 시각:분)
 * 		grade - 성적관리를 위한 테이블
 *              필드 :	SEQ  NOT NULL  NUMBER(10) PRIMARY KEY //grade_seq 시퀀스 사용
 						ID  NOT NULL  VARCHAR2(15) FOREIGN KEY REFERENCE STUDENT //아이디
 						GRADE     VARCHAR2(10)  //성적
 						SUBJECT     VARCHAR2(10)  //과목명
 		penalty - 벌금 관리를 위한 테이블
 				   필드 : SEQ  NOT NULL  NUMBER(5)  PRIMARY KEY //penalty_seq 시퀀스 사용
 				   		ID  NOT NULL  VARCHAR2(15) FOREIGN KEY REFERENCE STUDENT //아이디
 				   		AMOUNT     NUMBER(10)  //벌금 금액
 				   		WHY     VARCHAR2(20)  //벌금 부과 이유
 				   		PDATE     VARCHAR2(20)  //시간 기록 (월/일 시각:분)
 * 
 * ------------------------------------------------------
 *                         클래스
 * ------------------------------------------------------
 *    com.project.admin -> 	AdminAttendControl //출석 수정
 * 							AdminAttendSelect //출석 열람
 * 							AdminControlMenu //관리(수정)메뉴 선택부
 * 							AdminGradeControl //성적 수정
 * 							AdminGradeSelect //성적 열람
 * 							AdminMenu //로그인한 사용자가 관리자일때 호출되는 어드민 메인
 * 							AdminPenaltyControl //벌금 수정
 * 							AdminPenaltySelect //벌금 열람
 * 							AdminSelectMenu //열람메뉴 선택부
 * 							AdminStudentControl //학생정보 수정
 * 							AdminPenaltySelect //학생정보 보기
 * 
 *    com.project.dao ->	AbstractDao //드라이버로딩과 클로즈를 위한 추상클래스. 다른 DAO가 상속받음.
 * 							AttendDao //attend 테이블에 대한 쿼리를 위한 DAO
 * 							GradeDao //grade 테이블에 대한 쿼리를 위한 DAO
 * 							PenaltyDao //penalty 테이블에 대한 쿼리를 위한 DAO
 * 							StudentDao //student 테이블에 대한 쿼리를 위한 DAO
 * 
 *    com.project.dto ->	AttendDto //attend 테이블을 위한 DTO
 * 							GradeDto //grade 테이블을 위한 DTO
 * 							PenaltyDto //penalty 테이블을 위한 DTO
 * 							StudentDto //student 테이블을 위한 DTO
 *    com.project.main ->	LogInProCess //로그인 및 회원가입 처리
 * 
 * 							StudentTestMain //메인!!!!
 * 							Users //로그인한 사용자가 학생일 경우
 * 
 *    com.project.util ->	SceneUtil //메인에서 사용할 화면전환 상수모음
 * 							StudentMethod //공통적으로 사용될 메서드 모음
 * 							StudentUtil //DB 쿼리를 위한 상수모음
 * 
 * 
 */

/*프로젝트 메인클래스
 * 
 * ---------------------------------------------------------
 *             public class StudentTestMain
 * ---------------------------------------------------------
 * public static int status -> 화면이동 위한 변수
 * 
 * public static void main(String[] args) -> 메인
 * 
 */

package com.project.main;

import java.sql.SQLException;

import com.project.dto.StudentDto;
import com.project.util.*;
import com.project.admin.AdminMenu;

public class StudentTestMain {
	public static int status = SceneUtil.MAIN;

	public static void main(String[] args) {
		StudentDto stuDto = null;
		while (status != SceneUtil.DONE) { // status로 화면이동 관리
			switch (status) {

			case SceneUtil.MAIN:// 기본 메뉴 창
				LogInProcess lis = new LogInProcess();
				lis.loginView(); // 메인 메뉴 출력
				System.out.print("메뉴를 선택해 주세요. => ");
				String sel = StudentMethod.input();
				//
				if (sel.equals("1")) { // 1. 로그인
					stuDto = lis.login(); // 로그인 처리

				} else if (sel.equals("2")) { // 2번 회원가입
					// 회원 가입.
					lis.joinView();
					lis.join();
				} else {
					System.out.println("1번 또는 2번 키를 누르세요.");
				}

				break;

			case SceneUtil.ADMINMENU:// 관리자창
				AdminMenu adm = new AdminMenu();
				adm.adminMenu();

				status = SceneUtil.DONE;
				break;
			case SceneUtil.USERMENU:// 사용자창
				try {
					Users usr = new Users();
					usr.userFirstMenu(stuDto);
					status = SceneUtil.DONE;
					break;
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}// switch
		} // while

		System.out.println("--------------------------------------------------");
		System.out.println("\t\t이용해주셔서 감사합니다.");
		System.out.println("\t\tmade by 3조 \n\t\tAll rights reserved");
		System.out.println("--------------------------------------------------");
	}// main
}// class
