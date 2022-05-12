package insertion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Titre {
	private int id;
	private String type;
	private float prix;
	private int duree;
	private String entreprise;
	private float rendement;
	private float volatilite;
	public Titre() {}
	public Titre (int id) {setId(id);}
	
	public Titre(int id, String type,float prix,int duree,String entreprise,float rendement,float volatilite) {
		setId(id);
		setType(type);
		setPrix(prix);
		setDuree(duree);
		setEntreprise(entreprise);
		setRendement(rendement);
		setVolatilite(volatilite);
	}
	public boolean trouveTitre(Connection c,int id) {
		
		boolean b=false;
		try {
			Statement stmt = c.createStatement();
			String selectTable="select id from titre";
			ResultSet rs = stmt.executeQuery(selectTable);
			int id1 = 0;
			while(rs.next()) {
				id1=rs.getInt(1);
				if(id==id1) {b=true; break;}
				
			}		
			
		}catch(SQLException e) {
			e.getErrorCode();
			}
		
		
		return b;		
	}

	public int nombreTitre(Connection c ) {
		int count = 0;
		try {
			Statement stmt = c.createStatement();
			String selectTable="select count(id) from titre ";
			ResultSet rs = stmt.executeQuery(selectTable);
			while(rs.next()) {count=rs.getInt(1);}		
		}catch(Exception e) {}
		return count;
	}
	public int nombreOb(Connection c) {
		int count=0;
		try {
			Statement stmt = c.createStatement();
			String selectTable="select count(id) from titre where type ='Obligation' ";
			ResultSet rs = stmt.executeQuery(selectTable);
			while(rs.next()) {count=rs.getInt(1);}		
		}catch(Exception e) {}
		return count;
		
	}
	public int nombreAc(Connection c) {
		int count=0;
		try {
			Statement stmt = c.createStatement();
			String selectTable="select count(id) from titre where type ='Action' ";
			ResultSet rs = stmt.executeQuery(selectTable);
			while(rs.next()) {count=rs.getInt(1);}		
		}catch(Exception e) {}
		return count;
	}
	public float prixMoy(Connection c) {
		float p=0;
		try {
			Statement stmt = c.createStatement();
			String selectTable="select avg(prix) from titre ";
			ResultSet rs = stmt.executeQuery(selectTable);
			while(rs.next()) {p=rs.getInt(1);}		
		}catch(Exception e) {}
		
		return p;
		
	}
	
	public float dureeMoy(Connection c) {
		float p=0;
		try {
			Statement stmt = c.createStatement();
			String selectTable="select avg(life) from titre ";
			ResultSet rs = stmt.executeQuery(selectTable);
			while(rs.next()) {p=rs.getInt(1);}		
		}catch(Exception e) {}
		
		return p;
		
	}
	public float pMax(Connection c) {
		float p=0;
		try {
			Statement stmt = c.createStatement();
			String selectTable="select max(prix) from titre ";
			ResultSet rs = stmt.executeQuery(selectTable);
			while(rs.next()) {p=rs.getInt(1);}		
		}catch(Exception e) {}
		
		return p;
		
		
		
	}
	public float pMin(Connection c) {
		float p=0;
		try {
			Statement stmt = c.createStatement();
			String selectTable="select min(prix) from titre ";
			ResultSet rs = stmt.executeQuery(selectTable);
			while(rs.next()) {p=rs.getInt(1);}		
		}catch(Exception e) {}
		
		return p;}
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public String getEntreprise() {
		return entreprise;
	}
	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}
	public float getRendement() {
		return rendement;
	}
	public void setRendement(float rendement) {
		this.rendement = rendement;
	}
	public float getVolatilite() {
		return volatilite;
	}
	public void setVolatilite(float volatilite) {
		this.volatilite = volatilite;
	}

}
