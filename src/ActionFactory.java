import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import Interface.IAction;

public class ActionFactory {
	
	private static final String SUFIX = "Ctrl";
	private static final String PREFIX = "Controller.";
	private Pattern regExAllPattern = Pattern.compile("/([A-Za-z])\\w+");
    private Pattern regExIdPattern = Pattern.compile("/([0-9])");

    private Integer id;
    private String action;
    
	public IAction create(HttpServletRequest request) throws ClassNotFoundException, InstantiationException, IllegalAccessException{

		// regex parse pathInfo
		Matcher matcher;
		
		matcher = regExIdPattern.matcher(request.getPathInfo());

		if (matcher.find()) {
			id = Integer.parseInt(matcher.group(1));
		}

		matcher = regExAllPattern.matcher(request.getPathInfo());
		
		if (matcher.find()){
			action = matcher.group();
		}
		
		//String action = request.getParameter("a").toString().toLowerCase();

		action = action.replace("/", "").toLowerCase();
		action = PREFIX+Character.toString(action.charAt(0)).toUpperCase()+action.substring(1)+SUFIX.toString();

		@SuppressWarnings("rawtypes")
		Class cls = Class.forName(action);

		IAction classAction = (IAction) cls.newInstance(); 
		
		return classAction;
	}
	
}
