package contractM;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Welcome extends BorderPane
{
    public Button btn3 = new Button();
    public Button logout = new Button();

    public Button getBtn3()
    {

        Image AddImage = new Image("file:Images/butoni.png");
        ImageView AImageView = new ImageView(AddImage);
        AImageView.setFitHeight(45);
        AImageView.setFitWidth(45);
        btn3.setGraphic(AImageView);
        btn3.setPadding(Insets.EMPTY);

        return btn3;
    }

    public Button getLogout()
    {
        Image openIcon = new Image("file:Images/logout.png");
        ImageView exitview = new ImageView(openIcon);
        exitview.setFitWidth(30);
        exitview.setFitHeight(30);
        logout.setGraphic(exitview);
        logout.setPadding(Insets.EMPTY);

        return logout;
    }



    public Welcome()
    {
        StackPane pane = new StackPane();
        pane.setAlignment(Pos.CENTER);

        getBtn3();

        getLogout();
        this.setTop(logout);
        logout.setStyle("    -fx-background-color: transparent");



        Image usernameIcon = new Image("file:Images/welcome.png");
        ImageView usernameIconIV = new ImageView(usernameIcon);
        usernameIconIV.setFitWidth(500);
        usernameIconIV.setFitHeight(200);

        Text text = new Text();
        text.setText("Welcome to this company's payroll and contract managment program!");

        text.setFill(Color.rgb(186, 201, 209));

        VBox vbox = new VBox();
        vbox.getChildren().addAll(usernameIconIV, text);
        vbox.setSpacing(30);
        vbox.setAlignment(Pos.CENTER);

        pane.getChildren().add(vbox);


        this.setCenter(pane);

        // place button at the bottom right
        var logoutpane = new BorderPane();
        logoutpane.setRight(btn3);
        this.setBottom(logoutpane);


        this.setStyle("-fx-background-color:  #53788D");
        btn3.setStyle("-fx-background-color: transparent");

    }
}
