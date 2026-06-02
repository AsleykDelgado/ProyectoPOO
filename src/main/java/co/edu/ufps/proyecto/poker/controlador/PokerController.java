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
import javafx.scene.control.TextArea;
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
    private boolean primerJ = true;
    @FXML
    private TextArea txtMensaje;
    @FXML
    private Button btnDoblarJugada;
    @FXML
    private Button btnReiniciar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        txtCreditos.setText("0");
        juego = new JuegoPoker(Integer.parseInt(txtCreditosApostados.getText()), Integer.parseInt(txtCreditos.getText()));
        juego.IniciarJuego();
        
        imagenes = new ImageView[] {imgCarta1, imgCarta2, imgCarta3, imgCarta4, imgCarta5};
        txtMensaje.setText("BIENVENIDO A VIDEOPOKER. DIGITE SUS CREDITOS.");
        
    }    
    
    @FXML
    private void RepartirCartas(ActionEvent event) {
        
        if (primerJ) {
            juego.repartirCartas();
            primerJ = false;
            txtMensaje.setText("TIENE LA OPORTUNIDAD DE CAMBIAR SUS CARTAS SOLO UNA VEZ.");
        } else {
            juego.cambiarCartas();
            primerJ = true;
            btnRepartir.setDisable(true);
        }
        mostrarMano();
    }
    
    private void mostrarMano () {
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
        
        if (cre< 5) {
        cre++;
        txtCreditosApostados.setText(cre +"");
        }
    }
    
    @FXML
    private void SleccionarApuesta(ActionEvent event) {
        
        if (txtCreditos.getText().equals("") || txtCreditosApostados.getText().equals(null)) {
            txtMensaje.setText("DEBE INGRESAR LOS CREDITOS SOLICITADOS. ");
        } else {
        txtMensaje.clear();
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
        
        // en el mensaje de apuesta, mostramos los creditos apostados
        txtApuesta.setText(txtCreditosApostados.getText());
        }
    }

    @FXML
    private void SeleccionarApuestaMax(ActionEvent event) {
        
        if (txtCreditos.getText().equals("") || txtCreditosApostados.getText().equals(null)) {
            txtMensaje.setText("DEBE INGRESAR LOS CREDITOS SOLICITADOS. ");
        } else {
            txtMensaje.clear();
        txtCreditosApostados.setText("5");
        txtApuesta.setText("5");
        txtMensaje.setText("SOLO PUEDE APOSTAR 5 CREDITOS POR CADA JUGADA.");
        }
    }

    @FXML
    private void RetenerCarta1(ActionEvent event) {
        juego.getMano().cambiarRetenida(0);
        
        if (juego.getMano().estaRete(0)) {
            btnRetener1.setText("RETENIDA");
        } else {
            btnRetener1.setText("RETENER");
        }
    }

    @FXML
    private void RetenerCarta2(ActionEvent event) {
        juego.getMano().cambiarRetenida(1);
        
        if (juego.getMano().estaRete(1)) {
            btnRetener2.setText("RETENIDA");
        } else {
            btnRetener2.setText("RETENER");
        }
    }

    @FXML
    private void RetenerCarta3(ActionEvent event) {
        juego.getMano().cambiarRetenida(2);
        
        if (juego.getMano().estaRete(2)) {
            btnRetener3.setText("RETENIDA");
        } else {
            btnRetener3.setText("RETENER");
        }
    }

    @FXML
    private void RetenerCarta4(ActionEvent event) {
        juego.getMano().cambiarRetenida(3);
        
        if (juego.getMano().estaRete(3)) {
            btnRetener4.setText("RETENIDA");
        } else {
            btnRetener4.setText("RETENER");
        }
    }

    @FXML
    private void RetenerCarta5(ActionEvent event) {
        juego.getMano().cambiarRetenida(4);
        
        if (juego.getMano().estaRete(4)) {
            btnRetener5.setText("RETENIDA");
        } else {
            btnRetener5.setText("RETENER");
        }
    }


    @FXML
    private void CobrarDinero(ActionEvent event) {
        int pago = juego.calcularPremio();
        int cre = Integer.parseInt(txtCreditos.getText());
        txtMensaje.setText("SU JUGADA ES: " + juego.evaluarMano());
        txtGanancia.setText(String.valueOf(pago));
        
        if (pago>0) {
            int resto = cre+pago;
            txtCreditos.setText(String.valueOf(resto));
        } if (pago==0) {
            int apos = Integer.parseInt(txtCreditosApostados.getText());
            int res = cre- apos;
            txtCreditos.setText(String.valueOf(res));
        }
    }

    @FXML
    private void doblarJugada(ActionEvent event) {
    }

    @FXML
    private void reiniciarJuego(ActionEvent event) {
        
        juego.reiniciar();
        txtCreditos.setText(String.valueOf(juego.getCreditos()));
        txtApuesta.setText("0");
        txtGanancia.setText("0");
        txtCreditosApostados.setText("");
        txtMensaje.clear();

        for (ImageView img : imagenes) {
            img.setImage(null);
        }
    }
    
}
