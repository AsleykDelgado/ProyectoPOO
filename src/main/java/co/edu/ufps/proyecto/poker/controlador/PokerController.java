/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package co.edu.ufps.proyecto.poker.controlador;

import co.edu.ufps.proyecto.poker.modelo.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

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
    
    private JuegoPoker juego;
    private ImageView [] imagenes;
    private Text txtmensaj;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        juego = new JuegoPoker();
        juego.IniciarJuego();
        
        imagenes = new ImageView[] {imgCarta1, imgCarta2, imgCarta3, imgCarta4, imgCarta5};
        
    }    
    
    @FXML
    private void RepartirCartas(ActionEvent event) {
        
        juego.repartirCartas();
        MostrarMano();
        
    }
    
    private void MostrarMano () {
        Carta[] cartas = juego.getMano().getCartas();
        
        for (int i=0; i<5; i++) {
            if (cartas[i]!= null) {
                Image imagen = new Image(getClass().getResourceAsStream(cartas[i].getImagen()));
                imagenes[i].setImage(imagen);
            }
        }
    }
    
    

    @FXML
    private void RestarCreditos(ActionEvent event) {
        int cre = Integer.parseInt(txtCreditosApostados.getText());
        
        if (cre!=0) {
            cre--;
            txtCreditosApostados.setText(cre+ "");
        }
    }

    @FXML
    private void SumarCreditos(ActionEvent event) {
        int cre = Integer.parseInt(txtCreditosApostados.getText());
        int apos = Integer.parseInt(txtCreditos.getText());
        
        if (cre< apos) {
        cre++;
        txtCreditosApostados.setText(cre +"");
        }
    }
    
    @FXML
    private void SleccionarApuesta(ActionEvent event) {
        
        btnCobrar.setDisable(false);
        btnRepartir.setDisable(false);
        btnRetener1.setDisable(false);
        btnRetener2.setDisable(false);
        btnRetener3.setDisable(false);
        btnRetener4.setDisable(false);
        btnRetener5.setDisable(false);
        
        btnApMax.setDisable(true);
        btnSeleccionApuesta.setDisable(true);
        btnRestarCre.setDisable(true);
        btnSumarCre.setDisable(true);
        
        txtCreditos.setEditable(false);
        
    }

    @FXML
    private void SeleccionarApuestaMax(ActionEvent event) {
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
    private void CobrarDinero(ActionEvent event) {
    }
    
}
