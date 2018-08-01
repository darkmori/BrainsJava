/**
 * 
 */
package Example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author kim
 *
 */
public class PersonTestView extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String number = req.getParameter("number");
		
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<HTML>");
		out.println("<HEAD> <TITLE>개인정보 출력 예제</TITLE> </HEAD>");
		out.println("<BODY>");
		out.println("<h2>개인정보 출력</h2><br/>");
		out.println("이름 : " + name + "<br/>");
		out.println("전화번호 : " + number + "<br/>");
		out.println("</BODY>");
		out.println("</HTML>");
		
	}

}
