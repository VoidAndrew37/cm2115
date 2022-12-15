package uk.ac.rgu.cm2115;

// Imports
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

// Implements Initializable
public class VehicleManager implements Initializable {

    // Adds the parts to the VehicleManager Page
    @FXML
    Button returnHomeButton;

    @FXML
    private ListView<String> vehicleChoice, vehicleInfo;

    @FXML
    private Label vehicleList;

    @FXML 
    private TextArea vehicleInfoTextArea;

    @FXML 
    private TextField mountainBikeName;

    // Handles the actions when a vehicle option is selected
    @FXML
    private void handleButtonAction(ActionEvent event) {
        vehicleInfoTextArea.appendText(vehicleChoice.getSelectionModel().getSelectedItem() + "\n");
    }

    // String[]  VehicleTypes = {"Mountain Bike", "ElectricBike", "ElectricScooter"};

    @FXML
    Label mountainBikeLabel;

    // writes to the array from the other Controllers
    public void vehicleTypesList(String vehicleTypes) {
        String[] vehicleChoice = {""};
        System.out.println(vehicleChoice);
    }

    String currentVehicles;

    private List <Vehicle> vehicles;
    public void addVehicle(Vehicle vehicle){
        this.vehicles.add(vehicle);
    }
    public List <Vehicle> getVehicles() {
        return this.vehicles;
    }

    
    @Override
    public void initialize(URL location, ResourceBundle resources) {


        // Observer Design Pattern
        // vehicleChoice.getItems().addAll(vehicleChoice);
        // Adds information to the ListView
        vehicleChoice.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                
                currentVehicles = vehicleChoice.getSelectionModel().getSelectedItem();

            }
            
        });
        
    }

    // Changes back to the LaunchScreen Scene
    public void handleReturnHomeButton() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("LaunchScreen.fxml"));

        Stage window = (Stage) returnHomeButton.getScene().getWindow();
        window.setScene(new Scene(root));
    }

}
