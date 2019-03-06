package osf.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "osfu";
	private static final String PASSWORD = "12345678";
	private static Connection con = null;
	static {
		openCon();
	}

	private static void openCon() {
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getCon() {
		if (con == null) {
			openCon();
		}
		return con;
	}
	public static void close() {
		if(con!=null) {
			try {
				if(!con.isClosed()) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		con=null;
	}
}
