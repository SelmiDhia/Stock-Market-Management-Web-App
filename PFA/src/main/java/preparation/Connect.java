package preparation;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
	private static Connection cn;
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
            cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","PFA","123");
			
		}
		catch(Exception e) {e.printStackTrace();}
		
	}
public static Connection getCon() {return cn;}
	

}
