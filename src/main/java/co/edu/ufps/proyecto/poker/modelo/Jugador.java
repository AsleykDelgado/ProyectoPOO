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
    private int creditosApostar;
    private int saldoCredito;
    private Mano mano = new Mano();

    public Jugador(String nombre, int creditosApostar, int saldoCredito) {
        this.nombre = nombre;
        this.creditosApostar = creditosApostar;
        this.saldoCredito = saldoCredito;
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

    public void setCreditosApostar(int creditosApostar) {
        this.creditosApostar = creditosApostar;
    }

    public int getSaldoCredito() {
        return saldoCredito;
    }

    public void setSaldoCredito(int saldoCredito) {
        this.saldoCredito = saldoCredito;
    }
    
    
    
    
}
