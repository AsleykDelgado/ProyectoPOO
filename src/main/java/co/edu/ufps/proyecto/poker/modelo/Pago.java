/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.ufps.proyecto.poker.modelo;

import java.util.Map;

/**
 *
 * @author HP
 */
public class Pago {
    
    private EvaluadorMano eval;

    public Pago() {
        eval = new EvaluadorMano();
    }
    
    public int calcular (Carta[] mano, int creditos) {
        
        if (eval.esEscaleraReal(mano)) return 250 * creditos;
        if (eval.esEscaleraColor(mano)) return 40 * creditos;
        if (eval.esPoker(mano)) return 20 * creditos;
        if (eval.esFull(mano)) return 9 * creditos;
        if (eval.esColor(mano)) return 6 * creditos;
        if (eval.esEscalera(mano)) return 5 * creditos;
        if (eval.esTrio(mano)) return 3 * creditos;
        if (eval.esDoblePar(mano)) return 2 * creditos;
        if (eval.esPar(mano)) return 1* creditos;
        
        else {
            return 0;
        }
    }

    
    
    
}
