/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.ufps.proyecto.poker.modelo;


import co.edu.ufps.proyecto.poker.modelo.*;
import java.util.ArrayList;
/**
 *
 * @author HP
 */
public class JuegoPoker {
     
    private Mazo mazo;
    private Jugador jugador;
    private Mano mano;
    private Pago pago; 
    private EvaluadorMano eval;
    private int creditos;
    private int creditosApos;

    public JuegoPoker(int creditosApos, int creditos) {
        mazo = new Mazo();
        mano = new Mano();
        eval = new EvaluadorMano();
        pago = new Pago();
        jugador = new Jugador("Jugador", creditosApos, creditos);
        this.creditosApos = creditosApos;
        this.creditos = creditos;
    }
    
    
    public void IniciarJuego() {
        mazo = new Mazo();
        mazo.crearMazo();
        mazo.barajearMazo();
        
    }
    
    public void repartirCartas() throws PokerException{
        mano.limpiar();
    
        for (int i = 0; i < 5; i++) {
            Carta c = mazo.repartirCarta();
            mano.agregarCarta(i, c);
    }
        jugador.setMano(mano);
    }
    
    public void cambiarCartas() throws PokerException{
        for (int i = 0; i < 5; i++) {

            if (!mano.estaRete(i)) {
                Carta a = mazo.repartirCarta(); //aqui es donde lanza alguna exception
                mano.agregarCarta(i, a);
            }
        }
    }
    
    public String evaluarMano () {
        Carta[] cartas = mano.getCartas();
        
        if (eval.esEscaleraReal(cartas)) {
            return "ESCALERA REAL DE COLOR. ";
        } if (eval.esEscaleraColor(cartas)) {
            return "ESCALERA DE COLOR. ";
        } if (eval.esPoker(cartas)) {
            return "POKER. ";
        } if (eval.esFull(cartas)) {
            return "FULL. ";
        } if (eval.esColor(cartas)) {
            return "COLOR. ";
        } if (eval.esEscalera(cartas)) {
            return "ESCALERA. ";
        } if (eval.esTrio(cartas)) {
            return "TRIO. ";
        } if (eval.esDoblePar(cartas)) {
            return "DOBLE PAREJA. ";
        } if (eval.esPar(cartas)) {
            return "PAREJA DE JOTAS O MEJOR. ";
        }
        return "NINGUNA JUGADA. ";
    }
    
    public int calcularPremio() {
        int premio = pago.calcular(mano.getCartas(), creditosApos);
        jugador.cobrarGanancia(premio);
        return premio;
    }
    
    public void reiniciar () {
        mano.limpiar();
        
        creditosApos = 0;
        
        mazo = new Mazo();
        mazo.crearMazo();
        mazo.barajearMazo();
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

    public EvaluadorMano getEval() {
        return eval;
    }

    public void setEval(EvaluadorMano eval) {
        this.eval = eval;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getCreditosApos() {
        return creditosApos;
    }

    public void setCreditosApos(int creditosApos) {
        this.creditosApos = creditosApos;
    }
    
    
    
}
