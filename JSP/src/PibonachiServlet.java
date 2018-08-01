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
public class PibonachiServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doGet(req, resp);
		PrintWriter out = resp.getWriter();
		
		out.println("<HTML>");
		out.println("<HEAD> <TITLE> 게시판 글쓰기 - 결과화면 </TITLE> </HEAD>");
		out.println("<BODY>");

		
		int a = 1, b = 1, c = 0;
		out.print(a + " ");
		out.print(b + " ");
		while (true) {
			c = a + b;
			a = b;
			b = c;
			if (c < 100) {
				out.printf("%d",c);
				out.println(" ");

			} else {
				break;
			}
		}
	

		out.println("</BODY>");
		out.println("</HTML>");


	}
}
