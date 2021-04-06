module com.mycompany.javaassignmentfive {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.javaassignmentfive to javafx.fxml;
    exports com.mycompany.javaassignmentfive;
}
