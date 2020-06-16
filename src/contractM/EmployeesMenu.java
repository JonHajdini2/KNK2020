package contractM;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class EmployeesMenu extends VBox
{
    public static Button showPayment = I18N.buttonForKey("UpdateEmployee");
    public static TextField SearchEmployee = new TextField();

    
    public EmployeesMenu(ViewStage employeeWindow, MainScene ms)
    {
        super();
        this.setup(employeeWindow, ms);
    }
    
    private void setup(ViewStage employeeWindow, MainScene ms)
    {
        HBox hbSearch = new HBox();
        
        
        SearchEmployee.setPromptText(I18N.getLabel("SearchEmployee").getText());
       
        SearchEmployee.setStyle(" -fx-border-color: #7100fd; -fx-border-width: 0 0 2 0; -fx-background-color: " +
         "transparent; -fx-prompt-text-fill: rgba(78,55,55,0.76)");
      
       
        SearchEmployee.setPadding(new Insets(28, 0, 0, 0));
       
        
        
        Label EmployeeHeader = I18N.getLabel("EmployeeDetails");
        EmployeeHeader.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
        EmployeeHeader.setPadding(new Insets(15, 0, 0, 0));
        hbSearch.getChildren().addAll(EmployeeHeader, SearchEmployee);
        hbSearch.setSpacing(200);
        
        ViewAll tableView = new ViewAll();
        HBox newTabButtonHBox = new HBox();
        Button newTabButton = I18N.buttonForKey("ShowTab");
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
