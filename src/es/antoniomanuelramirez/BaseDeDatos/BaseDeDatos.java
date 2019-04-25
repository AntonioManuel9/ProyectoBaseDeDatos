/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.antoniomanuelramirez.BaseDeDatos;

import basededatos.entities.Equipo;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Antonio Manuel
 */
public class BaseDeDatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         // Conectar con la base de datos
        Map<String, String> emfProperties = new HashMap<String, String>();
        emfProperties.put("javax.persistence.schema-generation.database.action", "create");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BaseDeDatosPU", emfProperties);
        EntityManager em = emf.createEntityManager();
        
        // REALIZAR AQUÍ LAS OPERACIONES SOBRE LA BASE DE DATOS
        // Iniciamos una transcion para introucir valores en la base de datos
        Equipo equipoEscuderiaUbrique = new Equipo(0, "Esc. Ubrique");
        Equipo equipoEscuderiaSur = new Equipo(0, "Esc. Sur");
        
        em.getTransaction().begin();
        em.persist(equipoEscuderiaUbrique);
        em.persist(equipoEscuderiaSur);
        em.getTransaction().commit();
        
        // Cerrar la conexión con la base de datos
        em.close(); 
        emf.close(); 
        try { 
            DriverManager.getConnection("jdbc:derby:BDProyecto;shutdown=true"); 
        } catch (SQLException ex) { 
        }
    }
    
}
