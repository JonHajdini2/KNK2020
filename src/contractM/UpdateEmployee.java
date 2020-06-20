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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class UpdateEmployee extends BorderPane
{
    
    public UpdateEmployee()
    {
        super();
        this.setup();
    }
    
    private void setup()
    {
        
        
        Text Header = new Text("Working on it :("); BorderPane sp = new BorderPane(); VBox Content = new VBox();
        Content.getChildren().add(Header);
        Header.setFill(Color.RED);
    
        
        Content.setStyle("-fx-spacing: 20px;"); Header.setFont(Font.font("Tahoma", FontWeight.NORMAL, 50));
        sp.setStyle("-fx-background-color: #00000000; -fx-background: #00000000; -fx-border-width: 1px; " + "-fx" +
         "-border-color: #0000005f; -fx-border-style: solid;");
        BorderPane.setMargin(sp, new Insets(20, 0, 0, 0));
        
        this.setTop(Header); this.setCenter(sp);
        this.setStyle("-fx-background-color: #00000000; -fx-padding: 20px;");
    }
    
}

