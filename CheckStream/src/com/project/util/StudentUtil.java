// 상수 정의를 위한 클래스  StudentUtil

package com.project.util;

public final class StudentUtil {

	// JDBC
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String url = "jdbc:mysql://localhost:3306/malldb";
	public static final String USER = "root";
	public static final String PASS = "12345";

	// for AttendDao class - DB : attend
	public static final String GETALLATTEND = "select * from attend ORDER BY id ASC";
	public static final String GETIDATTEND = "select * from attend where id=? ORDER BY ADATE ASC";
	public static final String GETATTEND = "select * from attend where id=? and adate=? ORDER BY ADATE ASC";
	public static final String ADDATTEND = "insert into attend values(attend_seq.nextval,?,?,?,?,?,?)";
	public static final String CHECKATTEND = "insert into attend values(attend_seq.nextval,?,?,?,?,?,?)";
	public static final String CHECKFINISH = "insert into attend values(attend_seq.nextval,?,?,?,?,?,?)";
	public static final String UPDATEATTEND = "update attend set attend=?, late=?, early=?, finish=?, adate=? where id=? and adate=?";
	public static final String ISATTEND = "select * from attend where id=?";
	public static final String ISGOHOME = "select * from attend where id=? and finish=?";

	// for StudentDao class - DB : student
	public static final String GETALLSTUDENT = "select * from student ORDER BY id ASC";
	public static final String GETSTUDENT = "SELECT * FROM STUDENT WHERE ID=?";
	public static final String HASSTUDENTS = "SELECT ID FROM STUDENT WHERE ID=?";
	public static final String DELETESTUDENT = "DELETE FROM STUDENT WHERE ID=?";
	public static final String JOINSTUDENT = "INSERT INTO STUDENT VALUES(?,?,?,?,?,?)";
	public static final String UPDATESTUDENT = "UPDATE STUDENT SET password=?, name=?, no=?, ADDR=?, BIRTHday=? WHERE ID=?";
	public static final String HASSTUDENT = "select id from student where id=?";

	// for GradeDao class - DB : grade
	public static final String GETALLGRADE = "select * from grade ORDER BY id ASC";
	public static final String GETIDGRADE = "select * from grade where id = ? ORDER BY subject ASC";
	public static final String GETSUBJECTGRADE = "select * from grade where subject = ? ORDER GRADE id ASC";
	public static final String ADDGRADE = "insert into grade values(grade_seq.nextval, ?, ?, ?)";
	public static final String UPDATEGRADE = "update grade set grade=?, subject=? where id=? and subject=?";
	public static final String DELETEGRADE = "delete from grade where id=? and subject=?";
	public static final String GETGRADE = "select * from grade where id=? and subject=?";
	public static final String HASSUBJECT = "select subject from grade where subject=?";

	// for PenaltyDao class - DB : penalty
	public static final String GETALLPENALTY = "select * from penalty ORDER BY id ASC";
	public static final String GETIDPENALTY = "select * from penalty where id = ? ORDER BY PDATE ASC";
	public static final String DELETEPENALTY = "delete from penalty where pdate=?";
	public static final String ADDPENALTY = "insert into penalty values(penalty_seq.nextval, ?, ?, ?, ?)";
	public static final String UPDATEPENALTY = "update penalty set amount=?, why=? where id=? and pdate=? and why like ?";
	public static final String GETPENALTY = "select * from penalty where id=? and pdate=? and why like ? ORDER BY PDATE ASC";
}