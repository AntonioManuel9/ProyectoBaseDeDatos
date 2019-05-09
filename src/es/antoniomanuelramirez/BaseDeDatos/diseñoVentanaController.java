/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.antoniomanuelramirez.BaseDeDatos;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Antonio Manuel
 */
public class diseñoVentanaController implements Initializable {

    @FXML
    private TableColumn<?, ?> columnNombre;
    @FXML
    private TableColumn<?, ?> columnApellidos;
    @FXML
    private TableColumn<?, ?> columnDNI;
    @FXML
    private TableColumn<?, ?> columnEquipo;
    @FXML
    private TableView<?> tableView;

    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        columnNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnApellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        columnDNI.setCellValueFactory(new PropertyValueFactory<>("dni"));
        columnEquipo.setCellValueFactory(new PropertyValueFactory<>("equipo"));
    }    
    
}
