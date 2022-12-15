package uk.ac.rgu.cm2115;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;




// Implements Initializable
public class LaunchController implements Initializable {

    // Adds Elements from the FXML Files and Scenebuilder
    @FXML private TextArea vehicleInfoTextArea;

    //Launch Screen
    @FXML 
    Button vehicleManagerButton, vehicleAddButton;

    //Return Home Button
    @FXML
    protected 
    Button returnHomeButton;


    // Changes screen to VehicleManager Scene
    public void handleVehicleManagerButton() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("VehicleManager.fxml"));

        Stage window = (Stage) vehicleManagerButton.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    // Changes screen to VehicleAdd Scene
    public void handleVehicleAddButton() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("VehicleAdd.fxml"));

        Stage window = (Stage) vehicleAddButton.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
}

