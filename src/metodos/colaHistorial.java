/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodos;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Omar
 */
public class colaHistorial {
    
    public static Queue<vehiculo> cola;
    
    public colaHistorial(){
        this.cola = new LinkedList<>();
    }
    
    public void añadirProducto(vehiculo p){
        cola.add(p);
        System.out.println(cola.peek());
    }
    public void cargarCola(){
        for(vehiculo cargar : cola){
            if(cargar.comprador.equals(LoginController.nom)){
                HistorialController.tablist.add(cargar);
            }
        }
    }
}
