package Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Interface.IAction;
import Model.View;



public class ListCtrl implements IAction {

	@Override
	public View execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		View view = new View();
		view.setPage("list.jsp");
		
		return view;

	}

}
