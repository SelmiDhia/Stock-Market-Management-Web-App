package insertion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {
	private String nom;
	private String prenom;
	private String email;
	private String metier;
	private String user;
	private String pass;
	private String tel;
	private String birth;
	private String adr;
	private String crt;
	private String cvv;
public User() {}
public User(String nom,String prenom,String email,String metier,String user,String pass,String tel,String birth,String adr,String crt,String cvv) {
	setNom(nom);
	setPrenom(prenom);
	setEmail(email);
	setMetier(metier);
	setUser(user);
	setPass(pass);
	setTel(tel);
	setBirth(birth);
	setAdr(adr);
	setCrt(crt);
	setCvv(cvv);	
}
public void insertion(Connection c) {
	
	PreparedStatement q;
	try {
		q =c.prepareStatement("insert into users values (?,?,?,?,?,?,?,?,?,?,?)");
		q.setString(1,nom);
		q.setString(2,prenom);
		q.setString(3,email);
		q.setString(4,metier);
		q.setString(5,user);
		q.setString(6,pass);
		q.setString(7,tel);
		q.setString(8, birth);
		q.setString(9,adr);
		q.setString(10,crt);
		q.setString(11,cvv);
		q.executeUpdate();
		q.close();
	}catch(Exception e) {}
}
public String connexion (Connection c) {
	String s = null;
	int count = 0;
	try {
		Statement stmt = c.createStatement();
		String selectTable="select username ,pass,job from users";
		ResultSet rs = stmt.executeQuery(selectTable);
		String name = null;
		String psd=null;
		String job=null;
		while(rs.next()) {
			name =rs.getString(1); 
			psd = rs.getString(2);
			job = rs.getString(3);
			if(user.equals(name)&&pass.equals(psd)){count+=1; break;}
		}
		if("Courtier".equals(job)&&count==1) s="courtier.jsp";
		else if ("Trader".equals(job)&&count==1) s="trader.jsp";
		else if ("Analyste".equals(job)&&count==1) s="analyste.jsp";
}catch(Exception e){}
	return s;
}
public int userNumber(Connection c) {
	int cpt=0;
	try {
		Statement stmt = c.createStatement();
		String selectTable="select count(username) from users";
		ResultSet rs = stmt.executeQuery(selectTable);
		while(rs.next()) {cpt=rs.getInt(1);}
		
		
		
	}catch(Exception e) {}
	return cpt;
	
	
	
}
public int courtierNumber(Connection c){
	int cpt=0;
	try {
		Statement stmt = c.createStatement();
		String selectTable="select count(username) from users where job ='Courtier'";
		ResultSet rs = stmt.executeQuery(selectTable);
		while(rs.next()) {cpt=rs.getInt(1);}		
	}catch(Exception e) {}
	return cpt;
}
public int traderNumber(Connection c) {
	int cpt=0;
	try {
		Statement stmt = c.createStatement();
		String selectTable="select count(username) from users where job = 'Trader' ";
		ResultSet rs = stmt.executeQuery(selectTable);
		while(rs.next()) {cpt=rs.getInt(1);}		
	}catch(Exception e) {}
	return cpt;
}
public int analystNumber(Connection c){
	int cpt=0;
	try {
		Statement stmt = c.createStatement();
		String selectTable="select count(username) from users where job ='analyste' ";
		ResultSet rs = stmt.executeQuery(selectTable);
		while(rs.next()) {cpt=rs.getInt(1);}		
	}catch(Exception e) {}
	return cpt;
}







public String getPrenom() {
	return prenom;
}








public void setPrenom(String prenom) {
	this.prenom = prenom;
}








public String getEmail() {
	return email;
}








public void setEmail(String email) {
	this.email = email;
}








public String getMetier() {
	return metier;
}








public void setMetier(String metier) {
	this.metier = metier;
}








public String getUser() {
	return user;
}








public void setUser(String user) {
	this.user = user;
}








public String getPass() {
	return pass;
}








public void setPass(String pass) {
	this.pass = pass;
}








public String getTel() {
	return tel;
}








public void setTel(String tel) {
	this.tel = tel;
}








public String getBirth() {
	return birth;
}








public void setBirth(String birth) {
	this.birth = birth;
}








public String getAdr() {
	return adr;
}








public void setAdr(String adr) {
	this.adr = adr;
}








public String getCrt() {
	return crt;
}








public void setCrt(String crt) {
	this.crt = crt;
}








public String getCvv() {
	return cvv;
}








public void setCvv(String cvv) {
	this.cvv = cvv;
}








public String getNom() {
	return nom;
}








public void setNom(String nom) {
	this.nom = nom;
}


}

