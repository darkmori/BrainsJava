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
public class AnimalServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String food = req.getParameter("food");
		
		HttpSession session = req.getSession();
		session.setAttribute("food", food);

		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		//pre태크로 감싸면 메모장으로 작성한듯이 똑같이 나옴
		out.println("<HTML>");
		out.println("<HEAD> <TITLE> 성격 테스튼 </TITLE> </HEAD>");
		out.println("<BODY>");
		out.println("<H3>좋아하는 동물은?</H3>");
		out.println("<form action='result'>");
		out.println("<input type='text' name='animal'>");
		out.println("<input type='submit' value='확인'>");
		out.println("</form>");
		out.println("</BODY>");
		out.println("</HTML>");
		
	}
	
}
