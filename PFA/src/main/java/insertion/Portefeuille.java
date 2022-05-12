package insertion;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Portefeuille {
	private int id;
	private int nbr;
	public Portefeuille() {}
	public Portefeuille(int id) {
		setId(id);
	}
	
	public Portefeuille(int id,int nbr) {
		setId(id);
		setNbr(nbr);
		}
	
	public void createPortefeuille(Connection c) {
		PreparedStatement q;
		try {
			q =c.prepareStatement("insert into portefeuille values (?,?)");
			q.setInt(1,id);
			q.setInt(2,nbr);
			q.executeUpdate();
			q.close();
		}catch(Exception e) {}

	}
	public float calculPortefeuille(Connection c, int id) {
		float p=0;
		int i = 0;
		try {
			Statement stmt = c.createStatement();
			String selectPrix=String.format("select prix from titre where id ='%s' ", Integer.toString(id));
			String selectNbr=String.format("select nbr from portefeuille where id ='%s' ", Integer.toString(id));
			ResultSet r=stmt.executeQuery(selectNbr);
			while(r.next()) { i =r.getInt(1);}
			ResultSet rs = stmt.executeQuery(selectPrix);
			while(rs.next()) { p=rs.getFloat(1);}		
		}catch(Exception e) {}
		return p*i;	
	}
	public int nombrePortefeuille(Connection c ) {
		int count = 0;
		try {
			Statement stmt = c.createStatement();
			String selectTable="select count(id) from portefeuille ";
			ResultSet rs = stmt.executeQuery(selectTable);
			while(rs.next()) {count=rs.getInt(1);}		
		}catch(Exception e) {}
		return count;
	}
	
	
	
public String [] ent (Connection c) {
		String [] s =new String[7];
		try {
			Statement stmt = c.createStatement();
			String selectEntreprise="select entreprise from portefeuille p, titre t where t.id=p.id";
			ResultSet r = stmt.executeQuery(selectEntreprise);
		
			while(r.next()) {
				for (int i = 0 ;i<7;i++) {
					s[i]=r.getString(i+1);
				}
			}
			}catch(Exception e) {}
		return s;
		}
	
	
public int [] prix (Connection c) {
	int [] a =new int[7];	
	try {
		Statement stmt = c.createStatement();
		String selectNbr="select prix from portefeuille p, titre t where t.id=p.id";
		ResultSet rs = stmt.executeQuery(selectNbr);
		
		
		
		while(rs.next()) {
			for (int i =0 ; i<7;i++) {
			a[i]=rs.getInt(i+1);}}
	}catch(Exception e) {}
	
	return a;
	}

public int [] id (Connection c) {
	int [] a =new int[7];
	try {
		Statement stmt = c.createStatement();
		String selectNbr="select id from portefeuille";
		ResultSet rs = stmt.executeQuery(selectNbr);
		
		
		
		while(rs.next()) {
			for (int i =0 ; i<7;i++) {
			a[i]=rs.getInt(i+1);}}
	}catch(Exception e) {}
	
	return a;
	}

	
	
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNbr() {
		return nbr;
	}
	public void setNbr(int nbr) {
		this.nbr = nbr;
	}

}
