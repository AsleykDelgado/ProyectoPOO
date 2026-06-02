/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.ufps.proyecto.poker.modelo;

import java.util.ArrayList;


/**
 *
 * @author HP
 */
public class Mano {
    
    private Carta[] cartas;
    private boolean [] retenidas;

    public Mano() {
        cartas = new Carta[5];
        retenidas = new boolean [5];
    }
    
    public void agregarCarta (int posicion, Carta carta) {
        cartas[posicion] = carta;
    }
    
    // si la carta esta retenida osea es "True" va a psar a ser no retenida o sea "False"
    // en el vector de retenidas solo entran booleans, entonces o la carta en esa paosicon es false o true
    public void cambiarRetenida (int pos) {
        retenidas[pos] = !retenidas[pos];
    }
    
    //si es true la carta esta retenida, si es false no lo esta
    public boolean estaRete (int pos) {
        return retenidas[pos];
    }
    
    public void limpiar () {
        for (int i =0; i<5; i++) {
            cartas[i] = null;
            retenidas[i] = false;
        }
    }

    public Carta[] getCartas() {
        return cartas;
    }


    
}
