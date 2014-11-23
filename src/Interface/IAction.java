package Interface;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.View;


public interface IAction {
	public View execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
