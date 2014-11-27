

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Interface.IAction;
import Model.View;

@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public FrontController() {
        super();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    	RequestDispatcher rd;
    	
    	try {
			
    		ActionFactory af = new ActionFactory();
    		IAction action = af.create(request);
    		View view = action.execute(request, response);
    		
            rd = request.getRequestDispatcher(view.getPage());
            rd.forward(request, response);
    		
		} 

        catch(ClassNotFoundException e){
            rd = request.getRequestDispatcher("/errorNotFound.html");
            rd.forward(request, response);
        }
    	
    	catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
            rd = request.getRequestDispatcher("/error.html");
            rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//this.processRequest(request, response);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPut(req, resp);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doDelete(req, resp);
	}

}
