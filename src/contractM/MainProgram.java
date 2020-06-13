package contractM;

import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainProgram
{
    public static void createMainStage()
    {
        Stage mainStage = new Stage();

        //Welcome we = new Welcome();

        MainScene mS = new MainScene(new Stage());
        //Scene scene = new Scene(we, 800, 600);
        //mainStage.setTitle("Welcome!");
        //mainStage.setScene(scene);
        //mainStage.show();
        mainStage.setResizable(false);

        Login M = new Login();

        /*we.logout.setOnAction(e ->
        {
            M.start(new Stage());  // log out
            mainStage.hide();
        });*/


       // we.btn3.setOnAction(e->
       // {
            //mainStage.hide();
            mainStage.setScene(mS);
            mainStage.setTitle("Payroll and Contract Management");
            mainStage.show();
        //});

        mS.logoutButton.setOnAction(e->
        {

            M.start(new Stage());
            mainStage.hide();
        });

       // we.logout.setOnMouseEntered(e->scene.setCursor(Cursor.HAND)); //Change cursor to hand);
       // we.logout.setOnMouseExited(e->scene.setCursor(Cursor.DEFAULT)); //Change cursor to default;

      //  we.btn3.setOnMouseEntered(e->scene.setCursor(Cursor.HAND)); //Change cursor to hand);
      //  we.btn3.setOnMouseExited(e->scene.setCursor(Cursor.DEFAULT)); //Change cursor to default;
    }

    public static void main(String[] args)
    {
    }

}
