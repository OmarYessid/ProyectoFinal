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
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author Omar
 */
public class PrincipalController implements Initializable {
    
    public static String marca;
    
    public static pilaCarrito pila = new pilaCarrito();
    
    public static colaHistorial cola = new colaHistorial();
    
    public static colaDeseos cola2 = new colaDeseos();
    
    @FXML
    private Button btn1,btn2,btn3, btnClose, btnCarrito, btnHistorial, btnDeseos;
    
    public void actionEvent (ActionEvent e){
        Object evt = e.getSource();
        if(evt.equals(btn1)){
            marca = "Ferrari";
            ProductosController.id1 = 1;
            ProductosController.id2 = 2;
            ProductosController.id3 = 3;
            ProductosController.nom1 = "Ferrari sf90";
            ProductosController.nom2 = "Ferrari Purosangue";
            ProductosController.nom3 = "Ferrari Roma";
            ProductosController.ima1 = new Image(getClass().getResource("/metodos/images/sf90.jpg").toExternalForm());
            ProductosController.ima2 = new Image(getClass().getResource("/metodos/images/purosangue.jpg").toExternalForm());
            ProductosController.ima3 = new Image(getClass().getResource("/metodos/images/roma.jpg").toExternalForm());
            ProductosController.p1 = 600000;
            ProductosController.p2 = 480000;
            ProductosController.p3 = 280000;
            loadStage("/metodos/productos.fxml", e);
        }
        if(evt.equals(btn2)){
            marca = "Lamborghini";
            ProductosController.id1 = 4;
            ProductosController.id2 = 5;
            ProductosController.id3 = 6;
            ProductosController.nom1 = "Lamborghini Aventador";
            ProductosController.nom2 = "Lamborghini Urus";
            ProductosController.nom3 = "Lamborghini Revuelto";
            ProductosController.ima1 = new Image(getClass().getResource("/metodos/images/aventador.jpg").toExternalForm());
            ProductosController.ima2 = new Image(getClass().getResource("/metodos/images/urus.jpg").toExternalForm());
            ProductosController.ima3 = new Image(getClass().getResource("/metodos/images/revuelto.jpg").toExternalForm());
            ProductosController.p1 = 500000;
            ProductosController.p2 = 258000;
            ProductosController.p3 = 604000;
            loadStage("/metodos/productos.fxml", e);
        }
        if(evt.equals(btn3)){
            marca = "McLaren";
            ProductosController.id1 = 7;
            ProductosController.id2 = 8;
            ProductosController.id3 = 9;
            ProductosController.nom1 = "McLaren P1";
            ProductosController.nom2 = "McLaren Senna";
            ProductosController.nom3 = "McLaren 765LT";
            ProductosController.ima1 = new Image(getClass().getResource("/metodos/images/p1.jpg").toExternalForm());
            ProductosController.ima2 = new Image(getClass().getResource("/metodos/images/senna.jpg").toExternalForm());
            ProductosController.ima3 = new Image(getClass().getResource("/metodos/images/765LT.jpg").toExternalForm());
            ProductosController.p1 = 1300000;
            ProductosController.p2 = 2500000;
            ProductosController.p3 = 465000;
            loadStage("/metodos/productos.fxml", e);
        }
        if(evt.equals(btnCarrito)){
            loadStage("/metodos/Carrito.fxml", e);
        }
        if(evt.equals(btnHistorial)){
            loadStage("/metodos/Historial.fxml", e);
        }
        if(evt.equals(btnClose)){
            loadStage("/metodos/inicio.fxml", e);
        }
        if(evt.equals(btnDeseos)){
            loadStage("/metodos/Deseos.fxml", e);
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE,null, ex);
        }
        
    }
    
}
