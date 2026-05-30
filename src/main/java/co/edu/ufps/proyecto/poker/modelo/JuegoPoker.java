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
public class JuegoPoker {
    
    private ArrayList<Carta> mazo = new ArrayList<>();
    
    
    public void CrearMazo () {
        
        String[] palos = {"C", "D", "E", "T"};
        String[] nombres = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        
        for (String palo : palos) {
            for (String nombre : nombres) {
                String ruta = "/co/edu/ufps/proyecto/poker/images/" + palo + "-" + nombre + ".jpg";
                mazo.add(new Carta(palo, nombre, ruta));
            }
        }
        
    }
    
    public void BarajearMazo() {
        Collections.shuffle(mazo);
    }
    
    public void RepartirCartas() {
        
    }
    
    
}
