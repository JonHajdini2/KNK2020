package contractM;

import java.sql.Date;

public class EmployeeRecord
{
    
    private Integer id;
    private String name;
    private String surname;
    private Date birthDate;
    private Boolean MarriageStatus;
    private String number;
    private String email;
    private String address;
    private Integer hours;
    
    
    public EmployeeRecord(int id, String name, String surname, Date birthDate, Boolean MarriageStatus, String number,
                          String email, String address, Integer hours)
    {
        this.setId(id);
        this.setName(name);
        this.setSurname(surname);
        this.setBirthday(birthDate);
        this.setMarriageStatus(MarriageStatus);
        this.setNumber(number);
        this.setEmail(email);
        this.setAddress(address);
        this.setHours(hours);
    }
    
    
    public Integer getId() { return this.id; }
    
    public String getName() { return this.name; }
    
    public String getSurname() { return this.surname; }
    
    public Date getBirthday() { return this.birthDate; }
    
    public Boolean getMarriageStatus() { return this.MarriageStatus; }
    
    public String getNumber() { return this.number; }
    
    public String getEmail() { return this.email; }
    
    public String getAddress() { return this.address; }
    
    public Integer getHours() { return this.hours;}
    
    
    public void setId(int id) { this.id = id; }
    
    public void setBirthday(Date BirthDate) { this.birthDate = BirthDate; }
    
    public void setName(String name) { this.name = name; }
    
    public void setSurname(String surname) { this.surname = surname; }
    
    public void setMarriageStatus(Boolean MarriageStatus) { this.MarriageStatus = MarriageStatus; }
    
    public void setNumber(String number) { this.number = number; }
    
    public void setEmail(String Email) { this.email = Email; }
    
    public void setAddress(String Address) { this.address = Address; }
    
    public void setHours(Integer Hours) { this.hours = Hours; }
    
    
}
