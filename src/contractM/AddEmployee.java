package contractM;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AddEmployee extends GridPane
{
    public Button btn3 = new Button("<- Back");
    
    TextField empId = new TextField();
    TextField empName = new TextField();
    TextField empSurname = new TextField();
    TextField empBirth = new TextField();
    TextField empEmail = new TextField();
    TextField empContact = new TextField();
    TextField empAddress = new TextField();
    TextField empHours = new TextField();
    TextField empIdConBeg = new TextField();
    TextField empIdConEnd = new TextField();
    ComboBox<String> empDep = new ComboBox<>(FXCollections.observableArrayList(" Computer Engineer",
     " Electrical " + "Engineer", " Computer Scientist"));
    ComboBox<String> empJob = new ComboBox<>(FXCollections.observableArrayList(" Choose Department"));
    
    CheckBox activeChb = new CheckBox("Married");
    TextField empNetto = new TextField();
    TextField empBonus = new TextField();
    TextField empDeduct = new TextField();
    TextField empSalary = new TextField();
    Button btAdd = I18N.buttonForKey("Add");
    Button ClearButton = I18N.buttonForKey("Clear");
    
    
    LocalDate datetimeBirth;
    LocalDate datetimeBegin;
    LocalDate datetimeEnd;
    String datebirthstring = "";
    String dateBeginstring = "";
    String dateEndstring = "";
    
    
    ProgressIndicator progressIndicator = new ProgressIndicator();
    
    static double ii = 0;
    
    
    public AddEmployee(MainScene ms)
    {
        super(); this.setup(ms);
    }
    
    private void setup(MainScene ms)
    {
        empDep.setOnAction(e ->
        {
            empJob.getItems().clear();
            if (empDep.getValue().equals(" Computer Engineer"))
                empJob.getItems().addAll(" Java Programmer", " .NET Programmer");
            else if (empDep.getValue().equals(" Computer Scientist"))
                empJob.getItems().addAll(" Data Scientist", " AI Development");
            else empJob.getItems().addAll(" Circ. Components", " Circuits");
        });
        
        
        DatePicker Birth_DatePicker = new DatePicker();
        DatePicker Contract_Begin = new DatePicker(LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth()
         , (LocalDate.now().getDayOfMonth() + 4 <= LocalDate.now().getMonth().length(LocalDate.now().isLeapYear())) ?
          (LocalDate.now().getDayOfMonth() + 4) :
          ((LocalDate.now().getDayOfMonth() + 4) % LocalDate.now().getMonth().length(LocalDate.now().isLeapYear()))));
        DatePicker Contract_Due = new DatePicker(LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(),
         (LocalDate.now().getDayOfMonth() + 4 <= LocalDate.now().getMonth().length(LocalDate.now().isLeapYear())) ?
          (LocalDate.now().getDayOfMonth() + 4) :
          ((LocalDate.now().getDayOfMonth() + 4) % LocalDate.now().getMonth().length(LocalDate.now().isLeapYear()))));
        
        VBox employeeImageVBox = new VBox();
        
        Image employeeImage = new Image("file:Images/employers.png", 250, 250, true, true);
        ImageView employeeImageView = new ImageView(employeeImage);
        
        
        employeeImageVBox.setStyle("-fx-background-color: transparent; -fx-padding: 20px;");
        employeeImageVBox.getChildren().addAll(employeeImageView);
        
        ClearButton.setStyle("-fx-background-color: #00000000; -fx-border-width: 1px; -fx-border-style: solid; " +
         "-fx-border-color: black; -fx-cursor: hand; -fx-text-fill: black;");
        ClearButton.setOnMouseEntered(e ->
        {
            ClearButton.setStyle("-fx-background-color: #000000; -fx-border-width: 1px; -fx-border-style: solid; " +
             "-fx-border-color: black; -fx-cursor: hand; -fx-text-fill: aqua;");
        }); ClearButton.setOnMouseExited(e ->
    {
        ClearButton.setStyle("-fx-background-color: #00000000; -fx-border-width: 1px; -fx-border-style: solid; " +
         "-fx-border-color: black; -fx-cursor: hand; -fx-text-fill: black;");
    });
        btAdd.setStyle("-fx-background-color: #00000000; -fx-border-width: 1px; -fx-border-style: solid; " + "-fx" +
         "-border-color: black; -fx-cursor: hand; -fx-text-fill: black;");
        btAdd.setOnMouseEntered(e ->
        {
            btAdd.setStyle("-fx-background-color: #000000; -fx-border-width: 1px; -fx-border-style: solid; " + "-fx" + "-border-color: black; -fx-cursor: hand; -fx-text-fill: aqua;");
        }); btAdd.setOnMouseExited(e ->
    {
        btAdd.setStyle("-fx-background-color: #00000000; -fx-border-width: 1px; -fx-border-style: solid; " + "-fx" +
         "-border-color: black; -fx-cursor: hand; -fx-text-fill: black;");
    });
        
        this.setPadding(new Insets(100, 0, 0, 100)); this.setHgap(40); this.setVgap(10);
        Label label = I18N.getLabel("Employee_Details");
        
        label.setStyle("-fx-font-size:15px;-fx-color:rgb(186, 201, 209)"); this.getChildren().add(label);
        label.setPadding(new Insets(0, 0, 20, 0));
        
        
        this.add(I18N.getLabel("Employee_ID"), 0, 1); this.add(empId, 1, 1);
        this.add(I18N.getLabel("First_Name"), 0, 2); this.add(empName, 1, 2); this.add(I18N.getLabel("Surname"), 0, 3);
        this.add(empSurname, 1, 3); this.add(I18N.getLabel("Date_Of_Birth"), 0, 4); this.add(empBirth, 1, 4);
        this.add(I18N.getLabel("Email"), 0, 5); this.add(empEmail, 1, 5); this.add(I18N.getLabel("Contact"), 0, 6);
        this.add(empContact, 1, 6); this.add(I18N.getLabel("Address"), 0, 7); this.add(empAddress, 1, 7);
        this.add(I18N.getLabel("Hour_Work_(per_day)"), 0, 8); this.add(empHours, 1, 8);
        this.add(I18N.getLabel("Contract_begin_date"), 0, 9); this.add(empIdConBeg, 1, 9);
        this.add(I18N.getLabel("Contract_due_date"), 0, 10); this.add(empIdConEnd, 1, 10);
        this.add(I18N.getLabel("Department"), 2, 1); this.add(empDep, 3, 1); this.add(I18N.getLabel("Job_Title"), 2, 2);
        this.add(empJob, 3, 2); this.add(I18N.getLabel("Status"), 2, 3); this.add(activeChb, 3, 3);
        this.add(I18N.getLabel("Nett_Salary"), 2, 4); this.add(empNetto, 3, 4);
        this.add(I18N.getLabel("Bonus_Payment"), 2, 5); this.add(empBonus, 3, 5);
        this.add(I18N.getLabel("Deduction_Payment"), 2, 6); this.add(empDeduct, 3, 6);
        this.add(I18N.getLabel("Salary"), 2, 7); this.add(empSalary, 3, 7);
        
        empSalary.setDisable(true);
        
        
        ForceFieldINT();
        
        AutomaticSalary();
        
        enhanceDatePickers(empBirth, empIdConBeg, empIdConEnd);
        
        empId.setStyle(" -fx-border-color: #7100fd; -fx-border-width: 0 0 2 0; -fx-background-color: transparent;");
        empName.setStyle(" -fx-border-color: #7100fd; -fx-border-width: 0 0 2 0; -fx-background-color: transparent;");
        empSurname.setStyle(" -fx-border-color: #7100fd; -fx-border-width: 0 0 2 0; -fx-background-color: " +
         "transparent;");
        empBirth.setStyle(" -fx-border-color: #7100fd; -fx-border-width: 0 0 2 0; " + "-fx-background-color: " +
         "transparent; -fx-prompt-text-fill: rgba(78,55,55,0.76)");
        empEmail.setStyle(" -fx-border-color: #7100fd; -fx-border-width: 0 0 2 0; -fx-background-color: " +
         "transparent; -fx-prompt-text-fill: rgba(78,55,55,0.76)");
        empContact.setStyle(" -fx-border-color: #7100fd; -fx-border-width: 0 0 2 0; -fx-background-color: " +
         "transparent; -fx-prompt-text-fill: rgba(78,55,55,0.76)");
        empAddress.setStyle(" -fx-border-color: #7100fd; -fx-border-width: 0 0 2 0; -fx-background-color: " +
         "transparent;");
        empHours.setStyle(" -fx-border-color: #7100fd; -fx-border-width: 0 0 2 0; -fx-background-color: " +
         "transparent; -fx-prompt-text-fill: rgba(78,55,55,0.76)");
        empIdConBeg.setStyle(" -fx-border-color: #7100fd; -fx-border-width: 0 0 2 0; -fx-background-color: " +
         "transparent; -fx-prompt-text-fill: rgba(78,55,55,0.76)");
        empIdConEnd.setStyle(" -fx-border-color: #7100fd; -fx-border-width: 0 0 2 0; -fx-background-color: " +
         "transparent; -fx-prompt-text-fill: rgba(78,55,55,0.76)");
        empDep.setStyle(" -fx-border-color: #7100fd; -fx-border-width: 0 0 2 0; -fx-background-color: transparent;");
        
        empJob.setStyle(" -fx-border-color: #7100fd; -fx-border-width: 0 0 2 0; -fx-background-color: transparent;");
        
        empNetto.setStyle(" -fx-border-color: #7100fd; -fx-border-width: 0 0 2 0; -fx-background-color: " +
         "transparent;");
        empBonus.setStyle(" -fx-border-color: #7100fd; -fx-border-width: 0 0 2 0; -fx-background-color: transparent;");
        empDeduct.setStyle(" -fx-border-color: #7100fd; -fx-border-width: 0 0 2 0; -fx-background-color: transparent;");
        empSalary.setStyle(" -fx-border-color: #7100fd; -fx-border-width: 0 0 2 0; -fx-background-color: " +
         "transparent; -fx-opacity: 1;");
        
        
        empBirth.setPromptText("DD/MM/YYYY"); empIdConBeg.setPromptText("DD/MM/YYYY");
        empIdConEnd.setPromptText("DD/MM/YYYY");
        
        
        this.add(btAdd, 2, 10); GridPane.setHalignment(btAdd, HPos.RIGHT); this.add(ClearButton, 3, 10);
        GridPane.setHalignment(btAdd, HPos.RIGHT);
        
        this.add(employeeImageVBox, 5, 2, 6, 7); this.add(progressIndicator, 12, 11);
        
        
        ClearButton.setOnAction(e -> clear());
        
        btn3.setStyle("    -fx-padding: 3px 10px 3px 10px;\r\n" + "    -fx-background-color: #2C3E48");
        btn3.setTextFill(Color.rgb(186, 201, 209));
        
        btAdd.setOnAction(e ->
        {
            boolean Fill = FillAll(); if (Fill)
        {
            
            datetimeBirth = LocalDate.parse(empBirth.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            datetimeBegin = LocalDate.parse(empIdConBeg.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            datetimeEnd = LocalDate.parse(empIdConEnd.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            datebirthstring = datetimeBirth.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            dateBeginstring = datetimeBegin.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            dateEndstring = datetimeEnd.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")); AddEmp();
            
        }
        else
        {
            MainScene.errorLabel.setText(I18N.getLabel("FillAll").getText());
            MainScene.errorLabel.setTextFill(Color.RED);
        }
        });
    }
    
    
    public void AddEmp()
    {
        String query = "Insert into employees(Employee_id, Employee_name, Employee_surname,	Employee_birthday, " +
         "status," + " Employee_number, Employee_email, Employee_address, Employee_hours) " + "values ('" + empId.getText() + "','" + empName.getText() + "','" + empSurname.getText() + "','" + datebirthstring + "','" + activeChb.isSelected() + "','" + empContact.getText() + "','" + empEmail.getText() + "','" + empAddress.getText() + "','" + empHours.getText() + "')";
        
        String query2 =
         "Insert into contracts(Contract_date_begin, Contract_date_due, job_title, department,EmpId," + "empSalary )" + "values ('" + dateBeginstring + "','" + dateEndstring + "','" + empJob.getValue() + "','" + empDep.getValue() + "'," + "'" + empId.getText() + "','" + empSalary.getText() + "')";
        
        String query3 =
         "Insert into payment(Employee_netto_salary, payment_bonus, tax_ammount,empId)" + "values ('" + empNetto.getText() + "','" + empBonus.getText() + "','" + empDeduct.getText() + "','" + empId.getText() + "')";
        try
        {
            PreparedStatement preparedStatement = DBConnection.setConnection().prepareStatement(query);
            
            preparedStatement.executeUpdate(query);
            
            PreparedStatement preparedStatement2 = DBConnection.setConnection().prepareStatement(query2);
            
            preparedStatement2.executeUpdate(query2);
            
            PreparedStatement preparedStatement3 = DBConnection.setConnection().prepareStatement(query3);
            
            preparedStatement3.executeUpdate(query3);
            
            
            MainScene.errorLabel.setText(I18N.getLabel("Employee").getText());
            MainScene.errorLabel.setTextFill(Color.GREEN);
            
            clear();
            
            ii += 1; ProgressIndicator(ii);
            
            this.setOnMouseClicked(e ->
            {
                ii += -1; ProgressIndicator(ii);
            });
        }
        catch (SQLException e)
        {
            
            MainScene.errorLabel.setText(I18N.getLabel("ParsingError").getText());
            MainScene.errorLabel.setTextFill(Color.RED);
        }
        
    }
    
    public void clear()
    {
        empId.setText(""); empName.setText(""); empSurname.setText(""); empBirth.setText(""); empContact.setText("");
        empEmail.setText(""); empAddress.setText(""); empIdConBeg.setText(""); empIdConEnd.setText("");
        empHours.setText(""); empDep.setValue(""); empJob.setValue(""); empBonus.setText(""); empDeduct.setText("");
        empNetto.setText(""); empSalary.setText("");
    }
    
    public boolean FillAll()
    {
        if (empId.getText().isEmpty() || empName.getText().isEmpty() || empSurname.getText().isEmpty() || empBirth.getText().isEmpty() || empContact.getText().isEmpty() || empEmail.getText().isEmpty() || empAddress.getText().isEmpty() || empIdConBeg.getText().isEmpty() || empIdConEnd.getText().isEmpty() || empHours.getText().isEmpty() || empDep.getValue().isEmpty() || empJob.getValue().isEmpty() || empBonus.getText().isEmpty() || empDeduct.getText().isEmpty() || empNetto.getText().isEmpty() || empSalary.getText().isEmpty())
        {
            return false;
        }
        else return true;
    }
    
    
    public static void enhanceDatePickers(TextField... textfield)
    {
        for (TextField textField : textfield)
        {
            textField.addEventHandler(KeyEvent.KEY_TYPED, event ->
            {
                if (!"0123456789/".contains(event.getCharacter()))
                {
                    return;
                }
                if ("/".equals(event.getCharacter()) && (textField.getText().isEmpty() || textField.getText().charAt(textField.getCaretPosition() - 1) == '/'))
                {
                    //If the users types slash again after it has been added, cancels it.
                    MainScene.errorLabel.setText("Cancel User Input"); MainScene.errorLabel.setTextFill(Color.RED);
                    event.consume();
                    
                } textField.selectForward();
                if (!event.getCharacter().equals("/") && textField.getSelectedText().equals("/"))
                {
                    textField.cut(); textField.selectForward();
                } textField.cut();
                
                Platform.runLater(() ->
                {
                    String textUntilHere = textField.getText(0, textField.getCaretPosition());
                    if (textUntilHere.matches("\\d\\d") || textUntilHere.matches("\\d\\d/\\d\\d"))
                    {
                        String textAfterHere = ""; try
                    {
                        textAfterHere = textField.getText(textField.getCaretPosition() + 1,
                         textField.getText().length());
                    }
                    catch (Exception ignored) {} int caretPosition = textField.getCaretPosition();
                        textField.setText(textUntilHere + "/" + textAfterHere);
                        textField.positionCaret(caretPosition + 1);
                    }
                });
            });
        }
    }
    
    public void ProgressIndicator(double ii)
    {
        progressIndicator.setProgress(ii);
    }
    
    private void ForceFieldINT()
    {
        // force the field to be numeric only
        empNetto.textProperty().addListener((observable, oldValue, newValue) ->
        {
            if (!newValue.matches("\\d*"))
            {
                empNetto.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        
        
        // force the field to be numeric only
        empBonus.textProperty().addListener((observable, oldValue, newValue) ->
        {
            if (!newValue.matches("\\d*"))
            {
                empBonus.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        
        
        // force the field to be numeric only
        empDeduct.textProperty().addListener((observable, oldValue, newValue) ->
        {
            if (!newValue.matches("\\d*"))
            {
                empDeduct.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        
        empId.textProperty().addListener((observable, oldValue, newValue) ->
        {
            if (!newValue.matches("\\d*"))
            {
                empId.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        
        empContact.textProperty().addListener((observable, oldValue, newValue) ->
        {
            if (!newValue.matches("\\d*"))
            {
                empContact.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        
        empSalary.textProperty().addListener((observable, oldValue, newValue) ->
        {
            if (!newValue.matches("\\d*"))
            {
                empSalary.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        
        
        empHours.textProperty().addListener((observable, oldValue, newValue) ->
        {
            if (!newValue.matches("\\d*"))
            {
                empHours.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }
    
    private void AutomaticSalary()
    {
        
        empNetto.textProperty().addListener((observable, oldValue, newValue) ->
        {
            try
            {
                empSalary.setText(String.valueOf(Integer.parseInt(empBonus.getText()) - Integer.parseInt(empDeduct.getText()) + Integer.parseInt(newValue)));
            }
            catch (NumberFormatException NE)
            {
            
            }
        });
        
        
        empDeduct.textProperty().addListener((observable, oldValue, newValue) ->
        {
            try
            {
                empSalary.setText(String.valueOf(Integer.parseInt(empBonus.getText()) - Integer.parseInt(newValue) + Integer.parseInt(empNetto.getText())));
            }
            catch (NumberFormatException NE)
            {
            
            }
        });
        
        
        empBonus.textProperty().addListener((observable, oldValue, newValue) ->
        {
            try
            {
                empSalary.setText(String.valueOf(-Integer.parseInt(empDeduct.getText()) + Integer.parseInt(newValue) + Integer.parseInt(empNetto.getText())));
            }
            catch (NumberFormatException NE)
            {
            
            }
        });
        
        
    }
    
}

