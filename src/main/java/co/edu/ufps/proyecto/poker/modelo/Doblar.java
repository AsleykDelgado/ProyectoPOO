/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.ufps.proyecto.poker.modelo;

/**
 *
 * @author HP
 */
public class Doblar {
    
    private Carta visible;
    private Carta[] ocultas;
    private int premio;

    public Doblar(int premio) {
        this.premio = premio;
        ocultas = new Carta[4];
    }
    
    public int obtenerValor (Carta carta) {
        String nombre = carta.getNumero();
        
        switch (nombre) {
            case "A":
                return 14;
            case "K":
                return 13;
            case "Q":
                return 12;
            case "J":
                return 11;
        }
        return Integer.parseInt(nombre);
    }
    
    public int evaluar (Carta selec, Carta visi, int apuesta) {
        int total = apuesta;
        int numsele = obtenerValor(selec);
        int numvisi = obtenerValor(visi);
        
        if (numsele>numvisi) {
            return total *= 2;
        }
        return 0;
    }

    public Carta getVisible() {
        return visible;
    }

    public void setVisible(Carta visible) {
        this.visible = visible;
    }

    public Carta[] getOcultas() {
        return ocultas;
    }

    public void setOcultas(Carta[] ocultas) {
        this.ocultas = ocultas;
    }

    public int getPremio() {
        return premio;
    }

    public void setPremio(int premio) {
        this.premio = premio;
    }
    
    
}
