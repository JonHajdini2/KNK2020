package contractM;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HomeContent extends GridPane
{

    Button btn = I18N.buttonForKey("addbutton");
    Button btn1 = I18N.buttonForKey("updatebutton");
    HBox hbox2 = new HBox();

    public HomeContent(Stage primaryStage, MainScene mainScene)
    {
        super();
        this.setup(primaryStage, mainScene);
    }

    private void setup(Stage primaryStage, MainScene mainScene)
    {

        Pane homePane = new Pane();

        Text homeImageText = new Text(50, 100, "Contract Mangment");
        Text homeImageDescription = new Text(50, 175, "Character on the trip\nDesign and Technology.");
        Button homeImageButton = new Button("Info");

        this.setStyle("-fx-padding: 20px; -fx-vgap: 20px;");

        homeImageText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 50));
        homeImageText.setStyle("-fx-fill: linear-gradient(to bottom right, #003f3f, #00ffff);");
        homeImageDescription.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
        homeImageDescription.setStyle("-fx-fill: linear-gradient(to bottom right, #003f3f, #00ffff);");
        homeImageButton.setStyle("-fx-background-color: linear-gradient(to bottom right, #003f3f, #00ffff); " +
         "-fx-border-width: 1px; -fx-border-style: solid; -fx-border-color: black; -fx-cursor: hand;");
        homeImageButton.setOnMouseEntered(e ->
        {
            homeImageButton.setStyle("-fx-background-color: #000000; -fx-border-width: 1px; -fx-border-style: solid; " +
             "-fx-border-color: black; -fx-cursor: hand; -fx-text-fill: aqua;");
        });
        homeImageButton.setOnMouseExited(e ->
        {
            homeImageButton.setStyle("-fx-background-color: linear-gradient(to bottom right, #003f3f, #00ffff); " +
             "-fx-border-width: 1px; -fx-border-style: solid; -fx-border-color: black; -fx-cursor: hand; " +
             "-fx-text-fill: black;");
        });
        homeImageButton.relocate(50, 250);


        hbox2.setPadding(new Insets(50, 50, 50, 50));

        VBox vbox1 = new VBox();
        vbox1.setAlignment(Pos.CENTER);
        vbox1.setSpacing(10);
        VBox vbox2 = new VBox();
        vbox2.setSpacing(10);
        vbox2.setAlignment(Pos.CENTER);
        Image searchImage = new Image("file:Images/search.png");
        ImageView SImageView = new ImageView(searchImage);
        SImageView.setFitHeight(200);
        SImageView.setFitWidth(200);


        Image AddImage = new Image("file:Images/employee.png");
        ImageView AImageView = new ImageView(AddImage);
        AImageView.setFitHeight(200);
        AImageView.setFitWidth(200);


        btn.setStyle("-fx-background-radius: 30, 30, 29, 28;\r\n" +
         "    -fx-padding: 3px 10px 3px 10px;\r\n" +
         "    -fx-background-color: #53788D");
        btn.setTextFill(Color.rgb(186, 201, 209));


        btn1.setStyle("-fx-background-radius: 30, 30, 29, 28;\r\n" +
         "    -fx-padding: 3px 10px 3px 10px;\r\n" +
         "    -fx-background-color: #53788D");
        btn1.setTextFill(Color.rgb(186, 201, 209));


        vbox1.getChildren().addAll(SImageView, btn1);
        vbox2.getChildren().addAll(AImageView, btn);

        hbox2.getChildren().addAll(vbox1, vbox2);
        hbox2.setSpacing(10);
        hbox2.setAlignment(Pos.CENTER);
        hbox2.relocate(600,50);


        homePane.getChildren().addAll(homeImageText, homeImageDescription, homeImageButton, hbox2);
        this.add(homePane, 0, 1, 4, 1);
    }

}
