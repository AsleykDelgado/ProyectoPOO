/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.ufps.proyecto.poker.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 *
 * @author HP
 */
public class EvaluadorMano {
    
    private int valorNumero (Carta carta) {
        switch (carta.getNumero()) {
            case "A":
                return 14;
            case "K":
                return 13;
            case "Q":
                return 12;
            case "J":
                return 11;
            default: 
                return Integer.parseInt(carta.getNumero());
        }
        
    }
    private HashMap<Integer,Integer> contarValores(Carta[] mano) {

    HashMap<Integer,Integer> conteo = new HashMap<>();

    for(Carta carta : mano) {

        int valor = valorNumero(carta);

        if(conteo.containsKey(valor)) {
            conteo.put(valor, conteo.get(valor) + 1);
        } else {
            conteo.put(valor, 1);
        }
    }

    return conteo;

    }
    
    
    public boolean esPar(Carta[] mano){
        
        HashMap<Integer,Integer> conteo = contarValores(mano);

        for(Integer valor : conteo.keySet()){

          if(conteo.get(valor) == 2 && valor >= 11){
            return true;
          }
        }

         return false;
    }
    
    public boolean esDoblePar(Carta[] mano){
        
        HashMap<Integer,Integer> conteo = contarValores(mano);

        int pares = 0;

        for(int cantidad : conteo.values()){

         if(cantidad == 2){
            pares++;
         }
        }

        return pares == 2;
    }
    
    public boolean esTrio(Carta[] mano){
        
        HashMap<Integer,Integer> conteo = contarValores(mano);

        for(int cantidad : conteo.values()){

         if(cantidad == 3){
            return true;
         }
        }

        return false;
    }
    
    public boolean esEscalera(Carta[] mano){
        
        ArrayList<Integer> valores = new ArrayList<>();

    for (Carta carta : mano) {
        valores.add(valorNumero(carta));
    }

    Collections.sort(valores);

    // Caso especial: A-2-3-4-5
    if (valores.get(0) == 2 &&
        valores.get(1) == 3 &&
        valores.get(2) == 4 &&
        valores.get(3) == 5 &&
        valores.get(4) == 14) {

        return true;
    }

    // Escalera normal
    for (int i = 0; i < valores.size() - 1; i++) {

        if (valores.get(i + 1) != valores.get(i) + 1) {
            return false;
        }
    }

    return true;

    }
    
    public boolean esColor(Carta[] mano){
        
        String pinta = mano[0].getPinta();

        for(Carta carta : mano){

         if(!carta.getPinta().equals(pinta)){
            return false;
         }
        }

        return true;
    }
    
    public boolean esFull(Carta[] mano){
        
        HashMap<Integer,Integer> conteo = contarValores(mano);

        boolean trio = false;
        boolean par = false;

        for(int cantidad : conteo.values()){

         if(cantidad == 3){
            trio = true;
         }

         if(cantidad == 2){
            par = true;
         }
        }

        return trio && par;
    }
    
    public boolean esPoker(Carta[] mano){
        
        HashMap<Integer,Integer> conteo = contarValores(mano);

        for(int cantidad : conteo.values()){

         if(cantidad == 4){
            return true;
         }
        }

        return false;
        
    }
    
    public boolean esEscaleraColor(Carta[] mano){
        return esEscalera(mano) && esColor(mano);
    }
    
    public boolean esEscaleraReal(Carta[] mano){
        
        if(!esColor(mano)){
         return false;
        }

        ArrayList<Integer> valores = new ArrayList<>();
 
        for(Carta carta : mano){
         valores.add(valorNumero(carta));
        }

        Collections.sort(valores);

        return valores.get(0) == 10 &&
               valores.get(1) == 11 &&
               valores.get(2) == 12 &&
               valores.get(3) == 13 &&
               valores.get(4) == 14;
  }
}
