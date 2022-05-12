package stat;


import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import insertion.*;
import preparation.*;

/**
 * Servlet implementation class Stat
 */
@WebServlet("/St")
public class Stat extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection c;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Stat() {
        super();
       
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
		c = Connect.getCon();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		User u = new User();
		Portefeuille p = new Portefeuille();
		Titre t = new Titre ();
		String path= request.getParameter("jspname");
		
		if (path.equals("stat.jsp")) {
			
		Object data = Float.toString(p.nombrePortefeuille(c));
		Object data1 = Float.toString(u.userNumber(c));
		Object data2 = Float.toString(u.courtierNumber(c));
		Object data3 = Float.toString(t.pMin(c));
		Object data4 = Float.toString(t.prixMoy(c));
		Object data5 = Float.toString(t.pMax(c));
		
		request.setAttribute("data", data);
		request.setAttribute("data1", data1);
		request.setAttribute("data2", data2);
		request.setAttribute("data3", data3);
		request.setAttribute("data4", data4);
		request.setAttribute("data5", data5);
		request.getRequestDispatcher("stat.jsp").forward(request, response);
		}
		else if (path.equals("entreprises.jsp")) {
			int [] id = new int [7];
			int [] pr = new int [7];
			String [] ent = new String[7];
			ent = p.ent(c);
			pr = p.prix(c);
			id = p.id(c);
			
			Object data = ent[0];
			Object data1 = Float.toString(pr[0]);
			Object data2 = Integer.toString(id[0]);
			
			Object data3 = ent[1];
			Object data4 = Float.toString(pr[1]);
			Object data5 = Integer.toString(id[1]);
			
			Object data6 = ent[2];
			Object data7 = Float.toString(pr[2]);
			Object data8 = Integer.toString(id[2]);
			
			Object data9 = ent[3];
			Object data10 = Float.toString(pr[3]);
			Object data11 = Integer.toString(id[3]);
			
			Object data12 = ent[4];
			Object data13 = Float.toString(pr[4]);
			Object data14 = Integer.toString(id[4]);
			
			Object data15 = ent[5];
			Object data16 = Float.toString(pr[5]);
			Object data17 = Integer.toString(id[5]);
			
			Object data18 = ent[6];
			Object data19 = Float.toString(pr[6]);
			Object data20 = Integer.toString(id[6]);
			
			request.setAttribute("data", data);
			request.setAttribute("data1", data1);
			request.setAttribute("data2", data2);
			
			request.setAttribute("data3", data3);
			request.setAttribute("data4", data4);
			request.setAttribute("data5", data5);
			
			request.setAttribute("data6", data6);
			request.setAttribute("data", data7);
			request.setAttribute("data8", data8);
			
			request.setAttribute("data9", data9);
			request.setAttribute("data10", data10);
			request.setAttribute("data11", data11);
			
			request.setAttribute("data12", data12);
			request.setAttribute("data13", data13);
			request.setAttribute("data14", data14);
			
			request.setAttribute("data15", data15);
			request.setAttribute("data16", data16);
			request.setAttribute("data17", data17);
			
			request.setAttribute("data18", data18);
			request.setAttribute("data19", data19);
			request.setAttribute("data20", data20);
			request.getRequestDispatcher("entreprises.jsp").forward(request, response);
			}
			
			
			

			
			
			
			
			
			
			
		}
		
		
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
