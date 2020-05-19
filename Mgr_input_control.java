
package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Mgr_input_control {


    @FXML
    private TextField field;

    @FXML
    private Label given_ssn;

    @FXML
    private Button pushButton;

    @FXML
    public void readText() {
		String txt = field.getText();
		if(txt.equals("333445555")||txt.equals("987654321")||txt.equals("888665555")) {
			System.out.println("Welcome Manager");
		}
		else
			System.out.println("Access Denied");
	}
    @FXML
    public void buttonManage(ActionEvent event) {
    	try {
    	    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EmpInfo.fxml"));
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
