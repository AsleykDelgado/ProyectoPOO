/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.ufps.proyecto.poker.modelo;

/**
 *
 * @author HP
 */
public class Jugador {
    
    private String nombre;
    private double creditosApostar;
    private int saldoCredito;

    public Jugador(String nombre, double creditosApostar, int saldoCredito) {
        this.nombre = nombre;
        this.creditosApostar = creditosApostar;
        this.saldoCredito = saldoCredito;
    }
    
    public void realizarApuesta () {
        
        
        
    }
    
    public void descartarCartas () {
        
        
        
    }
    
    public void evaluarJugada () {
        
        
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCreditosApostar() {
        return creditosApostar;
    }

    public void setCreditosApostar(double creditosApostar) {
        this.creditosApostar = creditosApostar;
    }

    public int getSaldoCredito() {
        return saldoCredito;
    }

    public void setSaldoCredito(int saldoCredito) {
        this.saldoCredito = saldoCredito;
    }
    
    
    
    
}
