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
    
    private ArrayList<Carta> cartas;

    public Mano() {
        cartas = new ArrayList<>();
    }
    
    public void agregarCarta (Carta carta) {
        if (cartas.size() < 5) {
            cartas.add(carta);
        }
        
    }
    
    public void Limpiar () {
        cartas.clear();
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }
    
    
}
