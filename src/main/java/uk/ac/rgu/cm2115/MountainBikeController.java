package uk.ac.rgu.cm2115;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

// Extends VehicleController to develop the hierarchy
// Implements Bike Interface
public class MountainBikeController extends VehicleController implements CommandPattern, Status, Bike {

    // Adds the parts to the MountainBikeController Page
    private BrakeType brakeType;
    private Suspension suspension;
    private int frameSize1;

    // Adds Elements from the FXML Files and Scenebuilder
    @FXML
    private Label mountainBikeLabel;

    @FXML
    TextField mountainBikeName;

    // Connects the SceneBuilder Elements to the JavaFX Code
    @FXML
    private ChoiceBox<String> choiceFrameSize;

    // Gets Choice Box Options from Battery Type Enum
    @FXML
    private ChoiceBox<Suspension> choiceSuspensionType;

    @FXML
    private ChoiceBox<BrakeType> choiceBrakeType;

    private String[] frameSize = {"13", "14", "15", "16", "17", "18", "19", "20", "21", "22"};

    // Initialize properties
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
        // Adds elements to the ElectricBikeController        
        final Suspension[] suspension = {
            Suspension.Air,
            Suspension.Coil
        };

        final BrakeType[] brakeType = {
            BrakeType.Disc,
            BrakeType.Rim,
            BrakeType.Vbrake
        };

        choiceSuspensionType.getItems().addAll(suspension);
        choiceBrakeType.getItems().addAll(brakeType);
        choiceFrameSize.getItems().addAll(frameSize);

    }

    // Changes back to the LaunchScreen Scene
    public void handleReturnHomeButton() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("LaunchScreen.fxml"));

        Stage window = (Stage) returnHomeButton.getScene().getWindow();
        window.setScene(new Scene(root));
        
    }

// Code sourced/ adapted from https://www.youtube.com/watch?v=wxhGKR3PQpo
// Transfers information to the VehicleManager Controller
    private Parent root;

    public void  save(ActionEvent event) throws IOException {
        String vehicleTypes = mountainBikeName.getText();

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
    public BrakeType getBrakeType() {
        return this.brakeType;
    }

    @Override
    public int getFrameSize() {
        return this.frameSize1;
    }

    @Override
    public Suspension getSuspension() {
        return this.suspension;
    }

    @Override
    public void cancel() {
        System.out.println("You have cancelled and been returned to the home page");        
    }

    @Override
    public void save() {
        System.out.println("Vehicle Saved");        
        
    }
    
    @Override
    public void execute() {
        
    }
    
}
