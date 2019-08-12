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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author PRANALI
 */

public class FXMLDocumentController implements Initializable
{
    @FXML
    private Label status;
    
    @FXML
    private TextField username;
    
    @FXML
    private PasswordField password;
    @FXML
    private Label label;
    
    @FXML
    public void login (ActionEvent event) throws Exception
    {
        if(username.getText().equals("qqq") && password.getText().equals("qqq"))
        {    
            Parent root = FXMLLoader.load(getClass().getResource("PostLogin.fxml"));    
            Scene scene = new Scene(root, 900, 600);      
            Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            primaryStage.hide();
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        else
        {
            username.clear();
            password.clear();
            status.setText("Invalid username or password. Please try again...");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
