package co.micol.mvc.command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.mvc.Command;

public class LoginCheckCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException {

		// 로그인 체크하는 자바클래스
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String viewPage = null;
		
		int a = Integer.parseInt(request.getParameter("pw"));

		if (id.equals("hong") && pw.equals("1234")) {
			request.setAttribute("id", id);
			request.setAttribute("pw", pw);
			viewPage = "jsp/loginOk.jsp";
		} else {
			request.setAttribute("msg", "로그인 실패 입니다.");
			viewPage = "jsp/loginFail.jsp";
		}
		return viewPage;
	}

}
