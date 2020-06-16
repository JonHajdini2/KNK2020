package contractM;

import java.io.Console;
import java.sql.*;

import com.mysql.cj.x.protobuf.MysqlxPrepare;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ViewAll extends TableView<EmployeeRecord>
{
    
    
    public ViewAll()
    {
        super();
       
        this.setup();
        EmployeesMenu.SearchbyName.setOnKeyTyped(e ->
        {
            this.getColumns().clear();
            this.getItems().clear();
            this.setup();
            
        });
    }
    
    private void setup()
    {
        ResultSet rSet;
        
        String Query =
         "SELECT * FROM employees WHERE Employee_name REGEXP '^" + EmployeesMenu.SearchbyName.getText() + "'";
        String Query2 = "";
        try
        {
            Statement preparedStatement = DBConnection.setConnection().createStatement();
            
            rSet = preparedStatement.executeQuery(Query);
            
        }
        catch (Exception e1)
        {
            rSet = null;
            e1.printStackTrace();
            System.out.println(e1.getMessage());
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
        
        
        this.getColumns().add(idColumn);
        this.getColumns().add(NameColumn);
        this.getColumns().add(SurnameColumn);
        this.getColumns().add(BirthdayColumn);
        this.getColumns().add(StatusColumn);
        this.getColumns().add(NumberColumn);
        this.getColumns().add(EmailColumn);
        this.getColumns().add(AddressColumn);
        this.getColumns().add(HoursColumn);
        
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
        
        try
        {
            while (rSet.next())
                this.getItems().add(new EmployeeRecord(rSet.getInt("Employee_id"), rSet.getString("Employee_name"),
                 rSet.getString("Employee_surname"), rSet.getDate("Employee_birthday"), rSet.getBoolean(
                 "status"), rSet.getString("Employee_number"), rSet.getString("Employee_email"), rSet.getString(
                 "Employee_address"), rSet.getInt("Employee_hours")));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    
}
