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
public class PersonalTestServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		
		String name = req.getParameter("name");
		String yellow = req.getParameter("yellow");
		String red = req.getParameter("red");
		String blue = req.getParameter("blue");
		String color = "";
		if(color.equals(null)) {
			color = "색깔 없음";
		}
		else if(color.equals(yellow)) {
			color = "yellow";
		}else if(color.equals(red)) {
			color = "red";
		}
		else {
			color = "blue";
		}
		
		String animal = req.getParameter("animal");
		if (animal.equals("dog")) {
			animal = "개";
		} else {
			animal = "고양이";
		}
		String jjajangmen = req.getParameter("jjajangmen");
		String jjanpong = req.getParameter("jjanpong");
		String tang = req.getParameter("tang");
		String food[] = new String[3];
		
		
		
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		out.println("<HTML>");
		out.println("<HEAD> <TITLE> 게시판 글쓰기 - 결과화면 </TITLE> </HEAD>");
		out.println("<BODY>");
		out.println("<H2>성격 테스트</H2>");
		out.printf("이름  %s <br>", name);
		out.printf("색깔  %s <br>", color);
		out.printf("동물  %s <br>", animal);
		out.printf("음식  %s <br>", jjajangmen,jjanpong,tang);
		
		
		out.println("</BODY>");
		out.println("</HTML>");

		
	}
	
	
	

}
