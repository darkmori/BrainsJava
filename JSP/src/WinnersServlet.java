import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
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
public class WinnersServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int arr[] = new int[5];
		Random random = new Random();

		for (int cnt = 0; cnt < arr.length; cnt++) {
			arr[cnt] = random.nextInt(45)+1;	//5개의 정수를 랜덤으로 추출
		}
		System.out.println(arr);
		req.setAttribute("Arr", arr);
		
		RequestDispatcher rd = req.getRequestDispatcher("Winners.jsp");
		rd.forward(req, resp);
	}

}
