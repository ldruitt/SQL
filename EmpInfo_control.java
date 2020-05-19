package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.*;
import java.sql.*;
import java.math.*;

public class EmpInfo_control {

    @FXML
    private TextField txt1;

    @FXML
    private TextField txt2;

    @FXML
    private TextField txt3;

    @FXML
    private TextField txt4;

    @FXML
    private TextField txt5;

    @FXML
    private TextField txt6;

    @FXML
    private TextField txt7;

    @FXML
    private TextField txt8;

    @FXML
    private TextField txt9;

    @FXML
    private TextField txt10;

    @FXML
    private Button pushButton;
    
    @FXML
    public void insertEmp() throws SQLException, IOException{
    	PreparedStatement p;
    	String fname = txt1.getText();
    	String minit = txt2.getText();
    	String lname = txt3.getText();
    	String ssn = txt4.getText();
    	String bday = txt5.getText();
    	String addr = txt6.getText();
    	String sex = txt7.getText();
    	String sal = txt8.getText();
    	String sup = txt9.getText();
    	String dno = txt10.getText();
    	
    	String query = "insert into employee values (?,?,?,?,?,?,?,?,?,?,?)";
    	p = PartOne.conn.prepareStatement(query);
    	p.clearParameters();
    	p.setString(1,fname);
    	p.setString(2, minit);
    	p.setString(3, lname);
    	p.setString(4, ssn);
    	p.setString(5,bday);
    	p.setString(6, addr);
    	p.setString(7, sex);
    	p.setString(8, sal);
    	p.setString(9,sup);
    	p.setString(10, dno);
    	p.executeUpdate();
    }
    
    @FXML
    public void buttonManage(ActionEvent event) {
    	try {
    	    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EmpProj.fxml"));
    	            Parent root = (Parent) fxmlLoader.load();
    	            Stage stage = new Stage();
    	            stage.setScene(new Scene(root));  
    	            stage.show();
    	            PartOne.stg.close();
    	    } catch(Exception e) {
    	       e.printStackTrace();
    	      }
    }
}
