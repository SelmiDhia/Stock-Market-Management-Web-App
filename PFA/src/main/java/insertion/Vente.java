package insertion;

import java.io.IOException;
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
 * Servlet implementation class Vente
 */
@WebServlet("/Vt")
public class Vente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection c;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Vente() {
        super();
        // TODO Auto-generated constructor stub
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
		
		String path=request.getParameter("jspname");
		Courtier ct = new Courtier();
		if(path.equals("vendre.jsp")) {
			int id = Integer.parseInt(request.getParameter("id"));
			String type = request.getParameter("type");
			float prix = Float.parseFloat(request.getParameter("prix"));
			int duree = Integer.parseInt(request.getParameter("life"));
			String entreprise = request.getParameter("entreprise");
			float rendement  = Float.parseFloat(request.getParameter("rendement"));
			float volatilite = Float.parseFloat(request.getParameter("volatilite"));
			Titre t = new Titre(id,type,prix,duree,entreprise,rendement,volatilite);
			ct.ajout(c,t);
			RequestDispatcher dispatcher = request.getRequestDispatcher("vendre.jsp");
			dispatcher.forward(request, response);
			}
		else if (path.equals("acheter.jsp")) {
			int id = Integer.parseInt(request.getParameter("id"));
			Titre t = new Titre(id);
			Portefeuille p = new Portefeuille(id);
			if(t.trouveTitre(c, id)==true) {
			Object data = "Opération validé ";
			Object data1 = "Le prix du portefeuille = "+Float.toString(p.calculPortefeuille(c, id))+"$";
			request.setAttribute("data", data);
			request.setAttribute("data1", data1);
		    request.getRequestDispatcher("acheter.jsp").forward(request, response);}
			else {Object data = "Opération echoué";
		    request.setAttribute("data", data);
		    request.getRequestDispatcher("acheter.jsp").forward(request, response);}}
		
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("inscription.jsp");
			dispatcher.forward(request, response);}
		
	}
		
		
		
		
		
		
		
		
		
		

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
