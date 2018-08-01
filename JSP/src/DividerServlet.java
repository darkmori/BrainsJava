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
public class DividerServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String str1 = req.getParameter("NUM1");
		String str2 = req.getParameter("NUM2");

		int num1 = Integer.parseInt(str1);
		int num2 = Integer.parseInt(str2);

		int result = num1 / num2;
		
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<HTML>");
		out.println("<HEAD> <TITLE> 나눗셈 프로그램 </TITLE> </HEAD>");
		out.println("<BODY>");
		out.printf("%d / %d = %d" , num1 , num2 , result);
		
		out.println("</BODY>");
		out.println("</HTML>");


	}

}
