package sql;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectManager {
	public static Connection getConnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/DocSim","root","913053L1");
			return con;
		}catch (Exception e){
			throw new IllegalStateException(e);
		}
	}
	public static void main(String[] args) throws Exception {
		Connection con = getConnection();
		con.close();

	}

}
