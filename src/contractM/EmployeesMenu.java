package contractM;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.nio.file.attribute.PosixFileAttributes;

public class EmployeesMenu extends VBox
{
    public static Button showPayment = new Button("Show Payment");
    public static TextField SearchbyName = new TextField();
    public static ComboBox<String> SearchbyDep = new ComboBox<>(FXCollections.observableArrayList(" Computer Engineer",
     " Electrical " + "Engineer", " Computer Scientist", " Clear"));
    
    public EmployeesMenu(ViewStage employeeWindow, MainScene ms)
    {
        super();
        this.setup(employeeWindow, ms);
    }
    
    private void setup(ViewStage employeeWindow, MainScene ms)
    {
        HBox hbSearch = new HBox();
        
        
        SearchbyName.setPromptText("Search by name");
        SearchbyDep.setPromptText("Search by Department");
        SearchbyName.setStyle(" -fx-border-color: #7100fd; -fx-border-width: 0 0 2 0; -fx-background-color: " +
         "transparent; -fx-prompt-text-fill: rgba(78,55,55,0.76)");
        SearchbyDep.setStyle(" -fx-border-color: #7100fd; -fx-border-width: 0 0 2 0; -fx-background-color: " +
         "transparent; -fx-prompt-text-fill: rgba(78,55,55,0.76)");
        SearchbyDep.setPadding(new Insets(20, 0, 0, 0));
        SearchbyName.setPadding(new Insets(28, 0, 0, 0));
        SearchbyDep.setOnAction(e ->
        {
            try
            {
                if (SearchbyDep.getValue().equals(" Clear"))
                {
                   // SearchbyDep.getItems().clear();
                    //SearchbyDep.setPromptText("Search by Department");
                }
            }
            catch (NullPointerException | IndexOutOfBoundsException ignored) {}
        });
        
        
        Label EmployeeHeader = new Label("Employee Details");
        EmployeeHeader.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
        EmployeeHeader.setPadding(new Insets(15, 0, 0, 0));
        hbSearch.getChildren().addAll(EmployeeHeader, SearchbyName, SearchbyDep);
        hbSearch.setSpacing(100);
        
        ViewAll tableView = new ViewAll();
        HBox newTabButtonHBox = new HBox();
        Button newTabButton = new Button("Show in a new tab");
        newTabButtonHBox.getChildren().addAll(showPayment, newTabButton);
        newTabButtonHBox.setSpacing(60);
        newTabButtonHBox.setAlignment(Pos.CENTER_RIGHT);
        showPayment.setStyle("-fx-background-color: #00000000; -fx-border-width: 1px; -fx-border-style: solid; " +
         "-fx-border-color: black; -fx-cursor: hand; -fx-text-fill: black;");
        showPayment.setOnMouseEntered(e ->
        {
            showPayment.setStyle("-fx-background-color: #000000; -fx-border-width: 1px; -fx-border-style: solid; " +
             "-fx-border-color: black; -fx-cursor: hand; -fx-text-fill: aqua;");
        });
        showPayment.setOnMouseExited(e ->
        {
            showPayment.setStyle("-fx-background-color: #00000000; -fx-border-width: 1px; -fx-border-style: solid; " +
             "-fx-border-color: black; -fx-cursor: hand; -fx-text-fill: black;");
        });
        newTabButton.setStyle("-fx-background-color: #00000000; -fx-border-width: 1px; -fx-border-style: solid; " +
         "-fx-border-color: black; -fx-cursor: hand; -fx-text-fill: black;");
        newTabButton.setOnMouseEntered(e ->
        {
            newTabButton.setStyle("-fx-background-color: #000000; -fx-border-width: 1px; -fx-border-style: solid; " +
             "-fx-border-color: black; -fx-cursor: hand; -fx-text-fill: aqua;");
        });
        newTabButton.setOnMouseExited(e ->
        {
            newTabButton.setStyle("-fx-background-color: #00000000; -fx-border-width: 1px; -fx-border-style: solid; " +
             "-fx-border-color: black; -fx-cursor: hand; -fx-text-fill: black;");
        });
        newTabButton.setOnAction(e ->
        {
            employeeWindow.setup();
            employeeWindow.show();
        });
        
        this.getChildren().addAll(hbSearch, tableView, newTabButtonHBox);
        this.setStyle("-fx-padding: 20px; -fx-spacing: 20px;");
    }
    
}
