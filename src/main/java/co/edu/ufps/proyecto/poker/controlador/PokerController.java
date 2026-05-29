/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package co.edu.ufps.proyecto.poker.controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class PokerController implements Initializable {

    @FXML
    private GridPane grdPremios;
    @FXML
    private HBox hboxCartas;
    @FXML
    private ImageView imgCarta1;
    @FXML
    private ImageView imgCarta2;
    @FXML
    private ImageView imgCarta3;
    @FXML
    private ImageView imgCarta4;
    @FXML
    private ImageView imgCarta5;
    @FXML
    private TextField txtCreditos;
    @FXML
    private TextField txtCreditosApostados;
    @FXML
    private Button btnRetener1;
    @FXML
    private Button btnRetener2;
    @FXML
    private Button btnRetener3;
    @FXML
    private Button btnRetener4;
    @FXML
    private Button btnRetener5;
    @FXML
    private TextField txtApuesta;
    @FXML
    private TextField txtGanancia;
    @FXML
    private Button btnCobrar;
    @FXML
    private Button btnSeleccionApuesta;
    @FXML
    private Button btnApMax;
    @FXML
    private Button btnRepartir;
    @FXML
    private Button btnRestarCre;
    @FXML
    private Button btnSumarCre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void RetenerCarta1(ActionEvent event) {
    }

    @FXML
    private void RetenerCarta2(ActionEvent event) {
    }

    @FXML
    private void RetenerCarta3(ActionEvent event) {
    }

    @FXML
    private void RetenerCarta4(ActionEvent event) {
    }

    @FXML
    private void RetenerCarta5(ActionEvent event) {
    }

    @FXML
    private void SleccionarApuesta(ActionEvent event) {
    }

    @FXML
    private void SeleccionarApuestaMax(ActionEvent event) {
    }

    @FXML
    private void RepartirCartas(ActionEvent event) {
    }

    @FXML
    private void RestarCreditos(ActionEvent event) {
    }

    @FXML
    private void SumarCreditos(ActionEvent event) {
    }
    
}
