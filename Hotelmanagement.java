/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author PRANALI
 */
public class Hotelmanagement extends Application
{    
    @Override
    public void start(Stage primaryStage)
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLDocumentController.fxml"));    
            Scene scene = new Scene(root, 900, 600);        
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch(Exception e)
        {
            System.out.println("Exception raised");
            System.err.println(e+"");
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }
 
}
