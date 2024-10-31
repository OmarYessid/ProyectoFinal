/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package metodos;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Omar
 */
public class ProductosController implements Initializable {
    
    public static int id1, id2, id3;
    public static String nom1, nom2, nom3;
    public static Image ima1, ima2, ima3;
    public static float p1, p2, p3;
    
    @FXML
    private Label lb1,lb2,lb3, precio1, precio2, precio3;
    
    @FXML
    private ImageView img1, img2, img3;
    
    @FXML
    private Button btnBack, btnCarrito, btnHistorial, btnCar1, btnCar2, btnCar3, btnCom1, btnCom2, btnCom3;
;
    
    public void actionEvent (ActionEvent e){
        Object evt = e.getSource();
        
        if(evt.equals(btnBack)){
            loadStage("/metodos/principal.fxml", e);
        }
        if(evt.equals(btnCarrito)){
            loadStage("/metodos/Carrito.fxml", e);
        }
        if(evt.equals(btnHistorial)){
            loadStage("/metodos/Historial.fxml", e);
        }
        if(evt.equals(btnCar1)){
            vehiculo v = new vehiculo(id1, nom1, PrincipalController.marca, p1, LoginController.nom);
            PrincipalController.pila.setPushProductos(v);
        }
        if(evt.equals(btnCar2)){
            vehiculo v = new vehiculo(id2, nom2, PrincipalController.marca, p2, LoginController.nom);
            PrincipalController.pila.setPushProductos(v);
        }
        if(evt.equals(btnCar3)){
            vehiculo v = new vehiculo(id3, nom3, PrincipalController.marca, p3, LoginController.nom);
            PrincipalController.pila.setPushProductos(v);
        }
        if(evt.equals(btnCom1)){
            vehiculo v = new vehiculo(id1, nom1, PrincipalController.marca, p1, LoginController.nom);
            PrincipalController.cola.añadirProducto(v);
            JOptionPane.showMessageDialog(null, "Producto comprado exitosamente!");
        }
        if(evt.equals(btnCom2)){
            vehiculo v = new vehiculo(id2, nom2, PrincipalController.marca, p2, LoginController.nom);
            PrincipalController.cola.añadirProducto(v);
            JOptionPane.showMessageDialog(null, "Producto comprado exitosamente!");
        }
        if(evt.equals(btnCom3)){
            vehiculo v = new vehiculo(id3, nom3, PrincipalController.marca, p3, LoginController.nom);
            PrincipalController.cola.añadirProducto(v);
            JOptionPane.showMessageDialog(null, "Producto comprado exitosamente!");
        }
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lb1.setText(nom1);
        img1.setImage(ima1);
        lb2.setText(nom2);
        img2.setImage(ima2);
        lb3.setText(nom3);
        img3.setImage(ima3);
        precio1.setText(Float.toString(p1)+ " USD");
        precio2.setText(Float.toString(p2)+ " USD");
        precio3.setText(Float.toString(p3)+ " USD");
        // TODO
    }    
    
    private void loadStage(String url, Event event){
        
        try {
            Object eventSource = event.getSource();
            Node sourceAsNode = (Node) eventSource;
            Scene oldScene = sourceAsNode.getScene();
            Window window = oldScene.getWindow();
            Stage stage = (Stage) window;
            stage.hide();
            
            Parent root = FXMLLoader.load(getClass().getResource(url));
            Scene scene = new Scene(root);
            Stage newStage = new Stage();
            newStage.setScene(scene);
            newStage.show();
            
            newStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    Platform.exit();
                }
            });
        }catch ( IOException ex){
            Logger.getLogger(ProductosController.class.getName()).log(Level.SEVERE,null, ex);
        }
        
    }
    
}
