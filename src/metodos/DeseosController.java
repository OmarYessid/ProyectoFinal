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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Omar
 */
public class DeseosController implements Initializable {
    
    @FXML
    private TableView<vehiculo> tabla;
    @FXML
    private TableColumn<vehiculo, String> id;
    @FXML
    private TableColumn<vehiculo, String> nom;
    @FXML
    private TableColumn<vehiculo, String> mar;
    @FXML
    private TableColumn<vehiculo, String> pre;
    
    public static ObservableList<vehiculo> tablist = FXCollections.observableArrayList();
    
    @FXML
    private Button btnBack, btnCarrito, btnHistorial, btnEliminar, btnComprarI, btnDeseos;
    
    public void actionEvent (ActionEvent e){
        Object evt = e.getSource();
        if(evt.equals(btnEliminar)){
            int id = tabla.getSelectionModel().getSelectedItem().getId();
            PrincipalController.cola2.eliminarProducto(id);
            tablist.clear();
            PrincipalController.cola2.cargarTabla();
        }
        if(evt.equals(btnComprarI)){
            int id = tabla.getSelectionModel().getSelectedItem().getId();
            PrincipalController.cola2.comprarProducto(id);
            tablist.clear();
            PrincipalController.cola2.cargarTabla();
        }
        if(evt.equals(btnHistorial)){
            tablist.clear();
            loadStage("/metodos/Historial.fxml", e);
        }
        if(evt.equals(btnCarrito)){
            loadStage("/metodos/Carrito.fxml", e);
        }
        if(evt.equals(btnBack)){
            tablist.clear();
            loadStage("/metodos/principal.fxml", e);
        }
        if(evt.equals(btnDeseos)){
            JOptionPane.showMessageDialog(null, "Ya se encuentra en la pagina de deseos!");
        }
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        PrincipalController.cola2.cargarTabla();
        id.setCellValueFactory(new PropertyValueFactory<vehiculo, String>("id"));
        nom.setCellValueFactory(new PropertyValueFactory<vehiculo, String>("nombre"));
        mar.setCellValueFactory(new PropertyValueFactory<vehiculo, String>("marca"));
        pre.setCellValueFactory(new PropertyValueFactory<vehiculo, String>("precio"));
        tabla.setItems(tablist);
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
            Logger.getLogger(CarritoController.class.getName()).log(Level.SEVERE,null, ex);
        }     
    }
}
