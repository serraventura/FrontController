import javax.servlet.http.HttpServletRequest;


public class ActionFactory {
	
	public Action create(HttpServletRequest request) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		String action = request.getParameter("a").toString();		
		
		@SuppressWarnings("rawtypes")
		Class cls = Class.forName(action);

		Action classAction = (Action) cls.newInstance(); 
		
		return classAction;
	}
	
}
