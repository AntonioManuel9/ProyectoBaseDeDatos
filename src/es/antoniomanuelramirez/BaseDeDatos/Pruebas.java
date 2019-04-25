/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.antoniomanuelramirez.BaseDeDatos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Antonio Manuel
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BaseDeDatosPU");
        EntityManager em = emf.createEntityManager();
        
        Query queryEquipo = em.createNamedQuery("Equipo.findAll");
    }
    
}
