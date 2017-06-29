import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;

public class EmployeeDAO {

    // Since the UML doesn't have this field for the class, it is removed
    // DatabaseConnectionManager connectionManager;
    // That also changes the constructor here
    public EmployeeDAO() {
        createTable();
    }

    private void createTable(){

        try {
            // Notice that this leads to a lot of repeated code.
            // DRY isn't being followed...
            // To me it seems like the earlier design is better
            DatabaseConnectionManager connectionManager = DatabaseConnectionManager.getManagerInstance();
            connectionManager.connect();
            Connection conn = connectionManager.getConnectionObject();

            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet tables = dbm.getTables(null, null, "employee", null);

            if (!tables.next()) {
                String sqlCreate = "CREATE TABLE IF NOT EXISTS employee"
                                 + "(id LONG,"
                                 + " name VARCHAR(20),"
                                 + " department VARCHAR(20),"
                                 + " working BOOL)";
                Statement stmt = conn.createStatement();
                stmt.execute(sqlCreate);
            }
            // More repeated code
            connectionManager.disconnect();
        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void saveEmployee(Employee emp) {
 
        try {
            DatabaseConnectionManager connectionManager = DatabaseConnectionManager.getManagerInstance();
            connectionManager.connect();
            Connection conn = connectionManager.getConnectionObject();

            String sql = "INSERT INTO employee " +
                         "VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setLong(1, emp.id);
            stmt.setString(2, emp.name);
            stmt.setString(3, emp.department);
            stmt.setBoolean(4, emp.working);

            stmt.executeUpdate();
            connectionManager.disconnect();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public void deleteEmployee(Employee emp) {
        
        try {

            DatabaseConnectionManager connectionManager = DatabaseConnectionManager.getManagerInstance();
            connectionManager.connect();
            Connection conn = connectionManager.getConnectionObject();

            String sql = "DELETE FROM employee " +
                     "WHERE id = ? AND name = ? AND department = ? AND working = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setLong(1, emp.id);
            stmt.setString(2, emp.name);
            stmt.setString(3, emp.department);
            stmt.setBoolean(4, emp.working);

            stmt.executeUpdate();
            connectionManager.disconnect();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        
    }
}
