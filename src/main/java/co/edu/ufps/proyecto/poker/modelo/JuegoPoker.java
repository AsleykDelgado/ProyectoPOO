/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.ufps.proyecto.poker.modelo;

import java.util.Random;

/**
 *
 * @author HP
 */
public class JuegoPoker {
    
    private Carta [] mazo;
    
    public void CrearMazo () {
        
        String[] palos = {"C", "D", "E", "T"};
        String[] nombres = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        int[] valores =   {11, 2, 3, 4, 5, 6, 7, 8, 9,10,10,10,10};
        
        //la constante k empieza en 0, para recorrer todas las 52 cartas
        int k = 0;

        for (int i = 0; i < palos.length; i++) {
                  for (int j = 0; j < nombres.length; j++) {
                      
                      //aqui esta la ruta de las imagenes, para que la vista muestre esas imagenes
            String ruta = "/co/edu/ufps/proyecto/poker/images/" + palos[i] + "-" + nombres[j] + ".jpg";
            
            //la carta se guarda cuando ya se unen los palos y los numeros, con su respectiva imagen
            mazo[k] = new Carta(palos[i], nombres[j], valores[j], ruta);
            k++;
        }
    }
    }
    
    public void BarajearMazo() {
        Random r = new Random();
         // con este for, lo que hacemos es recorrer todas las 52 cartas
        for (int i = 0; i < mazo.length; i++) {
            int pos = r.nextInt(52);
// una carta en aleatorio toma la posicon 0, otra la pos 1 y asi, para queden en total desorden
// asi se dan al jugador

            Carta aux = mazo[i];
            mazo[i] = mazo[pos];
            mazo[pos] = aux;
        }
    }
    
    
    
}
