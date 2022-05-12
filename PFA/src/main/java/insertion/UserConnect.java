package insertion;

import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import preparation.Connect;

/**
 * Servlet implementation class UserConnect
 */
@WebServlet("/UC")
public class UserConnect extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection c;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserConnect() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		c =Connect.getCon();
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		//PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		if (this.c!=null) {
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String email = request.getParameter("email");
			String metier = request.getParameter("metier");
			String user = request.getParameter("user");
			String pass = request.getParameter("mdp");
			String tel = request.getParameter("tel");
			String birth = request.getParameter("date");
			String adr = request.getParameter("adr");
			String crt = request.getParameter("rib");
			String cvv = request.getParameter("cvv");
			String path=request.getParameter("jspname");
			
			User u=new User(nom,prenom,email,metier,user,pass,tel,birth,adr,crt,cvv);
			
			if(path.equals("inscription.jsp")) {
			u.insertion(c);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Connexion.jsp");
			dispatcher.forward(request, response);}
			
			else if(path.equals("Connexion.jsp")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(u.connexion(c));
			dispatcher.forward(request, response);
			}
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
