/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.ufps.proyecto.poker.modelo;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author HP
 */
public class Mazo {
    
    private ArrayList<Carta> mazo = new ArrayList<>();
    
    public void crearMazo () {
        
        String[] palos = {"C", "D", "E", "T"};
        String[] nombres = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        
        for (String palo : palos) {
            for (String nombre : nombres) {
                String ruta = "/co/edu/ufps/proyecto/poker/images/" + palo + "-" + nombre + ".jpeg";
                mazo.add(new Carta(palo, nombre, ruta));
            }
        }
        
    }
    
    public void barajearMazo() {
        Collections.shuffle(mazo);
    }
    
    public Carta repartirCarta () throws PokerException {
        if (mazo.isEmpty()) {
            throw new PokerException ("EL MAZO ESTA VACIO.");
        }
        return mazo.remove(0);
    }
    

    public ArrayList<Carta> getMazo() {
        return mazo;
    }

    public void setMazo(ArrayList<Carta> mazo) {
        this.mazo = mazo;
    }
    
    
}
