package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.*;
import java.sql.*;
import java.math.*;

public class PartOne extends Application {
	static Stage stg;
	static Connection conn;
    @Override
    public void start(Stage stage) throws Exception {
    	this.stg = stage;
        final Parent root = FXMLLoader.load(getClass().getResource("Mgr_input.fxml"));
        Scene scene = new Scene(root);
        scene.setRoot(root);
        stage.setTitle("Manager Ssn");
        stage.setScene(scene);
        stage.show();
    }
    
	public static void main(String[] args) throws SQLException, IOException{
		String DRIVERNAME = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@apollo.vse.gmu.edu:1521:ite10g";
		String user = "ldruitt";
		String pass = "ptugle";
		try {
				Class.forName(DRIVERNAME);
				
		} catch(ClassNotFoundException x) {
			System.out.println("Driver could not be loaded");
		}
		Connection conn = DriverManager.getConnection(url,user,pass);
		PreparedStatement p;
		ResultSet r = null;
		String fname = "";
		String lname = "";
		BigDecimal ssn;
		String query = "select Fname, Lname, Ssn from EMPLOYEE, DEPARTMENT where Dnumber = Dno and Dname = 'Research'";
		p = conn.prepareStatement(query);
		p.clearParameters();
		r = p.executeQuery();
		System.out.println("First name \t Last name \t Ssn" );
		while(r.next()) {
			fname = r.getString(1);
			lname = r.getString(2);
			ssn = r.getBigDecimal(3);
			System.out.println(fname + "\t" + lname + "\t" + ssn);
		}
		PreparedStatement st;
		ResultSet set  = null;
		String lastname = "";
		BigDecimal hours;
		BigDecimal social;
		String q = "select Lname, Ssn, Hours from EMPLOYEE, PROJECT, WORKS_ON where Pnumber = Pno and Essn = Ssn and Pname = 'ProductZ' ";
		st = conn.prepareStatement(q);
		st.clearParameters();
		set  = st.executeQuery();
		System.out.println("Last name \t Ssn \t Hours" );
		while(set.next()) {
			lastname = set.getString(1);
			hours = set.getBigDecimal(2);
			social = set.getBigDecimal(3);
			System.out.println(lastname + "\t" + hours + "\t" + social);
		}
		launch(args);
		conn.close();
	}
}
