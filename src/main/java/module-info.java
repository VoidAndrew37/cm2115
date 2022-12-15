module uk.ac.rgu {
    requires javafx.controls;
    requires javafx.fxml;

    opens uk.ac.rgu to javafx.fxml;
    exports uk.ac.rgu;
}
