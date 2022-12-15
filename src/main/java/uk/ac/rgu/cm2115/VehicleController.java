package uk.ac.rgu.cm2115;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

// Extends LaunchController to develop the hierarchy
public class VehicleController extends LaunchController {
    
    @FXML
    Button electricBikeButton, mountainBikeButton, electricScooterButton;

    // Changes to the ElectricBike Scene
    public void handleElectricBikeButton() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ElectricBike.fxml"));

        Stage window = (Stage) electricBikeButton.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    // Changes to the ElectricScooter Scene
    public void handleElectricScooterButton() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ElectricScooter.fxml"));

        Stage window = (Stage) electricScooterButton.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    // Changes to the MountainBike Scene
    public void handleMountainBikeButton() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MountainBike.fxml"));

        Stage window = (Stage) mountainBikeButton.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    // Changes back to the LaunchScreen Scene
    public void handleReturnHomeButton() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("LaunchScreen.fxml"));

        Stage window = (Stage) returnHomeButton.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    
    // Hire Price
    protected int getHirePrice;
    public int hirePrice() {
        System.out.println("Hire Price");
        return getHirePrice;

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
}
