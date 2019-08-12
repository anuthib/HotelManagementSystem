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
import java.util.ResourceBundle;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author PRANALI
 */
public class OccupantsListController implements Initializable {

    @FXML
    private TableView<Customer> ctable;
    @FXML
    private TableColumn<Customer, Integer> id;
    @FXML
    private TableColumn<Customer, String> firstNameCol;
    @FXML
    private TableColumn<Customer, String> middleNameCol;
    @FXML
    private TableColumn<Customer, String> lastNameCol;
    TextField addFirstName;
    TextField addLastName;
    TextField addEmail;

    private ObservableList<Customer> data = null;
    private java.sql.Statement st = null;
    //private TableColumn<?, ?> id;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        data = FXCollections.observableArrayList();
        try {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/HotelManagement", "pranali", "pranali123");
            st = con.createStatement();
            String sql = "select * from pranali.booking";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Customer cu = new Customer();
                cu.setId(rs.getInt("c_id"));
                cu.setFirstName(rs.getString("f_name"));
                cu.setMiddleName(rs.getString("m_name"));
                cu.setLastName(rs.getString("l_name"));
                data.add(cu);
                System.out.println(rs.getInt("c_id")+"");
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        middleNameCol.setCellValueFactory(new PropertyValueFactory<>("middleName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        ctable.setItems(data);
        System.out.println("ahbdjkd");
    }
}
