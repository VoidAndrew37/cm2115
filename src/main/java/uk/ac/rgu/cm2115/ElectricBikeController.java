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
// Implements Bike and ElectricVehicle Interfaces
public class ElectricBikeController extends VehicleController implements Status, Bike, ElectricVehicle{


    // Adds the parts to the ElectricBikeController Page
    private BatteryType batteryType;
    private BrakeType brakeType;
    private Suspension suspension;
    

    // Connects the SceneBuilder Elements to the JavaFX Code
    @FXML
    private Label electricBikeLabel;

    @FXML
    private ChoiceBox<BrakeType> choiceBrakeType;

    @FXML
    private ChoiceBox<BatteryType> choiceBatteryType;

    @FXML
    private ChoiceBox<String> choicePedalAssist, choiceBikeFrame;
 

    // Strings for BikeFrame and PedalAssistThreshold
    private String[] bikeFrame = {"13", "14", "15", "16", "17", "18", "19", "20", "21", "22"};
    private String[] pedalAssistThreshold = {"1", "2", "3"};

    // Initializes properties
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        // Adds elements to the ElectricBikeController
        final BrakeType[] brakeType = {
            BrakeType.Disc,
            BrakeType.Rim,
            BrakeType.Vbrake
        };
        final BatteryType[] batteryTypes = {
            BatteryType.Lithium_Ion,
            BatteryType.Lithium_Manganese
        };

        // Adds options to the ChoiceBox
        choiceBatteryType.getItems().addAll(batteryTypes);
        choiceBrakeType.getItems().addAll(brakeType);
        choiceBikeFrame.getItems().addAll(bikeFrame);
        

    }

    // Changes back to the LaunchScreen Scene - Adapted from https://www.youtube.com/watch?v=hcM-R-YOKkQ
    public void handleReturnHome() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("LaunchScreen.fxml"));

        Stage window = (Stage) returnHomeButton.getScene().getWindow();
        window.setScene(new Scene(root));
    }


// Code sourced/ adapted from https://www.youtube.com/watch?v=wxhGKR3PQpo
    private Parent root;

    // Implements the Save Button
    public void  saveButton(ActionEvent event) throws IOException {
        String vehicleTypes = electricBikeLabel.getText();

        // Changes to VehicleManager Scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("VehicleManager.fxml"));
        root = loader.load();

        VehicleManager vehicleManager = loader.getController();
        vehicleManager.vehicleTypesList(vehicleTypes);


    }
// End of Code Sourced/ adapted

    // Getters for the Parts
    @Override
    public BatteryType getBatteryType() {
        return this.batteryType;
    }

    @Override
    public BrakeType getBrakeType() {
        return this.brakeType;
    }

    @Override
    public int getFrameSize() {
        return 0;
    }

    @Override
    public Suspension getSuspension() {
        return this.suspension;
    }

    public String[] getPedalAssistThreshold() {
        return this.pedalAssistThreshold;
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
