/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.ufps.proyecto.poker.modelo;


import co.edu.ufps.proyecto.poker.modelo.*;
/**
 *
 * @author HP
 */
public class JuegoPoker {
     
    private Mazo mazo;
    private Jugador jugador;
    private Mano mano;
    private Pago pago;    

    public JuegoPoker() {
        mazo = new Mazo();
        mano = new Mano();
    }
    
    
    public void IniciarJuego() {
        mazo = new Mazo();
        mazo.crearMazo();
        mazo.barajearMazo();
    }
    
    public void repartirCartas() {
        mano.limpiar();
    
        for (int i = 0; i < 5; i++) {
            mano.agregarCarta(i, mazo.repartirCarta());
    }
    }
    
    public void cambiarCartas() {
    }
    
    public void evaluarMano () {
        
    }
    
    public void calcularPremio() {
        
    }
    
    public void reiniciar () {
        
    }

    public Mazo getMazo() {
        return mazo;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public Mano getMano() {
        return mano;
    }

    public Pago getPago() {
        return pago;
    }
    
    
}
