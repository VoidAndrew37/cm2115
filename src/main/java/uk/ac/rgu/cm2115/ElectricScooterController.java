package uk.ac.rgu.cm2115;

import java.io.IOException;
// Imports
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

// Extends VehicleController to develop the hierarchy
// Implements ElectricVehicle Interface
public class ElectricScooterController extends VehicleController implements Status, ElectricVehicle{

    private BatteryType batteryType;

    // Connects the SceneBuilder Elements to the JavaFX Code
    @FXML
    private Label electricScooterLabel;

    @FXML
    private ChoiceBox<String> rideModeChoice, pedalAssistThresholdChoice;

    // Gets Choice Box Options from Battery Type Enum
    @FXML
    private ChoiceBox<BatteryType> batteryTypeChoice;

    private String[] rideMode = {"1", "2", "3"};
    

    // Initialize properties
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Adds elements to the ElectricBikeController
        final BatteryType[] batteryTypes = {
            BatteryType.Lithium_Ion,
            BatteryType.Lithium_Manganese
        };
        // Adds options to the ChoiceBox
        batteryTypeChoice.getItems().addAll(batteryTypes);
        rideModeChoice.getItems().addAll(rideMode);

    }

    // Changes back to the LaunchScreen Scene
    public void handleReturnHome() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("LaunchScreen.fxml"));

        Stage window = (Stage) returnHomeButton.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    
// Code sourced/ adapted from https://www.youtube.com/watch?v=wxhGKR3PQpo
    private Parent root;

    // Implements Save Button
    public void  saveButton(ActionEvent event) throws IOException {
        String vehicleTypes = electricScooterLabel.getText();

        // Changes to VehicleManager Screen
        FXMLLoader loader = new FXMLLoader(getClass().getResource("VehicleManager.fxml"));
        root = loader.load();

        VehicleManager vehicleManager = loader.getController();
        vehicleManager.vehicleTypesList(vehicleTypes);

        // stage = (Stage)((Node)event.getSource()).getScene.getWindow();
        // scene = new Scene(root);
        // stage.setScene(scene);
    }
// End of Code Sourced/ adapted


    // Getters
    @Override
    public BatteryType getBatteryType() {
        return this.batteryType;
    }

    @Override
    public void cancel() {
        System.out.println("You have cancelled and been returned to the home page");        
    }

    @Override
    public void save() {
        System.out.println("Vehicle Saved");        
        
    }
}
