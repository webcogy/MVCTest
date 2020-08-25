package co.micol.mvc.command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.mvc.Command;

public class MyCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		// 실행할 명령어를 기술하면 된다.
		return "jsp/myname.jsp"; // jsp폴더에 있는 myname.jsp를 선택해서 돌려준다.
	}

}
