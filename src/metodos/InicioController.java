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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Omar
 */
public class InicioController implements Initializable {
    
    @FXML
    private Button registrarse, iniciar;
    
    @FXML
    private StackPane stack;
    
    private VBox log, reg;
    
    @FXML
    private void actionEvent(ActionEvent e){
        
        Object evt = e.getSource();
        
        if(evt.equals(iniciar)){
            log.setVisible(true);
            reg.setVisible(false);
        }else if(evt.equals(registrarse)){
            log.setVisible(false);
            reg.setVisible(true);
        }
        
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            log = LoadForm("/metodos/login.fxml");
            reg = LoadForm("/metodos/registro.fxml");
            stack.getChildren().addAll(log, reg);
            
            log.setVisible(true);
            reg.setVisible(false);
            
        } catch (IOException ex) {
            Logger.getLogger(InicioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO
    }
    private VBox LoadForm(String url) throws IOException{
        return (VBox)FXMLLoader.load(getClass().getResource(url));
    } 
        
}
