/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagement;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author PRANALI
 */
public class BookingPageController implements Initializable
{
    ObservableList<String> rCategoryList =
            FXCollections.observableArrayList("Deluxe Room", "Superior Room", "Ocean View Room", "Premier Club Room", "Executive Suite", "Royal Suite", "Presidential Suite");
    ObservableList<Integer> rNoList = FXCollections.observableArrayList(101, 102, 103, 104, 105, 201, 202, 203, 204, 205, 301, 302, 303, 304, 305, 401, 402, 403, 404, 405,
                                                                            501, 502, 503, 504, 505, 601, 602, 603, 604, 605, 701, 702, 703, 704, 705);
    
    @FXML
    private Label c_id;
    @FXML
    private DatePicker rDate;
    @FXML
    private TextField fName;
    @FXML
    private TextField mName;
    @FXML
    private TextField lName;
    @FXML
    private ChoiceBox <String>roomCategory;
    @FXML
    private ChoiceBox <Integer>roomNo;
    @FXML
    private TextField contact;
    @FXML
    private TextField email_id;
    @FXML
    private TextField residence;
    @FXML
    private TextField city;
    @FXML
    private TextField state;
    @FXML
    private Button back;
    @FXML
    private Label status;
    
    private java.sql.Statement st=null;
    private java.sql.Statement st2=null;
    
    @FXML
    public void confirmBooking(ActionEvent event)
    {
        try
        {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/HotelManagement", "pranali", "pranali123");
            PreparedStatement ps = con.prepareStatement("insert into pranali.booking values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, c_id.getText());
            Date date = java.sql.Date.valueOf(rDate.getValue());
            ps.setDate(2, date);
            ps.setString(3, fName.getText());
            ps.setString(4, mName.getText());
            ps.setString(5, lName.getText());
            ps.setInt(6, roomNo.getValue());
            ps.setString(7, roomCategory.getValue());
            ps.setLong(8, Long.parseLong(contact.getText()));
            ps.setString(9, email_id.getText());
            ps.setString(10, residence.getText());
            ps.setString(11, city.getText());
            ps.setString(12, state.getText());
            ps.executeUpdate();
            PreparedStatement ps2 = con.prepareStatement("update pranali.rooms set status=false where room_no=?");
            int rno = roomNo.getValue();
            ps2.setInt(1, rno);
            ps2.executeUpdate();
            Parent root = FXMLLoader.load(getClass().getResource("PostLogin.fxml"));    
            Scene scene = new Scene(root, 900, 600);      
            Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            primaryStage.hide();
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        roomCategory.setItems(rCategoryList);
        roomNo.setItems(rNoList);
        try
        {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/HotelManagement", "pranali", "pranali123");
            int custid = 1;
            st2 = con.createStatement();
            String sql = "select max(c_id) from pranali.booking";
            ResultSet rs2 = st2.executeQuery(sql);
            if (rs2.next())
            {
                custid = rs2.getInt(1);
            }
            custid = custid+1;
            c_id.setText(String.valueOf(custid));
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }    
    
    @FXML
    public void initializeRoomNo(String val)
    {
        
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
