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
    
    public void cargarTabla(){
        for(vehiculo cargar : pila){
            if(cargar.comprador.equals(LoginController.nom)){
                CarritoController.tablist.add(cargar);
            }
        }
    }
    
    public float valorTotal(){
        float total = 0;
        for(vehiculo v : pila){
            if(v.comprador.equals(LoginController.nom)){
                total += v.precio;
            }
        }
        return total;
    }
    
    public void eliminarProducto (int id){
        for(vehiculo elim : pila){
            if(elim.id == id && elim.comprador.equals(LoginController.nom)){
                pila.remove(elim);
                CarritoController.tablist.remove(elim);
                JOptionPane.showMessageDialog(null,"Producto eliminado"); 
                break;
            }
        }
    }
    
    public void comprarProducto (int id){
        for(vehiculo comprar : pila){
            if(comprar.id == id && comprar.comprador.equals(LoginController.nom)){
                PrincipalController.cola.añadirProducto(comprar);
                pila.remove(comprar);
                CarritoController.tablist.remove(comprar);
                JOptionPane.showMessageDialog(null,"Producto comprado!"); 
                break;
            }
        }
    }
    
    public void comprarTodo(){
        Stack<vehiculo> nuevaPila = new Stack<>();
        while(!pila.isEmpty()){
            vehiculo elem = pila.pop();
            if (!elem.comprador.equals(LoginController.nom)){
                nuevaPila.push(elem);
            }else{
                PrincipalController.cola.añadirProducto(elem);
            }
        }
        while(!nuevaPila.isEmpty()){
            pila.push(nuevaPila.pop());
        }
        JOptionPane.showMessageDialog(null, "Se compraron todos los productos");
    }
}
