package contractM;


import javafx.application.Application;

import javafx.geometry.Insets;
import javafx.scene.control.Button;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;


import javafx.stage.Stage;


public class Main extends Application {


    private TextField emailTxt = new TextField();
    private PasswordField passwordTxt = new PasswordField();
    private TextField userTxt = new TextField();


    private Stage mainStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        mainStage = primaryStage;

        emailTxt.setPromptText("Email");
        passwordTxt.setPromptText("Password");
        userTxt.setPromptText("Username");

        BorderPane bp = new BorderPane();
        bp.setPadding(new Insets(10,50,50,50));


        HBox hb = new HBox();
        hb.setPadding(new Insets(20,20,2,30));


        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20,20,20,20));
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        Image usernameIcon = new Image("file:Images/icon.png");
        ImageView usernameIconIV = new ImageView(usernameIcon);
        usernameIconIV.setFitWidth(20);
        usernameIconIV.setFitHeight(20);

        Image usernameIcon2 = new Image("file:Images/icon3.png");
        ImageView usernameIconIV2 = new ImageView(usernameIcon2);
        usernameIconIV2.setFitWidth(20);
        usernameIconIV2.setFitHeight(20);

        Image usernameIcon3 = new Image("file:Images/email.png");
        ImageView usernameIconIV3 = new ImageView(usernameIcon3);
        usernameIconIV3.setFitWidth(20);
        usernameIconIV3.setFitHeight(20);

        HBox hb2=new HBox();
        hb2.setPadding(new Insets(5,20,0,5));
        Button btnLogin = new Button("Login");
        btnLogin.setTextFill(Color.rgb(186, 201, 209));
        btnLogin.setStyle("-fx-background-radius: 30, 30, 29, 28;\r\n" +
                "    -fx-padding: 3px 10px 3px 10px;\r\n" +
                "    -fx-background-color: #2C3E48");
        Button btnRegister = new Button("Register");
        btnRegister.setTextFill(Color.rgb(186, 201, 209));
        btnRegister.setStyle("-fx-background-radius: 30, 30, 29, 28;\r\n" +
                "    -fx-padding: 3px 10px 3px 10px;\r\n" +
                "    -fx-background-color: #2C3E48");


        hb2.getChildren().addAll(btnLogin,btnRegister);
        hb2.setSpacing(5);





    }

}


