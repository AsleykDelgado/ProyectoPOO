module co.edu.ufps.proyecto.poker {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens co.edu.ufps.proyecto.poker.controlador to javafx.fxml;
    exports co.edu.ufps.proyecto.poker;
}
