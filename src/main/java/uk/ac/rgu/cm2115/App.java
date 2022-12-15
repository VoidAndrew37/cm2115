package uk.ac.rgu.cm2115;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class App extends Application {

    // Launches the Launch Screen FXML File
    @Override
    public void start(Stage Launchstage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("LaunchScreen.fxml"));
        Launchstage.setScene(new Scene(root));
        Launchstage.show();
    }

    public static void main(String[] args) throws IOException {
        launch();
        // Command Design Pattern
        Status newStatus = Controls.getStatus();

        Save onSave = new Save(newStatus);

        StatusButtons onClick = new StatusButtons(onSave);

        onClick.press();


        // Creates CSV File
        // Creates File object
        File csvFile = new File("Vehicles.csv");
        // Creates FileWriter Object 
        FileWriter fw = new FileWriter(csvFile);
        try (// Creates Print Writer Object
        PrintWriter pw = new PrintWriter(csvFile)) {
            pw.println("MountainBike");

            pw.close();
        }


    }
}