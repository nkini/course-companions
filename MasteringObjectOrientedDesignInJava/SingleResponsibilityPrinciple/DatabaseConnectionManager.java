import java.sql.*;

public class DatabaseConnectionManager {

    Connection conn;

    public static DatabaseConnectionManager getManagerInstance() throws Exception{
        DatabaseConnectionManager dbConnMgr = new DatabaseConnectionManager();
        dbConnMgr.connect();
        return dbConnMgr;
    }
    
    public void connect() throws Exception {
        Class.forName("org.h2.Driver");
        conn = DriverManager.getConnection("jdbc:h2:./hospital-employee", "sa", "");
    }
    
    public Connection getConnectionObject() {
        return conn;
    }
    
    public void disconnect() throws SQLException {
        conn.close();
    }
}
