/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagement;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author PRANALI
 */
public class PostLoginController implements Initializable
{         
    @FXML
    public void newBooking (ActionEvent event) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("BookingPage.fxml"));    
        Scene scene = new Scene(root, 900, 600);      
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.hide();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    @FXML
    public void customerDetails (ActionEvent event) throws Exception
    {
        System.out.println("customer");
    }
    
    @FXML
    public void vacantRooms (ActionEvent event) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("VacantRooms.fxml"));    
        Scene scene = new Scene(root, 900, 600);      
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.hide();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    @FXML
    public void occupantsList (ActionEvent event) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("OccupantsList.fxml"));    
        Scene scene = new Scene(root, 900, 600);      
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.hide();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    @FXML
    public void logOut (ActionEvent event) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("Logout.fxml"));    
        Scene scene = new Scene(root, 900, 600);      
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.hide();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
