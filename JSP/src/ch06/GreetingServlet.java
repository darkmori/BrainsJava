/**
 * 
 */
package ch06;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author kim
 *
 */
public class GreetingServlet extends HttpServlet {
	
	private PrintWriter logFile;
	
	@Override
	public void init() throws ServletException {
		try {
			//로그파일을 생성
			logFile = new PrintWriter(new FileWriter("c:\\data\\log.txt", true));
		} catch (IOException e) {
			throw new ServletException();
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("NAME");
		String greeting = "안녕하세요, " + name + "님";
		
		if(logFile != null) {
			GregorianCalendar now = new GregorianCalendar();
			logFile.printf("%TF %TT - %s %n", now, now, name);
		}
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<HTML>");
		out.println("<HEAD> <TITLE> 인사하기 </TITLE> </HEAD>");
		out.println("<BODY>");

		out.println(greeting);

		out.println("</BODY>");
		out.println("</HTML>");
		
	}

	@Override
	public void destroy() {
		if(logFile != null) {
			//로그파일을 닫음, 이때 저장이 이루어진다
			logFile.close();
		}
	}

}
