package contractM;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class HomeContent extends GridPane
{

    Button btn = I18N.buttonForKey("addbutton");
    Button btn1 = I18N.buttonForKey("updatebutton");
    public static Button searchButton = new Button();
    public static Button updateButton = new Button();
    HBox hbox2 = new HBox();

    public HomeContent(Stage primaryStage, MainScene mainScene)
    {
        super();
        this.setup(primaryStage, mainScene);
    }

    private void setup(Stage primaryStage, MainScene mainScene)
    {

        Pane homePane = new Pane();

        Image usernameIcon = new Image("file:Images/welcome.png");
        ImageView usernameIconIV = new ImageView(usernameIcon);
        usernameIconIV.setFitWidth(500);
        usernameIconIV.setFitHeight(200);
        usernameIconIV.relocate(50,30);



        Text homeImageDescription = I18N.getText("Welcometext");
     
        Button homeImageButton = new Button("Info");

        this.setStyle("-fx-padding: 20px; -fx-vgap: 20px;");

      
        homeImageDescription.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
        homeImageDescription.setStyle("-fx-fill: linear-gradient(to bottom right, #003f3f, #048080);");
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
        homeImageButton.setOnAction(e->	Help.about());
        homeImageButton.relocate(75, 450);
        homeImageDescription.relocate(75,300);


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
    
        updateButton.setGraphic(SImageView);
        updateButton.setPadding(Insets.EMPTY);
        updateButton.setStyle("-fx-background-color: transparent");
        updateButton.setOnMouseEntered(e ->
        {
            updateButton.setStyle("-fx-cursor: hand; -fx-background-color: transparent");
        });
        updateButton.setOnMouseExited(e ->
        {
            updateButton.setStyle("-fx-cursor: hand; -fx-background-color: transparent");
        });
        

        Image AddImage = new Image("file:Images/employee.png");
        ImageView AImageView = new ImageView(AddImage);
        AImageView.setFitHeight(200);
        AImageView.setFitWidth(200);

        searchButton.setGraphic(AImageView);
        searchButton.setPadding(Insets.EMPTY);
        searchButton.setStyle("-fx-background-color: transparent");
        searchButton.setOnMouseEntered(e ->
        {
            searchButton.setStyle("-fx-cursor: hand; -fx-background-color: transparent");
        });
        searchButton.setOnMouseExited(e ->
        {
            searchButton.setStyle("-fx-cursor: hand; -fx-background-color: transparent");
        });




        btn.setStyle("-fx-background-radius: 30, 30, 29, 28;\r\n" +
         "    -fx-padding: 3px 10px 3px 10px;\r\n" +
         "    -fx-background-color: #53788D");
        btn.setTextFill(Color.rgb(186, 201, 209));


        btn1.setStyle("-fx-background-radius: 30, 30, 29, 28;\r\n" +
         "    -fx-padding: 3px 10px 3px 10px;\r\n" +
         "    -fx-background-color: #53788D");
        btn1.setTextFill(Color.rgb(186, 201, 209));


        vbox1.getChildren().addAll(updateButton, btn1);
        vbox2.getChildren().addAll(searchButton, btn);

        hbox2.getChildren().addAll(vbox1, vbox2);
        hbox2.setSpacing(40);
        hbox2.setAlignment(Pos.CENTER);
        hbox2.relocate(600,50);


        homePane.getChildren().addAll(usernameIconIV, homeImageDescription, homeImageButton, hbox2);

        this.add(homePane, 0, 1, 4, 1);
    }

}
