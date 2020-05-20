package contractM;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class SignUp extends BorderPane
{
    public TextField emailTxt = new TextField();
    public PasswordField passwordTxt = new PasswordField();
    public TextField userTxt = new TextField();
    Button btnSignUp = new Button("Sign Up");
    Button btnLogIn = new Button(" Login ");
    GridPane gridPaneSU = new GridPane();

    public SignUp() {
        emailTxt.setPromptText("Email");
        passwordTxt.setPromptText("Password");
        userTxt.setPromptText("Username");


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

        Text textSignUp = new Text("Sign Up");
        textSignUp.setTextAlignment(TextAlignment.CENTER);

        textSignUp.setStyle("-fx-font-family: Pacifico;-fx-font-size:30");
        textSignUp.setFill(Color.rgb(196, 206, 212));


        btnSignUp.setTextFill(Color.rgb(186, 201, 209));
        btnSignUp.setStyle("-fx-background-radius: 30, 30, 29, 28;\r\n" +
                "    -fx-padding: 3px 10px 3px 10px;\r\n" +
                "    -fx-background-color: #2C3E48");


        btnLogIn.setTextFill(Color.rgb(186, 201, 209));
        btnLogIn.setStyle("-fx-background-radius: 30, 30, 29, 28;\r\n" +
                "    -fx-padding: 3px 10px 3px 10px;\r\n" +
                "    -fx-background-color: #2C3E48");

        HBox hbSignUp = new HBox();

        hbSignUp.getChildren().add(textSignUp);
        hbSignUp.setPadding(new Insets(20,20,2,30));
        hbSignUp.setAlignment(Pos.CENTER);


        this.setPadding(new Insets(10,50,50,50));


        gridPaneSU.setPadding(new Insets(20,20,20,20));
        gridPaneSU.setHgap(5);
        gridPaneSU.setVgap(5);

        HBox hbSignUp2= new HBox();
        hbSignUp2.setPadding(new Insets(5,30,10,5));
        hbSignUp2.getChildren().addAll(btnSignUp,btnLogIn);
        hbSignUp2.setSpacing(5);


        gridPaneSU.add(usernameIconIV, 0, 0);
        gridPaneSU.add(userTxt, 1, 0);
        gridPaneSU.add(usernameIconIV3, 0, 1);
        gridPaneSU.add(emailTxt, 1, 1);
        gridPaneSU.add(usernameIconIV2,0, 2);
        gridPaneSU.add(passwordTxt, 1, 2);
        gridPaneSU.add(hbSignUp2, 1, 3);

        gridPaneSU.setStyle("-fx-background-color: #53788D  ;\r\n" +
                " -fx-padding: 20 10 10 10;\r\n" +
                " -fx-background-radius: 20;");

        this.setStyle("-fx-background-color:#2B4857;");
        this.setTop(hbSignUp);
        this.setCenter(gridPaneSU);

    }
}
