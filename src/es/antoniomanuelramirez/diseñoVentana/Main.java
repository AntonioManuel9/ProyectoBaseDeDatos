/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.antoniomanuelramirez.diseñoVentana;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Antonio Manuel
 */
public class Main extends Application {
    private EntityManagerFactory emf;
    private EntityManager em;
    
    @Override
    public void start(Stage primaryStage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML.diseñoVentana.fxml"));
    Parent root = fxmlLoader.load();

    emf = Persistence.createEntityManagerFactory("BaseDeDatosPU");
    em = emf.createEntityManager();
    diseñoVentanaController diseñoVentanaController = (diseñoVentanaController) fxmlLoader.getController();       
    }

    @Override
    public void stop() throws Exception {
        em.close(); 
        emf.close(); 
    try { 
        DriverManager.getConnection("jdbc:derby:BDProyecto;shutdown=true"); 
    } catch (SQLException ex) { 
    }  
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
