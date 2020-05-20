package contractM;


import java.sql.Connection;
import java.sql.DriverManager;


import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class DBConnection
{

    private static Connection dbConnection;

    public static Connection setConnection()
    {
        try
        {

            Class.forName("com.mysql.cj.jdbc.Driver");
            dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/MenaxhimiDB?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root",""/*"password"*/);


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

