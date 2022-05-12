package insertion;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Courtier extends User {
	Connection c;
	public Courtier() {
		super();
	
		
	}
	public void ajout (Connection c, Titre t) {
		
		PreparedStatement q;
		try {
			q =c.prepareStatement("insert into titre values (?,?,?,?,?,?,?)");
			q.setInt(1,t.getId());
			q.setString(2,t.getType());
			q.setFloat(3,t.getPrix());
			q.setInt(4,t.getDuree());
			q.setString(5,t.getEntreprise());
			q.setFloat(6,t.getRendement());
			q.setFloat(7,t.getVolatilite());
			q.executeUpdate();
			q.close();
			
			
			
			
			
			
		}catch(Exception e) {}
	}
	
}
