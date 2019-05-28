package DAO;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC_Connection {

    public static Connection connection;
    public static final String USER = "krzys";
    public static final String PASSWORD = "krzys";
    public static final String URL = "jdbc:postgresql://localhost:5432/Projektowa";

    public static void getConnection() throws ClassNotFoundException, SQLException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void dbDisconnect() throws SQLException {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static ResultSet dbExecuteQuery(String queryStmt) throws SQLException, ClassNotFoundException {
        //Declare statement, resultSet and CachedResultSet as null
        Statement stmt = null;
        ResultSet resultSet = null;
        CachedRowSetImpl crs = null;
        try {
            getConnection();
            System.out.println("Select statement: " + queryStmt + "\n");

            stmt = connection.createStatement();

            resultSet = stmt.executeQuery(queryStmt);
            crs = new CachedRowSetImpl();
            crs.populate(resultSet);
        } catch (SQLException e) {
            throw e;
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            dbDisconnect();
        }
        return crs;
    }

    public static void dbExecuteUpdate(String sqlStmt) throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        try {
            getConnection();
            stmt = connection.createStatement();
            stmt.executeUpdate(sqlStmt);
        } catch (SQLException e) {
            throw e;
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            dbDisconnect();
        }
    }
    
    public Connection getLaczenie() {
		return connection;
	}
    
    
    public static Connection getConnections() {
		Connection con = null;
		try {
			// load the Driver Class
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// create the connection now
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.100.159:1521:dbgym","krzys","krzys");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
