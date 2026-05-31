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

    public Mano() {
        cartas = new Carta[5];
    }
    
    public void agregarCarta (int posicion, Carta carta) {
        cartas[posicion] = carta;
    }
    
    public void limpiar () {
        for (int i =0; i<5; i++) {
            cartas[i] = null;
        }
    }

    public Carta[] getCartas() {
        return cartas;
    }


    
}
