import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDAO {

    DatabaseConnectionManager connectionManager;

    public EmployeeDAO(DatabaseConnectionManager connectionManager) {
        this.connectionManager = connectionManager; 
        createTable();
    }

    private void createTable(){

        try {
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
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void saveEmployee(Employee emp) {
        Connection conn = connectionManager.getConnectionObject();
        String sql = "INSERT INTO employee " +
                     "VALUES (?, ?, ?, ?)";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setLong(1, emp.id);
            stmt.setString(2, emp.name);
            stmt.setString(3, emp.department);
            stmt.setBoolean(4, emp.working);

            stmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteEmployee(Employee emp) {
    
        Connection conn = connectionManager.getConnectionObject();
        String sql = "DELETE FROM employee " +
                     "WHERE id = ? AND name = ? AND department = ? AND working = ?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setLong(1, emp.id);
            stmt.setString(2, emp.name);
            stmt.setString(3, emp.department);
            stmt.setBoolean(4, emp.working);

            stmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
}
