package contractM;

import javafx.stage.Stage;

import java.util.Date;

public class MainProgram extends Stage
{

    public void createMainStage()
    {
      
    
        MainScene mS = new MainScene(this);
        this.setResizable(false);

        Login M = new Login();

        this.setScene(mS);
        this.setTitle("Payroll and Contract Management");
        this.show();
        
        
        mS.logoutButton.setOnAction(e ->
        {
            
            M.start(new Stage());
            Login.userSession.cleanUserSession();
          
            this.close();
        
        });
        ViewStage V = new ViewStage();
        mS.ExitButton.setOnAction(e->
        {
            this.close();
            V.close();
        });
    }
    public static void main(String[] args)
    {
    }

}
