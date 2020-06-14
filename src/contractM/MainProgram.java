package contractM;

import javafx.stage.Stage;

public class MainProgram
{
    public static void createMainStage()
    {
        Stage mainStage = new Stage();

        MainScene mS = new MainScene(new Stage());
        mainStage.setResizable(false);

        Login M = new Login();

        mainStage.setScene(mS);
        mainStage.setTitle("Payroll and Contract Management");
        mainStage.show();


        mS.logoutButton.setOnAction(e ->
        {

            M.start(new Stage());
            mainStage.hide();
        });
    }




    public static void main(String[] args)
    {
    }

}
