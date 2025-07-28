public class DBUtil {
  private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
  private static final String USER = "******";//you write your username 
  private static final String PASS = "*******";//and password here 

  static { try { Class.forName("oracle.jdbc.driver.OracleDriver"); } catch(Exception e) { e.printStackTrace(); } }

  public static Connection getConnection() throws SQLException {
    return DriverManager.getConnection(URL, USER, PASS);
  }
}
