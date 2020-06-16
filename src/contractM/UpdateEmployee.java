package contractM;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class UpdateEmployee extends BorderPane
{
    
    Statement statement;
    
    public UpdateEmployee()
    {
        super();
        //  this.statement = DBConnection.createStatement();
        this.setup();
    }
    
    private void setup()
    {
        
        
        Text carsHeader = new Text("He"); ScrollPane sp = new ScrollPane(); VBox carsContent = new VBox();
        carsContent.getChildren().add(carsHeader); ResultSet resultSet;
        try
        {
            //            resultSet = this.statement.executeQuery("select * from cars;");
            //while(resultSet.next())
            // carsContent.getChildren().add(new CarSection(resultSet.getInt("carID")));
        }
        catch (Exception e)
        {
            resultSet = null; e.printStackTrace();
        }
        
        carsContent.setStyle("-fx-spacing: 20px;"); carsHeader.setFont(Font.font("Tahoma", FontWeight.NORMAL, 50));
        sp.setContent(carsContent); sp.setVbarPolicy(ScrollBarPolicy.ALWAYS); sp.setHbarPolicy(ScrollBarPolicy.NEVER);
        sp.setStyle("-fx-background-color: #00000000; -fx-background: #00000000; -fx-border-width: 1px; " + "-fx" +
         "-border-color: #0000005f; -fx-border-style: solid;");
        BorderPane.setMargin(sp, new Insets(20, 0, 0, 0));
        
        this.setTop(carsHeader); this.setCenter(sp);
        this.setStyle("-fx-background-color: #00000000; -fx-padding: 20px;");
    }
    
}

