module uk.ac.rgu {
    requires javafx.controls;
    requires javafx.fxml;

    opens uk.ac.rgu.cm2115 to javafx.fxml;
    exports uk.ac.rgu.cm2115;
}
