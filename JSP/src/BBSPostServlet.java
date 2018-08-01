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
public class BBSPostServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		
		//post방식은 인코딩을 잡아줘야 함
		req.setCharacterEncoding("UTF-8");
		
		String name = req.getParameter("NAME");
		String title = req.getParameter("TITLE");
		String content = req.getParameter("CONTENT");
	
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		//pre태크로 감싸면 메모장으로 작성한듯이 똑같이 나옴
		out.println("<HTML>");
		out.println("<HEAD> <TITLE> 게시판 글쓰기 - 결과화면 </TITLE> </HEAD>");
		out.println("<BODY>");
		out.printf("이름  %s <br>" , name );
		out.printf("제목  %s <br>" , title);
		out.println("---------<br>");
		out.printf("<pre> %s </pre>" , content);
		out.println("---------<br>");
		out.println("저장되었습니다.");
		out.println("</BODY>");
		out.println("</HTML>");
		

	}

}
