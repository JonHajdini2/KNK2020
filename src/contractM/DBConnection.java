package contractM;


import java.sql.Connection;
import java.sql.DriverManager;


import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class DBConnection
{

    private static Connection dbConnection;
    
    private static String hostProvider = "localhost";
    private static String DBname = "MenaxhimiDB";
    private static String user = "root";
    private static String password = "password";
    
    

    public static Connection setConnection()
    {
        try
        {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://" + hostProvider + ":3306/" + DBname + "?useUnicode=true" +
        "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            
            dbConnection = DriverManager.getConnection(url, user, password);
        }
        catch (Exception ex)
        {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Database problem1");
            alert.setHeaderText(null);
            alert.setContentText("Can not connect to database");
            alert.showAndWait();
            ex.printStackTrace();
        }

        return dbConnection;
    }

}

