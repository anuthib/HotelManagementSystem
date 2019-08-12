/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagement;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author PRANALI
 */

public class VacantRoomsController implements Initializable
{
    @FXML
    private Label dr;
    @FXML
    private Label sr;
    @FXML
    private Label ovr;
    @FXML
    private Label pcr;
    @FXML
    private Label es;
    @FXML
    private Label rs;
    @FXML
    private Label ps;
    
    private java.sql.Statement st=null;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        int cnt1=0, cnt2=0, cnt3=0, cnt4=0, cnt5=0, cnt6=0, cnt7=0;
        try
        {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/HotelManagement", "pranali", "pranali123");
            st = con.createStatement();
            ResultSet rs1 = st.executeQuery("select * from pranali.rooms where STATUS=true and room_category='DELUXE ROOM'");
            while(rs1.next())                
                cnt1++;
            ResultSet rs2 = st.executeQuery("select * from pranali.rooms where STATUS=true and room_category='SUPERIOR ROOM'");
            while(rs2.next())                
                cnt2++;
            ResultSet rs3 = st.executeQuery("select * from pranali.rooms where STATUS=true and room_category='OCEAN VIEW ROOM'");
            while(rs3.next())                
                cnt3++;
            ResultSet rs4 = st.executeQuery("select * from pranali.rooms where STATUS=true and room_category='PREMIER CLUB ROOM'");
            while(rs4.next())                
                cnt4++;
            ResultSet rs5 = st.executeQuery("select * from pranali.rooms where STATUS=true and room_category='EXECUTIVE SUITE'");
            while(rs5.next())                
                cnt5++;
            ResultSet rs6 = st.executeQuery("select * from pranali.rooms where STATUS=true and room_category='ROYAL SUITE'");
            while(rs6.next())                
                cnt6++;
            ResultSet rs7 = st.executeQuery("select * from pranali.rooms where STATUS=true and room_category='PRESIDENTIAL SUITE'");
            while(rs7.next())                
                cnt7++;
        }
        catch(SQLException e)
        {
            System.out.println("Exception raised");
            System.err.println(e+"");
        }
        dr.setText(""+cnt1);
        sr.setText(""+cnt2);
        ovr.setText(""+cnt3);
        pcr.setText(""+cnt4);
        es.setText(""+cnt5);
        rs.setText(""+cnt6);
        ps.setText(""+cnt7);
    }    
    
    @FXML
    private void goBack(ActionEvent event) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("PostLogin.fxml"));    
        Scene scene = new Scene(root, 900, 600);      
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.hide();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
