package contractM;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;


public class Login extends Application
{
    private TextField emailTxt = new TextField();
    private PasswordField passwordTxt = new PasswordField();
    private TextField userTxt = new TextField();
    private Label errorLabel = new Label();
    /*****/

    private Stage mainStage;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {

        mainStage = primaryStage;

        emailTxt.setPromptText("Email");
        passwordTxt.setPromptText("Password");
        userTxt.setPromptText(I18N.get("user"));

        BorderPane bp = new BorderPane();
        // bp.setPadding(new Insets(20, 100, 100, 100));

        HBox languageHBox = new HBox();
        ComboBox<String> languageCB = new ComboBox<String>(FXCollections.observableArrayList("AL", "EN"));


        GridPane TopGrid = new GridPane();
        TopGrid.setPadding(new Insets(20,5,5,100));

        HBox hb = new HBox();
        hb.setPadding(new Insets(100, 20, 2, 30)); /****/


        GridPane mainGrid = new GridPane();
        mainGrid.setPadding(new Insets(5, 100, 100, 100));

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
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

        HBox hb2 = new HBox();
        hb2.setPadding(new Insets(5, 20, 0, 5)); ////
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


        hb2.getChildren().addAll(btnLogin, btnRegister);
        hb2.setSpacing(5);


        btnLogin.setOnAction(e -> loginUser());

        mainGrid.getChildren().add(gridPane);

        gridPane.add(usernameIconIV, 0, 0);
        gridPane.add(userTxt, 1, 0);
        gridPane.add(usernameIconIV2, 0, 1);
        gridPane.add(passwordTxt, 1, 1);
        gridPane.add(hb2, 1, 2);


        gridPane.setStyle("-fx-background-color: #53788D  ;\r\n" +
         " -fx-padding: 20 10 10 10;\r\n" +
         " -fx-background-radius: 20;");


        Text text = new Text("Login");
        text.setTextAlignment(TextAlignment.CENTER);

        text.setStyle("-fx-font-family: Pacifico;-fx-font-size:30");
        text.setFill(Color.rgb(196, 206, 212));


        TopGrid.add(hb, 5, 5);
        TopGrid.add(languageHBox, 10, 0);

        hb.getChildren().add(text);

        hb.setAlignment(Pos.CENTER);

        HBox hBoxError = new HBox(); /*****/

        errorLabel.setTextFill(Color.RED);
        bp.setStyle("-fx-background-color:#2B4857;");
        bp.setTop(TopGrid);
        bp.setCenter(mainGrid);
        bp.setBottom(hBoxError); /*****/

        hBoxError.getChildren().add(errorLabel); /*****/
        hBoxError.setStyle("-fx-background-color: #0000005f; -fx-padding: 20px; -fx-alignment: center-right;"); /*****/

        languageHBox.getChildren().addAll(I18N.getLabel("languageLabel"), languageCB);
        languageHBox.setStyle("-fx-padding: 20px; -fx-spacing: 4px;");
        languageHBox.setAlignment(Pos.BASELINE_RIGHT);
        languageCB.setValue("EN");
        languageCB.setOnAction(e ->
        {
            I18N.setLocale(new Locale(languageCB.getValue().toLowerCase()));

        });
        languageCB.setStyle("-fx-border-width: 1px; -fx-border-style: solid; -fx-border-color: #000000; " +
         "-fx-background-color: #00000000;");


        Scene scene = new Scene(bp);

        //scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Pacifico&display=swap");


        /////////////////////////SIGN UP/////////////////


        SignUp signup = new SignUp();

        Scene scene2 = new Scene(signup);


        signup.btnLogIn.setOnAction(e ->
        {
            primaryStage.setScene(scene);
            primaryStage.setTitle("Login");
            primaryStage.setResizable(false);
        });

        scene2.getStylesheets().add("https://fonts.googleapis.com/css?family=Pacifico&display=swap");
        btnRegister.setOnMouseClicked(e ->
        {
            primaryStage.setScene(scene2);
            primaryStage.setTitle("Sign up");
            primaryStage.setResizable(false);
            signup.emailTxt.setText("");
            signup.passwordTxt.setText("");
            signup.userTxt.setText("");
        });


        //////////////////////////////////////////////////////////////////////


        primaryStage.setScene(scene);
        primaryStage.setTitle("Login");
        primaryStage.setResizable(false);


        primaryStage.show();
        gridPane.requestFocus();

    }


    ///////////DataBase///////////////////////////////////////////////


    private void loginUser()
    {

        if (userTxt.getText().isEmpty() || passwordTxt.getText().isEmpty())
        {
            errorLabel.setText("Please fill up");
        }
        else
        {
            String query = "Select * from managers where username = ? AND upassword = ?";
            String Equery = "Select * from managers where uemail = ? AND upassword = ?";
            try
            {

                PreparedStatement preparedStatement = DBConnection.setConnection().prepareStatement(query);

                preparedStatement.setString(1, userTxt.getText());
                preparedStatement.setString(2, passwordTxt.getText());

                ResultSet result = preparedStatement.executeQuery();

                PreparedStatement preparedEStatement = DBConnection.setConnection().prepareStatement(Equery);

                preparedEStatement.setString(1, userTxt.getText());
                preparedEStatement.setString(2, passwordTxt.getText());

                ResultSet Eresult = preparedEStatement.executeQuery();

                if (result.next() || Eresult.next())
                {
                    mainStage.hide();
                    MainProgram.createMainStage();

                }
                else
                {
                    errorLabel.setText("Email/Username or password is wrong!");
                }

            }
            catch (SQLException ex)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Database problem2");
                alert.setHeaderText(null);
                alert.setContentText(ex.getMessage());
                alert.showAndWait();
                ex.printStackTrace();
                System.exit(0);
            }

        }

    }


}


