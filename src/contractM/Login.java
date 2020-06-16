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
    
    MainProgram LoginSuccessStage = new MainProgram();

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
        userTxt.setPromptText("Email/Username");


        BorderPane bp = new BorderPane();
        // bp.setPadding(new Insets(20, 100, 100, 100));

        HBox languageHBox = new HBox();
        ComboBox<String> languageCB = new ComboBox<String>(FXCollections.observableArrayList("AL", "EN"));

        HBox hbLogin = new HBox();
        //hbLogin.setPadding(new Insets(100, 20, 2, 30));

        GridPane mainGrid = new GridPane();
        mainGrid.setPadding(new Insets(5, 200, 200, 200));

        GridPane gridPane = new GridPane();
        //gridPane.setPadding(new Insets(40, 40, 40, 40));
        gridPane.setHgap(10);
        gridPane.setVgap(10);


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
        Button btnLogin = I18N.buttonForKey("Login");
        btnLogin.setTextFill(Color.rgb(186, 201, 209));
        btnLogin.setStyle("-fx-background-radius: 30, 30, 29, 28;\r\n" +
         "    -fx-padding: 3px 15px 3px 15px;\r\n" +
         "    -fx-background-color: #2C3E48");
        Button btnRegister = I18N.buttonForKey("Register");
        btnRegister.setTextFill(Color.rgb(186, 201, 209));
        btnRegister.setStyle("-fx-background-radius: 30, 30, 29, 28;\r\n" +
         "    -fx-padding: 3px 15px 3px 15px;\r\n" +
         "    -fx-background-color: #2C3E48");


        hb2.getChildren().addAll(btnLogin, btnRegister);
        hb2.setSpacing(5);


        btnLogin.setOnAction(e -> loginUser());

        mainGrid.add(hbLogin, 0, 0);
        mainGrid.add(gridPane, 0, 1);

        gridPane.add(usernameIconIV, 0, 1);
        gridPane.add(userTxt, 1, 1);
        gridPane.add(usernameIconIV2, 0, 2);
        gridPane.add(passwordTxt, 1, 2);
        gridPane.add(hb2, 1, 3);


        gridPane.setStyle("-fx-background-color: #ffffff  ;\r\n" +
         " -fx-padding: 20 10 10 10;\r\n" +
         " -fx-background-radius: 20;");


        Text text = new Text("Login");
        text.setTextAlignment(TextAlignment.CENTER);

        text.setStyle("-fx-font-family: Pacifico;-fx-font-size:30");
        text.setFill(Color.rgb(196, 206, 212));


        hbLogin.getChildren().add(text);

        hbLogin.setAlignment(Pos.CENTER);

        HBox hBoxError = new HBox(); /*****/

        errorLabel.setTextFill(Color.RED);


        hBoxError.getChildren().add(errorLabel); /*****/
        hBoxError.setStyle("-fx-background-color: rgba(239,235,235,0.37); -fx-padding: 20px; -fx-alignment: center-right;"); /*****/


        languageHBox.getChildren().addAll(I18N.getLabel("languageLabel"), languageCB);
        languageHBox.setStyle("-fx-padding: 20px 20px 50px 20px; -fx-spacing: 4px;");
        languageHBox.setAlignment(Pos.BASELINE_RIGHT);
        languageCB.setValue("EN");
        languageCB.setOnAction(e ->
        {
            I18N.setLocale(new Locale(languageCB.getValue().toLowerCase()));
            errorLabel.setText("");
            errorLabel.setTextFill(Color.RED);
            userTxt.setPromptText(I18N.getLabel("user").getText());
            emailTxt.setPromptText(I18N.getLabel("Email").getText());
            passwordTxt.setPromptText(I18N.getLabel("Password").getText());

        });


        languageCB.setStyle("-fx-border-width: 1px; -fx-border-style: solid; -fx-border-color: #000000; " +
         "-fx-background-color: #00000000;");


        //bp.setStyle("-fx-background-color:#2B4857;");
        bp.setStyle("-fx-background-color: linear-gradient(to bottom right, #03DAC6, #018786);");
        //bp.setTop(hbLogin);
        bp.setCenter(mainGrid);
        bp.setBottom(hBoxError); /*****/



        /*--Add Language -- */
        var lang = new BorderPane();
        lang.setTop(languageHBox);
        bp.setTop(lang);
        //bp.setLeft(languageHBox);

        Scene scene = new Scene(bp);

        scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Pacifico&display=swap");


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
            errorLabel.setText(I18N.getLabel("Fill").getText());
            errorLabel.setTextFill(Color.RED);
        }
        else
        {
            String query =
             "Select * from managers where username = ? AND upassword = ?";
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
                    LoginSuccessStage.createMainStage();

                }
                else
                {
                    errorLabel.setText(I18N.getLabel("email").getText());
                    errorLabel.setTextFill(Color.RED);
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


