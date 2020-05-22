package contractM;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
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


    public Button getBtn3()
    {
        // qetu kesh tu u merr me buton
        Image AddImage = new Image("file:Images/butoni.png");
        ImageView AImageView = new ImageView(AddImage);
        AImageView.setFitHeight(30);
        AImageView.setFitWidth(30);
        btn3.setGraphic(AImageView);
        btn3.setPadding(Insets.EMPTY);

        return btn3;
    }

    public Welcome()
    {
        StackPane pane = new StackPane();

        getBtn3();


        pane.setAlignment(Pos.CENTER);


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
        BorderPane root = new BorderPane();
        BorderPane bottom = new BorderPane();
        bottom.setRight(btn3);
        root.setBottom(bottom);
        this.setBottom(root);

        this.setStyle("-fx-background-color:  #53788D");
        btn3.setStyle("    -fx-padding: 3px 10px 3px 10px;\r\n" +
         "    -fx-background-color: #2C3E48");
        btn3.setTextFill(Color.rgb(186, 201, 209));
    }
}
