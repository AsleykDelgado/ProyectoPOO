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
    private Button btnReiniciar;
    @FXML
    private Button btnVolver;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        txtCreditos.setText("0");
        txtCreditosApostados.setText("0");
        
        juego = new JuegoPoker(0, 0);
        juego.IniciarJuego();
        
        imagenes = new ImageView[] {imgCarta1, imgCarta2, imgCarta3, imgCarta4, imgCarta5};
        txtMensaje.setText("BIENVENIDO A VIDEOPOKER. DIGITE SUS CREDITOS.");
        
    }    
    
    @FXML
    private void RepartirCartas(ActionEvent event) {
        
        if (primerJ) {
            try {
                juego.repartirCartas();
            } catch (PokerException e) {
                txtMensaje.setText("ERROR AL REPARTIR: \n" + e.getMessage());
                return;
            }
            primerJ = false;
            txtMensaje.setText("TIENE LA OPORTUNIDAD DE CAMBIAR SUS CARTAS SOLO UNA VEZ.");
        } else {
            try {
                juego.cambiarCartas();
            } catch (PokerException e) {
                txtMensaje.setText("ERROR AL CAMBIAR LAS CARTAS: \n" + e.getMessage());
                return;
            }
            primerJ = true;
            btnRepartir.setDisable(true);
            btnCobrar.setDisable(false);
        }
        
            btnRetener1.setDisable(false);
            btnRetener2.setDisable(false);
            btnRetener3.setDisable(false);
            btnRetener4.setDisable(false);
            btnRetener5.setDisable(false);
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
        
        if (txtCreditos.getText().equals("") || txtCreditosApostados.getText().equals("0")) {
            txtMensaje.setText("DEBE INGRESAR LOS CREDITOS SOLICITADOS. ");
            return;
        } 
        // verificamos para que no ingresen letras en lugar de numeros con try catch
        int credi;
        int apos;
        
        try {
            credi = Integer.parseInt(txtCreditos.getText());
            apos  = Integer.parseInt(txtCreditosApostados.getText());
        } catch (NumberFormatException e) {
            txtMensaje.setText("ERROR: SOLO PUEDE INGRESAR NUMEROS. \n - "+ txtCreditos.getText() + "- NO ES VALIDO");
            txtCreditos.clear();
            txtCreditosApostados.setText("0");
            txtCreditos.setEditable(true);
            return;
        }
        
        //verificamos que no ingrese numeros negativos
        if (credi<= 0) {
            txtMensaje.setText("LOS CREDITOS DEBEN SER MAYORES A 0");
            txtCreditos.clear();
            return;
        }
        if (credi < apos) {
            txtMensaje.setText("SALDO INSUFICIENTE. SU SALDO ES " + credi
                + " CRÉDITOS Y SU APUESTA ES " + apos + " CRÉDITOS. REDUZCA SU APUESTA.");
        
            return;
    }
        txtMensaje.clear();
        
        btnApMax.setDisable(true);
        btnSeleccionApuesta.setDisable(true);
        btnRestarCre.setDisable(true);
        btnSumarCre.setDisable(true);
        btnRepartir.setDisable(false);
        txtCreditos.setEditable(false);
        
        // en el mensaje de apuesta, mostramos los creditos apostados
        txtApuesta.setText(txtCreditosApostados.getText());
        txtCreditos.setText(String.valueOf(credi - apos));
        
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
        
        
        int apuesta = Integer.parseInt(txtCreditosApostados.getText());
        juego.setCreditosApos(apuesta);

        int pago = juego.calcularPremio();
        int creditosActuales = Integer.parseInt(txtCreditos.getText());

        txtMensaje.setText("SU JUGADA ES: " + juego.evaluarMano());
        txtGanancia.setText(String.valueOf(pago));

        int saldoFinal = creditosActuales + pago;

        txtCreditos.setText(String.valueOf(saldoFinal));
        
        btnCobrar.setDisable(true);
        btnRetener1.setText("RETENER");
        btnRetener1.setDisable(true);
        btnRetener2.setText("RETENER");
        btnRetener2.setDisable(true);
        btnRetener3.setText("RETENER");
        btnRetener3.setDisable(true);
        btnRetener4.setText("RETENER");
        btnRetener4.setDisable(true);
        btnRetener5.setText("RETENER");
        btnRetener5.setDisable(true);
    }


    @FXML
    private void reiniciarJuego(ActionEvent event) {
        
        btnApMax.setDisable(false);
        btnCobrar.setDisable(true);
        btnRepartir.setDisable(true);
        btnRestarCre.setDisable(false);
        btnSumarCre.setDisable(false);
        btnSeleccionApuesta.setDisable(false);
        btnRetener1.setDisable(true);
        btnRetener2.setDisable(true);
        btnRetener3.setDisable(true);
        btnRetener4.setDisable(true);
        btnRetener5.setDisable(true);
        
        
        juego.reiniciar();
        juego.IniciarJuego();
        txtCreditos.clear();
        txtCreditos.setEditable(true);
        txtApuesta.setText("0");
        txtGanancia.setText("0");
        txtCreditosApostados.setText("0");
        txtMensaje.clear();

        for (ImageView img : imagenes) {
            img.setImage(null);
        }
    }

    @FXML
    private void volverJugar(ActionEvent event) {
        btnApMax.setDisable(false);
        btnCobrar.setDisable(true);
        btnRepartir.setDisable(true);
        btnRestarCre.setDisable(false);
        btnSumarCre.setDisable(false);
        btnSeleccionApuesta.setDisable(false);
        btnRetener1.setDisable(true);
        btnRetener2.setDisable(true);
        btnRetener3.setDisable(true);
        btnRetener4.setDisable(true);
        btnRetener5.setDisable(true);
        
        
        juego.reiniciar();
        juego.IniciarJuego();
        txtCreditos.setEditable(true);
        txtApuesta.setText("0");
        txtGanancia.setText("0");
        txtCreditosApostados.setText("0");
        txtMensaje.setText("VUELVE A JUGAR. \n" + "TUS CREDITOS SIGUEN SIENDO LOS MISMOS. ");

        for (ImageView img : imagenes) {
            img.setImage(null);
        }
    }
    
}
