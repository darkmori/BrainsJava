import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class HundredServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doGet(request, response);

		int total = 0;
		for (int cnt = 1; cnt <= 10; cnt++)
			total += cnt;
		
		//result에 total이라는 값을 다른페이지로 옮길떄 전해줌
		request.setAttribute("result", total);
		
		String str = "Jsp Programing";
		request.setAttribute("WebPrograming", str);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("Hundred2.jsp");
		rd.forward(request, response);
		
		/*PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD> <TITLE> Hundred Servlet </TITLE> </HEAD>");
		out.println("<BODY>");
		out.printf("1 + 2 + 3 + ... + 10 = %d", total);
		out.println("</BODY>");
		out.println("</HTML>");*/

	}

}
