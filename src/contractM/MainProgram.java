package contractM;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

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

    }

    public static void main(String[] args)
    {
    }

}
