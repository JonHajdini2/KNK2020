package contractM;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUp extends BorderPane
{
    public TextField emailTxt = new TextField();
    public PasswordField passwordTxt = new PasswordField();
    public TextField userTxt = new TextField();
    Button btnSignUp = new Button("Sign Up");
    Button btnLogIn = new Button(" Login ");
    Label errorLabel = new Label(); /*****/

    public SignUp()
    {
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
        hbSignUp.setPadding(new Insets(20, 20, 2, 30));
        hbSignUp.setAlignment(Pos.CENTER);


        //this.setPadding(new Insets(20, 100, 100, 100));

        GridPane mainGrid = new GridPane();
        mainGrid.setPadding(new Insets(5,100,100,100));

        GridPane gridPaneSU = new GridPane();
        gridPaneSU.setPadding(new Insets(20, 20, 20, 20));
        gridPaneSU.setHgap(5);
        gridPaneSU.setVgap(5);

        HBox hbSignUp2 = new HBox();
        hbSignUp2.setPadding(new Insets(5, 30, 10, 5));
        hbSignUp2.getChildren().addAll(btnSignUp, btnLogIn);
        hbSignUp2.setSpacing(5);

        mainGrid.getChildren().add(gridPaneSU);
        gridPaneSU.add(usernameIconIV, 0, 0);
        gridPaneSU.add(userTxt, 1, 0);
        gridPaneSU.add(usernameIconIV3, 0, 1);
        gridPaneSU.add(emailTxt, 1, 1);
        gridPaneSU.add(usernameIconIV2, 0, 2);
        gridPaneSU.add(passwordTxt, 1, 2);
        gridPaneSU.add(hbSignUp2, 1, 3);

        gridPaneSU.setStyle("-fx-background-color: #53788D  ;\r\n" +
         " -fx-padding: 20 10 10 10;\r\n" +
         " -fx-background-radius: 20;");

        /* Treat Errors */
        HBox hBoxError = new HBox();
        errorLabel.setTextFill(Color.RED);
        hBoxError.getChildren().add(errorLabel);
        hBoxError.setStyle("-fx-background-color: #0000005f; -fx-padding: 20px; -fx-alignment: center-right;");


        this.setStyle("-fx-background-color:#2B4857;");
        this.setTop(hbSignUp);
        this.setCenter(mainGrid);
        this.setBottom(hBoxError);
        btnSignUp.setOnAction(e -> SignUpUser());

    }

    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
     Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);


    private static final Pattern USER_NAME = Pattern.compile("^([A-Z])+([\\w]{3,})+$", Pattern.CASE_INSENSITIVE);

    private static final Pattern USER_PASSWORD = Pattern.compile("^(?=.*[0-9]).{6,15}$");

    private static boolean validateE(String emailStr)
    {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    private static boolean validateUN(String usernameStr)
    {
        Matcher matcher = USER_NAME.matcher(usernameStr);
        return matcher.find();
    }

    private static boolean validatePSW(String passStr)
    {
        Matcher matcher = USER_PASSWORD.matcher(passStr);
        return matcher.find();
    }

    private void SignUpUser()
    {
        if (emailTxt.getText().isEmpty() || userTxt.getText().isEmpty() || passwordTxt.getText().isEmpty())
        {
            errorLabel.setText("Please fill up");
        }
        else if (!validateUN(userTxt.getText()))
        {
            errorLabel.setText("Username is not valid!");

        }
        else if (!validateE(emailTxt.getText()))
        {
            errorLabel.setText("Email address is not valid!");
        }
        else if (!validatePSW(passwordTxt.getText()))
        {
            errorLabel.setText("Password is not valid!");
        }
        else
        {


            String query1 =
             "Insert into managers values ('" + userTxt.getText() + "','" + emailTxt.getText() + "','" + passwordTxt.getText() + "')";
            try
            {

                PreparedStatement st = DBConnection.setConnection().prepareStatement("select * from managers where " +
                 "username = ?");
                PreparedStatement ps = DBConnection.setConnection().prepareStatement("select * from managers where " +
                 "uemail = ?");
                st.setString(1, userTxt.getText());
                ps.setString(1, emailTxt.getText());
                ResultSet r1 = st.executeQuery();
                ResultSet r2 = ps.executeQuery();
                if (r1.next())
                {
                    errorLabel.setText("Username Already exists");
                }
                else if (r2.next())
                {
                    errorLabel.setText("Email address Already exists");
                }
                else
                {
                    errorLabel.setTextFill(Color.GREEN);
                    errorLabel.setText("Your account is created! Procced to login...");
                    Statement statement = DBConnection.setConnection().createStatement();
                    statement.executeUpdate(query1);
                    emailTxt.setText("");
                    passwordTxt.setText("");
                    userTxt.setText("");
                }


            }

            catch (SQLException ex)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Database problem2");
                alert.setHeaderText(null);
                alert.setContentText(ex.getMessage());
                alert.showAndWait();
                System.exit(0);
            }
        }


    }

}