package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		String url = "jdbc:sqlserver://"+serverName+":"+portNumber+";databaseName="+dbName;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(url, userId, password);
	}
	
	private static final String serverName = "localhost";
	private static final String dbName = "ShoppingDB";
	private static final String portNumber = "1433";
	private static final String userId = "sa";
	private static final String password = "!@#456Qwe";
}
