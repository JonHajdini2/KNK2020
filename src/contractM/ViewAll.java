package contractM;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ViewAll extends TableView<EmployeeRecord>
{
    
    
    public ViewAll()
    {
        super();
        
        this.setup();
        EmployeesMenu.SearchEmployee.setOnKeyTyped(e ->
        {
            this.getColumns().clear();
            this.getItems().clear();
            this.setup();
            
        });
        
        EmployeesMenu.deleteEmployee.setOnAction(e ->
        {
            
            if (EmployeesMenu.SearchEmployee.getText().isEmpty())
            {
                MainScene.errorLabel.setText("No ID is specified");
                MainScene.errorLabel.setTextFill(Color.RED);
            }
            else
            {
                this.Delete();
            }
        });
        
        
    }
    
    private void setup()
    {
        ResultSet rSet;
        
        
        String Query =
         "SELECT employees.* , contracts.Contract_date_begin, contracts.Contract_date_due, contracts.job_title, " +
          "contracts.department, contracts.empSalary " +
          "FROM" +
          " employees JOIN contracts  ON employees.Employee_id = contracts.EmpID " +
          "WHERE employees.Employee_name REGEXP '^" + EmployeesMenu.SearchEmployee.getText() + "'"
          + "OR employees.Employee_id = '" + EmployeesMenu.SearchEmployee.getText() + "'"
          + "OR employees.Employee_surname REGEXP '^" + EmployeesMenu.SearchEmployee.getText() + "'"
          + "OR employees.Employee_birthday REGEXP '^" + EmployeesMenu.SearchEmployee.getText() + "'"
          + "OR employees.Employee_number REGEXP '^" + EmployeesMenu.SearchEmployee.getText() + "'"
          + "OR employees.Employee_email REGEXP '^" + EmployeesMenu.SearchEmployee.getText() + "'"
          + "OR employees.Employee_address REGEXP '^" + EmployeesMenu.SearchEmployee.getText() + "'"
          + "OR employees.Employee_hours REGEXP '^" + EmployeesMenu.SearchEmployee.getText() + "'"
          + "OR employees.status REGEXP '^" + EmployeesMenu.SearchEmployee.getText() + "'"
          + "OR contracts.Contract_date_begin REGEXP '^" + EmployeesMenu.SearchEmployee.getText() + "'"
          + "OR contracts.Contract_date_due REGEXP '^" + EmployeesMenu.SearchEmployee.getText() + "'"
          + "OR contracts.job_title REGEXP '^" + EmployeesMenu.SearchEmployee.getText() + "'"
          + "OR contracts.department REGEXP '^" + EmployeesMenu.SearchEmployee.getText() + "'"
          + "OR contracts.empSalary REGEXP '^" + EmployeesMenu.SearchEmployee.getText() + "'";
        
        
        try
        {
            Statement preparedStatement = DBConnection.setConnection().createStatement();
            rSet = preparedStatement.executeQuery(Query);
        }
        catch (Exception e1)
        {
            rSet = null;
            //e1.printStackTrace(); /** Uncomment this line if there is an error
        }
        TableColumn<EmployeeRecord, Integer> idColumn = new TableColumn<EmployeeRecord, Integer>("ID");
        TableColumn<EmployeeRecord, String> NameColumn = new TableColumn<>("Name");
        TableColumn<EmployeeRecord, String> SurnameColumn = new TableColumn<>("Surname");
        TableColumn<EmployeeRecord, String> BirthdayColumn = new TableColumn<>("Birthday");
        TableColumn<EmployeeRecord, Boolean> StatusColumn = new TableColumn<>("Is Married?");
        TableColumn<EmployeeRecord, String> NumberColumn = new TableColumn<>("Number");
        TableColumn<EmployeeRecord, String> EmailColumn = new TableColumn<>("Email");
        TableColumn<EmployeeRecord, String> AddressColumn = new TableColumn<>("Address");
        TableColumn<EmployeeRecord, Integer> HoursColumn = new TableColumn<>("Work Hours");
        TableColumn<EmployeeRecord, String> JobColumn = new TableColumn<>("Job");
        TableColumn<EmployeeRecord, String> DepartmentColumn = new TableColumn<>("Department");
        TableColumn<EmployeeRecord, String> ContractBeginColumn = new TableColumn<>("Contract Begin");
        TableColumn<EmployeeRecord, String> ContractEndColumn = new TableColumn<>("Contract Due");
        TableColumn<EmployeeRecord, Integer> SalaryColumn = new TableColumn<>("Salary");
        
        
        this.getColumns().add(idColumn);
        this.getColumns().add(NameColumn);
        this.getColumns().add(SurnameColumn);
        this.getColumns().add(BirthdayColumn);
        this.getColumns().add(StatusColumn);
        this.getColumns().add(NumberColumn);
        this.getColumns().add(EmailColumn);
        this.getColumns().add(AddressColumn);
        this.getColumns().add(HoursColumn);
        this.getColumns().add(JobColumn);
        this.getColumns().add(DepartmentColumn);
        this.getColumns().add(ContractBeginColumn);
        this.getColumns().add(ContractEndColumn);
        this.getColumns().add(SalaryColumn);
        
        this.setEditable(false);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        NameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        SurnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
        BirthdayColumn.setCellValueFactory(new PropertyValueFactory<>("Birthday"));
        StatusColumn.setCellValueFactory(new PropertyValueFactory<>("MarriageStatus"));
        NumberColumn.setCellValueFactory(new PropertyValueFactory<>("number"));
        EmailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        AddressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        HoursColumn.setCellValueFactory(new PropertyValueFactory<>("hours"));
        JobColumn.setCellValueFactory(new PropertyValueFactory<>("job"));
        DepartmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));
        ContractBeginColumn.setCellValueFactory(new PropertyValueFactory<>("contractBegin"));
        ContractEndColumn.setCellValueFactory(new PropertyValueFactory<>("contractEnd"));
        SalaryColumn.setCellValueFactory(new PropertyValueFactory<>("salary"));
        
        try
        {
            while (rSet.next())
            {
                
                this.getItems().add(new EmployeeRecord(rSet.getInt("Employee_id"), rSet.getString("Employee_name"),
                 rSet.getString("Employee_surname"), rSet.getDate("Employee_birthday"), rSet.getBoolean(
                 "status"), rSet.getString("Employee_number"), rSet.getString("Employee_email"), rSet.getString(
                 "Employee_address"), rSet.getInt("Employee_hours"), rSet.getString("job_title"), rSet.getString(
                 "department"), rSet.getDate("Contract_date_begin"), rSet.getDate("Contract_date_due"),
                 rSet.getString("empSalary")));
                
            }
        }
        catch (SQLException | NullPointerException e)
        {
            //e.printStackTrace(); /** Uncomment this line if there is an error with database
        }
    }
    
    private void Delete()
    {
        ResultSet rs;
        String Query = "DELETE employees.*, contracts.*, payment.* FROM employees JOIN contracts ON employees" +
         ".Employee_id = contracts.EmpID JOIN payment  ON employees.Employee_id = payment.empId WHERE Employee_id = " +
         "'" + EmployeesMenu.SearchEmployee.getText() + "'";
        try
        {
            
            Statement PreparedStatement = DBConnection.setConnection().createStatement();
            rs = PreparedStatement.executeQuery(Query);
            
        }
        catch (SQLException e)
        {
            //e.printStackTrace();}
            rs = null;
        }
    
        try
        {
        
           if(rs.next())
           {
               MainScene.errorLabel.setText("Employee Deletion was successful");
               MainScene.errorLabel.setTextFill(Color.GREEN);
           }
        
        }
        catch (SQLException e)
        {
            //e.printStackTrace();}
            
        }
    
    
    }
}
