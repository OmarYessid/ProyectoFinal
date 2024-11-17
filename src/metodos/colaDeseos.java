/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodos;

import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JOptionPane;

/**
 *
 * @author Omar
 */
public class colaDeseos {
    public static Queue<vehiculo> cola;
    
    public colaDeseos(){
        this.cola = new LinkedList<>();
    }
    
    public Queue<vehiculo> get_deseos() {
        return cola;
    }
    
    public void agregarProducto(vehiculo prod) {
        boolean existe = false;

        for (vehiculo p : cola) {
            if (p.getNombre().equals(prod.getNombre()) && p.comprador.equals(LoginController.nom)) {  
                JOptionPane.showMessageDialog(null, "Este producto ya se encuentra en deseos");
                existe = true;
            }
        }

        if (!existe && prod.comprador.equals(LoginController.nom)) {
            cola.add(prod);
            JOptionPane.showMessageDialog(null, "Producto agregado a deseos: " + prod.getNombre());
        }
    }
    
    public void cargarTabla(){
        for(vehiculo cargar : cola){
            if(cargar.comprador.equals(LoginController.nom)){
                CarritoController.tablist.add(cargar);
            }
        }
    }
    
    public void eliminarProducto (int id){
        for(vehiculo elim : cola){
            if(elim.id == id && elim.comprador.equals(LoginController.nom)){
                cola.remove(elim);
                CarritoController.tablist.remove(elim);
                JOptionPane.showMessageDialog(null,"Producto eliminado"); 
                break;
            }
        }
    }
    
    public void comprarProducto (int id){
        for(vehiculo comprar : cola){
            if(comprar.id == id && comprar.comprador.equals(LoginController.nom)){
                PrincipalController.cola.añadirProducto(comprar);
                cola.remove(comprar);
                CarritoController.tablist.remove(comprar);
                JOptionPane.showMessageDialog(null,"Producto comprado!"); 
                break;
            }
        }
    }
    
    public void comprarTodo(){
        for(vehiculo comprar : cola){         
            if (comprar.comprador.equals(LoginController.nom)){
                PrincipalController.cola.añadirProducto(comprar);
                cola.remove(comprar);
            }
        }
        JOptionPane.showMessageDialog(null, "Se compraron todos los productos");
    }
}
