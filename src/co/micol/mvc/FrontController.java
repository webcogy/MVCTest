package co.micol.mvc;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.mvc.command.HomeCommand;
import co.micol.mvc.command.LoginCheckCommand;
import co.micol.mvc.command.LoginFormCommand;
import co.micol.mvc.command.MyCommand;
import co.micol.mvc.command.OrderFormCommand;
import co.micol.mvc.command.OrderResultCommand;

// @WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map;

	public FrontController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {

		// 여기가 명령어를 분석하는 맵을 생성
		map = new HashMap<String, Command>();

		// 이런형태로 호출명과 실행 명령어를 담아둔다.
		map.put("/home.do", new HomeCommand()); // 인덱스 페이지 호출
		map.put("/my.do", new MyCommand()); // 나의 이름 페이지 호출
		map.put("/loginForm.do", new LoginFormCommand());
		map.put("/LoginCheck.do", new LoginCheckCommand()); // 로그인체크
		map.put("/order.do", new OrderFormCommand());
		map.put("/orderResult.do", new OrderResultCommand()); // 주문처리, 계산서
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 요청을 처리하는 부분 기술
		request.setCharacterEncoding("UTF-8"); // 한글깨짐 방지를 위해
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String commandPath = uri.substring(contextPath.length());

		Command command = map.get(commandPath); // 필요한 Command객체를 찾아옴
		String viewPage = command.exec(request, response); // 명령실행 후 보여줄 결과 페이지 선택

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response); // 결과 페이지를 돌려준다.
	}

}
