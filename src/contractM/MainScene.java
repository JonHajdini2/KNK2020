package contractM;


import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Locale;

public class MainScene extends Scene
{

    public Button ExitButton = I18N.buttonForKey("Close");
    public Button logoutButton = I18N.buttonForKey("LogOut");
    public static BorderPane centerBorderPane = new BorderPane();
    public static boolean[] menuStatus = new boolean[]{true, false, false, false};
    public static Button[] menuButtons = new Button[]{I18N.buttonForKey("homeMenuButton"), I18N.buttonForKey(
     "updateMenuButton"), I18N.buttonForKey("addMenuButton"), I18N.buttonForKey("viewMenuButton")};

    public static Label errorLabel = new Label();

    public MainScene(Stage primaryStage)
    {
        super(new BorderPane(), 1280, 720);
        this.setup(primaryStage);
    }

    public void setup(Stage primaryStage)
    {
        primaryStage.setX((Screen.getPrimary().getVisualBounds().getWidth() - 1280) / 2);
        primaryStage.setY((Screen.getPrimary().getVisualBounds().getHeight() - 720) / 2);

        BorderPane borderPane = new BorderPane();


        HBox settingsAndLogout = new HBox();


        BorderPane topBorderPane = new BorderPane();

        HBox menu = new HBox();


        BorderPane LogoutLabel = new BorderPane();


        HBox languageHBox = new HBox();
        ComboBox<String> languageCB = new ComboBox<String>(FXCollections.observableArrayList("AL", "EN"));
        HBox hBoxError = new HBox();

        // RentalHistoryStage rentalHistoryWindow = new RentalHistoryStage(this.username);
        // this.settingsWindow = new SettingsStage(this, primaryStage);
        LogoutLabel.setRight(hBoxError);
        LogoutLabel.setLeft(settingsAndLogout);

        borderPane.setStyle("-fx-background-color: linear-gradient(to bottom right, #03DAC6, #018786);");
        // borderPane.setStyle("-fx-background-color: linear-gradient(to bottom right, #00ffff, #003f3f);");
        // borderPane.setLeft(leftBorderPane);
        borderPane.setCenter(centerBorderPane);
        ExitButton.setStyle("-fx-background-color: #00000000; -fx-border-width: 1px; -fx-border-style: solid; " +
         "-fx-border-color: black; -fx-cursor: hand; -fx-text-fill: black;");
        ExitButton.setOnAction(e ->
        {
            //this.settingsWindow.show();
        });
        ExitButton.setOnMouseEntered(e ->
        {
            ExitButton.setStyle("-fx-background-color: #000000; -fx-border-width: 1px; -fx-border-style: solid; " +
             "-fx-border-color: black; -fx-cursor: hand; -fx-text-fill: aqua;");
        });
        ExitButton.setOnMouseExited(e ->
        {
            ExitButton.setStyle("-fx-background-color: #00000000; -fx-border-width: 1px; -fx-border-style: solid;" +
             " -fx-border-color: black; -fx-cursor: hand; -fx-text-fill: black;");
        });
        logoutButton.setStyle("-fx-background-color: #00000000; -fx-border-width: 1px; -fx-border-style: solid; " +
         "-fx-border-color: black; -fx-cursor: hand; -fx-text-fill: black;");
        logoutButton.setOnMouseEntered(e ->
        {
            logoutButton.setStyle("-fx-background-color: #000000; -fx-border-width: 1px; -fx-border-style: solid; " +
             "-fx-border-color: black; -fx-cursor: hand; -fx-text-fill: aqua;");
        });
        logoutButton.setOnMouseExited(e ->
        {
            logoutButton.setStyle("-fx-background-color: #00000000; -fx-border-width: 1px; -fx-border-style: solid; " +
             "-fx-border-color: black; -fx-cursor: hand; -fx-text-fill: black;");
        });
        settingsAndLogout.getChildren().addAll(ExitButton, logoutButton);
        settingsAndLogout.setStyle("-fx-spacing: 10px;");
        centerBorderPane.setTop(topBorderPane);
        centerBorderPane.setCenter(new HomeContent(primaryStage, this));
        centerBorderPane.setBottom(LogoutLabel);
        menuButtons[0].setStyle("-fx-background-color: #000000; -fx-border-width: 1px; -fx-border-style: solid; " +
         "-fx-border-color: black; -fx-cursor: hand; -fx-text-fill: aqua;");
        for (int i = 1; i < menuButtons.length; i++)
            menuButtons[i].setStyle("-fx-background-color: #00000000; -fx-border-width: 1px; -fx-border-style: solid;" +
             " -fx-border-color: black; -fx-cursor: hand; -fx-text-fill: black;");
        menuButtons[0].setOnAction(e ->
        {
            centerBorderPane.setCenter(new HomeContent(primaryStage, this));
            menuStatus[0] = true;
            menuStatus[1] = false;
            menuStatus[2] = false;
            menuStatus[3] = false;
            menuButtons[1].setStyle("-fx-background-color: #00000000; -fx-border-width: 1px; -fx-border-style: solid;" +
             " -fx-border-color: black; -fx-cursor: hand; -fx-text-fill: black;");
            menuButtons[2].setStyle("-fx-background-color: #00000000; -fx-border-width: 1px; -fx-border-style: solid;" +
             " -fx-border-color: black; -fx-cursor: hand; -fx-text-fill: black;");
            menuButtons[3].setStyle("-fx-background-color: #00000000; -fx-border-width: 1px; -fx-border-style: solid;" +
             " -fx-border-color: black; -fx-cursor: hand; -fx-text-fill: black;");
        });
        menuButtons[0].setOnMouseEntered(e ->
        {
            menuButtons[0].setStyle("-fx-background-color: #000000; -fx-border-width: 1px; -fx-border-style: solid; " +
             "-fx-border-color: black; -fx-cursor: hand; -fx-text-fill: aqua;");
        });
        menuButtons[0].setOnMouseExited(e ->
        {
            if (!menuStatus[0])
                menuButtons[0].setStyle("-fx-background-color: #00000000; -fx-border-width: 1px; -fx-border-style: " +
                 "solid; -fx-border-color: black; -fx-cursor: hand; -fx-text-fill: black;");
        });
        menuButtons[1].setOnAction(e ->
        {
            centerBorderPane.setCenter(new UpdateEmployee());
            menuStatus[1] = true;
            menuStatus[0] = false;
            menuStatus[2] = false;
            menuStatus[3] = false;
            menuButtons[0].setStyle("-fx-background-color: #00000000; -fx-border-width: 1px; -fx-border-style: solid;" +
             " -fx-border-color: black; -fx-cursor: hand; -fx-text-fill: black;");
            menuButtons[2].setStyle("-fx-background-color: #00000000; -fx-border-width: 1px; -fx-border-style: solid;" +
             " -fx-border-color: black; -fx-cursor: hand; -fx-text-fill: black;");
            menuButtons[3].setStyle("-fx-background-color: #00000000; -fx-border-width: 1px; -fx-border-style: solid;" +
             " -fx-border-color: black; -fx-cursor: hand; -fx-text-fill: black;");
        });
        menuButtons[1].setOnMouseEntered(e ->
        {
            menuButtons[1].setStyle("-fx-background-color: #000000; -fx-border-width: 1px; -fx-border-style: solid; " +
             "-fx-border-color: black; -fx-cursor: hand; -fx-text-fill: aqua;");
        });
        menuButtons[1].setOnMouseExited(e ->
        {
            if (!menuStatus[1])
                menuButtons[1].setStyle("-fx-background-color: #00000000; -fx-border-width: 1px; -fx-border-style: " +
                 "solid; -fx-border-color: black; -fx-cursor: hand; -fx-text-fill: black;");
        });
        menuButtons[2].setOnAction(e ->
        {
            centerBorderPane.setCenter(new AddEmployee(this));

            menuStatus[2] = true;
            menuStatus[1] = false;
            menuStatus[0] = false;
            menuStatus[3] = false;
            menuButtons[1].setStyle("-fx-background-color: #00000000; -fx-border-width: 1px; -fx-border-style: solid;" +
             " -fx-border-color: black; -fx-cursor: hand; -fx-text-fill: black;");
            menuButtons[0].setStyle("-fx-background-color: #00000000; -fx-border-width: 1px; -fx-border-style: solid;" +
             " -fx-border-color: black; -fx-cursor: hand; -fx-text-fill: black;");
            menuButtons[3].setStyle("-fx-background-color: #00000000; -fx-border-width: 1px; -fx-border-style: solid;" +
             " -fx-border-color: black; -fx-cursor: hand; -fx-text-fill: black;");
        });
        menuButtons[2].setOnMouseEntered(e ->
        {
            menuButtons[2].setStyle("-fx-background-color: #000000; -fx-border-width: 1px; -fx-border-style: solid; " +
             "-fx-border-color: black; -fx-cursor: hand; -fx-text-fill: aqua;");
        });
        menuButtons[2].setOnMouseExited(e ->
        {
            if (!menuStatus[2])
                menuButtons[2].setStyle("-fx-background-color: #00000000; -fx-border-width: 1px; -fx-border-style: " +
                 "solid; -fx-border-color: black; -fx-cursor: hand; -fx-text-fill: black;");
        });
        ViewStage viewStage = new ViewStage();
        menuButtons[3].setOnAction(e ->
        {
            centerBorderPane.setCenter(new EmployeesMenu(viewStage, this));
            menuStatus[3] = true;
            menuStatus[1] = false;
            menuStatus[2] = false;
            menuStatus[0] = false;
            menuButtons[1].setStyle("-fx-background-color: #00000000; -fx-border-width: 1px; -fx-border-style: solid;" +
             " -fx-border-color: black; -fx-cursor: hand; -fx-text-fill: black;");
            menuButtons[2].setStyle("-fx-background-color: #00000000; -fx-border-width: 1px; -fx-border-style: solid;" +
             " -fx-border-color: black; -fx-cursor: hand; -fx-text-fill: black;");
            menuButtons[0].setStyle("-fx-background-color: #00000000; -fx-border-width: 1px; -fx-border-style: solid;" +
             " -fx-border-color: black; -fx-cursor: hand; -fx-text-fill: black;");
        });
        menuButtons[3].setOnMouseEntered(e ->
        {
            menuButtons[3].setStyle("-fx-background-color: #000000; -fx-border-width: 1px; -fx-border-style: solid; " +
             "-fx-border-color: black; -fx-cursor: hand; -fx-text-fill: aqua;");
        });
        menuButtons[3].setOnMouseExited(e ->
        {
            if (!menuStatus[3])
                menuButtons[3].setStyle("-fx-background-color: #00000000; -fx-border-width: 1px; -fx-border-style: " +
                 "solid; -fx-border-color: black; -fx-cursor: hand; -fx-text-fill: black;");
        });
        HomeContent.searchButton.setOnAction(e->
        {
            centerBorderPane.setCenter(new AddEmployee(this));

            menuStatus[2] = true;
            menuStatus[1] = false;
            menuStatus[0] = false;
            menuStatus[3] = false;
            menuButtons[1].setStyle("-fx-background-color: #00000000; -fx-border-width: 1px; -fx-border-style: solid;" +
             " -fx-border-color: black; -fx-cursor: hand; -fx-text-fill: black;");
            menuButtons[0].setStyle("-fx-background-color: #00000000; -fx-border-width: 1px; -fx-border-style: solid;" +
             " -fx-border-color: black; -fx-cursor: hand; -fx-text-fill: black;");
            menuButtons[3].setStyle("-fx-background-color: #00000000; -fx-border-width: 1px; -fx-border-style: solid;" +
             " -fx-border-color: black; -fx-cursor: hand; -fx-text-fill: black;");
            menuButtons[2].setStyle("-fx-background-color: #000000; -fx-border-width: 1px; -fx-border-style: solid; " +
             "-fx-border-color: black; -fx-cursor: hand; -fx-text-fill: aqua;");

        });
        /*HomeContent.searchButton.setOnMouseEntered(e ->
        {
            menuButtons[2].setStyle("-fx-background-color: #000000; -fx-border-width: 1px; -fx-border-style: solid; " +
             "-fx-border-color: black; -fx-cursor: hand; -fx-text-fill: aqua;");
        });
        HomeContent.searchButton.setOnMouseExited(e ->
        {
            if (!menuStatus[2])
                menuButtons[2].setStyle("-fx-background-color: #00000000; -fx-border-width: 1px; -fx-border-style: " +
                 "solid; -fx-border-color: black; -fx-cursor: hand; -fx-text-fill: black;");
        });*/




        topBorderPane.setCenter(menu);
        topBorderPane.setRight(languageHBox);
        topBorderPane.setStyle("-fx-border-width: 0px 0px 1px 0px; -fx-border-style: none none solid none; " +
         "-fx-border-color: black; -fx-padding: 20px; -fx-background-color: rgba(239,235,235,0.37);");
        menu.getChildren().addAll(menuButtons);
        menu.setStyle("-fx-spacing: 10px;");
        languageCB.setValue("EN");
        languageCB.setStyle("-fx-border-width: 1px; -fx-border-style: solid; -fx-border-color: #000000; " +
         "-fx-background-color: #00000000;");
        languageCB.setOnAction(e ->
        {
            I18N.setLocale(new Locale(languageCB.getValue().toLowerCase()));
            errorLabel.setText("");
            errorLabel.setTextFill(Color.RED);
        });
        languageHBox.getChildren().addAll(I18N.getLabel("languageLabel"), languageCB);
        languageHBox.setAlignment(Pos.CENTER);
        languageHBox.setStyle("-fx-spacing: 10px;");
        errorLabel.setTextFill(Color.RED);
        hBoxError.getChildren().add(errorLabel);
        hBoxError.setAlignment(Pos.BOTTOM_RIGHT);
        LogoutLabel.setStyle(
         "-fx-border-width: 1px 0px 0px 0px; -fx-border-style: solid none none none; " +
          "-fx-border-color: black; -fx-padding: 20px; -fx-background-color: rgba(239,235,235,0.37);");

        primaryStage.setOnCloseRequest(e ->
        {
            viewStage.close();
        });
        
     
        
        

        super.setRoot(borderPane);
    }
}
