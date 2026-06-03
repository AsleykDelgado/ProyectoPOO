/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.ufps.proyecto.poker.modelo;

/**
 *
 * @author HP
 */
public class PokerException extends Exception{
    
    //son errores especificos de las reglas del juego
   public PokerException (String mensaje) {
       //le dice a exception, que en lugar de mostrar el error, muestre un mensaje
       super(mensaje);
   }
    
}
