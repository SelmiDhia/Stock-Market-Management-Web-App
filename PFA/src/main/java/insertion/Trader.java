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

import preparation.Connect;

/**
 * Servlet implementation class Trader
 */
@WebServlet("/Tr")
public class Trader extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 Connection c;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Trader() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		c =Connect.getCon();
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//PrintWriter out= response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		int nbr = Integer.parseInt(request.getParameter("nbr"));
		Portefeuille p = new Portefeuille(id,nbr);
		Titre t = new Titre (id);
		if (t.trouveTitre(c, id)==true) {
			p.createPortefeuille(c);
			RequestDispatcher dispatcher = request.getRequestDispatcher("entreprises.jsp");
			dispatcher.forward(request, response);
		}
		else {RequestDispatcher dispatcher = request.getRequestDispatcher("trader.jsp");
		dispatcher.forward(request, response);}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}
