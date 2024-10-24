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
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author Omar
 */
public class PrincipalController implements Initializable {
    
    @FXML
    private Button btn1,btn2,btn3, btnClose, btnCarrito, btnHistorial;
    
    public void actionEvent (ActionEvent e){
        Object evt = e.getSource();
        if(evt.equals(btn1)){
            loadStage("/metodos/productos.fxml", e);
        }
        if(evt.equals(btn2)){
            loadStage("/metodos/productos.fxml", e);
        }
        if(evt.equals(btn3)){
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
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE,null, ex);
        }
        
    }
    
}
