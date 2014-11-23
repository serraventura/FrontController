import javax.servlet.http.HttpServletRequest;

import Interface.IAction;

public class ActionFactory {
	private static final String SUFIX = "Ctrl";
	private static final String PREFIX = "Controller.";
	public IAction create(HttpServletRequest request) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		String action = request.getParameter("a").toString().toLowerCase();

		action = PREFIX+Character.toString(action.charAt(0)).toUpperCase()+action.substring(1)+SUFIX.toString();
		
		@SuppressWarnings("rawtypes")
		Class cls = Class.forName(action);

		IAction classAction = (IAction) cls.newInstance(); 
		
		return classAction;
	}
	
}
