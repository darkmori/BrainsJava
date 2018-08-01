import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 */

/**
 * @author kim
 *
 */
public class ResultServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String food = (String) session.getAttribute("food");
		
		String animal = req.getParameter("animal");
		session.invalidate();
		
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		//pre태크로 감싸면 메모장으로 작성한듯이 똑같이 나옴
		out.println("<HTML>");
		out.println("<HEAD> <TITLE> 성격 테스튼 </TITLE> </HEAD>");
		out.println("<BODY>");
		out.println("<H3>성격테스트</H3>");
		out.printf("당신은 %s %s를 좋아하는 성격입니다.", food, animal);
		out.println("</form>");
		out.println("</BODY>");
		out.println("</HTML>");

	}
	

}
