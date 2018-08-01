import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 */

/**
 * @author kim
 *
 */
public class PersonalInfoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doGet(req, resp);

		
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		String gender = req.getParameter("gender");
		if (gender.equals("male")) {
			gender = "남";
		} else {
			gender = "여";
		}

		String iNotice = req.getParameter("inotice");
		String cNotice = req.getParameter("cnotice");
		String dNotice = req.getParameter("dnotice");

		String job = req.getParameter("job");

		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<HTML>");
		out.println("<HEAD> <TITLE> 게시판 글쓰기 - 결과화면 </TITLE> </HEAD>");
		out.println("<BODY>");
		out.println("<H2>개인 정보 입력</H2>");
		out.printf("이름  %s <br>", name);
		out.printf("아이디  %s <br>", id);
		out.printf("암호  %s <br>", password);
		out.printf("성별  %s <br>", gender);

//		out.printf("공지메일  %s <br>", noticeToHangul(iNotice));
//		out.printf("공지메일  %s <br>", noticeToHangul(cNotice));
//		out.printf("공지메일  %s <br>", noticeToHangul(dNotice));
		out.printf("공지메일  %s <br>", iNotice);
		out.printf("공지메일  %s <br>", cNotice);
		out.printf("공지메일  %s <br>", dNotice);

		out.printf("직업  %s <br>", job);

		out.println("</BODY>");
		out.println("</HTML>");

	}

/*	private String noticeToHangul(String notice) {
		if (notice == null) {
			return "받지 않음";
		} else if (notice.equals("on")) {
			return "받음";
		} else
			return notice;
	}*/

}
