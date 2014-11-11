import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class List implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "list.jsp";
	}

}
