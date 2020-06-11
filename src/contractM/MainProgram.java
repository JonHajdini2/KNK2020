package contractM;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sun.misc.SignalHandler;

public class MainProgram
{
    public static void createMainStage()
    {
        Stage mainStage = new Stage();

        Welcome we = new Welcome();

        Scene scene = new Scene(we, 800, 600);
        mainStage.setTitle("Welcome!");
        mainStage.setScene(scene);
        mainStage.show();

        Main M = new Main();
        we.logout.setOnAction(e ->
        {
            M.start(new Stage());  // log out
            mainStage.hide();
        });
    }

    public static void main(String[] args)
    {
    }

}
