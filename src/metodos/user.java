/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodos;

/**
 *
 * @author Omar
 */
public class user {
    String nombre, contraseña;
    user sig;

    public user(String nombre, String contraseña) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        sig = null;
    }
}
