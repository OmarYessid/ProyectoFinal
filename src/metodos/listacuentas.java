/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodos;

import javax.swing.JOptionPane;

/**
 *
 * @author Omar
 */
public class listacuentas {
    public static user cab;
    
    public listacuentas () { cab=null; }
    
    public user buscarnom(String user){
        user p = cab;
        if(cab == null)
            return null;
        else{
            while (p != null){
                if ((p.nombre).equals(user))
                    return p;
                else
                    p=p.sig;
            }
            return null;
        }
    }
    
    public user crearnodo (String nombre, String contraseña){
        user info, p;
        String nom;
        if (nombre.equals("") || contraseña.equals("")){
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
            return null;
        }else{
            do{
                nom = nombre;
                p = buscarnom(nom);
                if(p != null){
                    JOptionPane.showMessageDialog(null, "Ya existe una cuenta con ese nombre, ingrese uno diferente!");
                    return null;
                }
            }while(p != null);
            if(p == null){
                info = new user(nom, contraseña);
                JOptionPane.showMessageDialog(null, "Registro exitoso!");
                return info;
            }else{
                return null;
            }
        }
    }
    
    public void crearcuenta(String nombre, String contraseña){
        user info = crearnodo(nombre, contraseña);
        if(cab != null){
            info.sig = cab;
            cab = info;
        }else{
            cab = info;
        }
    }
    
    public user logcuenta(String nombre, String contraseña){
        user p = cab;
        if(cab == null)
            return null;
        else{
            while(p != null){
                if((p.nombre).equals(nombre) && (p.contraseña).equals(contraseña))
                    return p;
                else
                    p=p.sig;
            }
            return null;
        }
    }
    
}
