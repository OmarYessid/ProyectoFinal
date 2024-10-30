/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodos;

import java.util.Stack;
import javax.swing.JOptionPane;

/**
 *
 * @author Omar
 */
public class pilaCarrito {
    
    public static Stack<vehiculo> pila;
    
    public pilaCarrito(){
        this.pila = new Stack();
    }
    
    public void setPushProductos (vehiculo p){
        pila.push(p);
        JOptionPane.showMessageDialog(null,"Agregado al carrito exitosamente!");   
    }
    public void eliminarProducto (String nom){
        for(vehiculo elim : pila){
            if(elim.nombre.equals(nom)){
                pila.remove(elim);
            }
        }
    }
}
