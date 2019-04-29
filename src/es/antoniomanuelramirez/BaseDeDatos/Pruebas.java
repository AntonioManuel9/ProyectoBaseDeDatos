/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.antoniomanuelramirez.BaseDeDatos;

import basededatos.entities.Equipo;
import java.util.List;
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
        List<Equipo> listEquipo = queryEquipo.getResultList();
        
        for(Equipo Equipo : listEquipo) {
        System.out.println(Equipo.getNombre());
        }
        // Modificación de objetos
        Query queryEquipoEscSur = em.createNamedQuery("Equipo.findByNombre");
        queryEquipoEscSur.setParameter("nombre", "Esc. Sur");
        List<Equipo> listEquipoEscSur = queryEquipoEscSur.getResultList();
        em.getTransaction().begin();
        
        for(Equipo EquipoEscSur : listEquipoEscSur) {
            EquipoEscSur.setEscudo("5");
            em.merge(EquipoEscSur);
        }
        em.getTransaction().commit();
        
        //Eliminación de objetos
        Equipo equipoId1 = em.find(Equipo.class, 2);
        if(equipoId1 != null) {
            em.remove(equipoId1);
        } else {
            System.out.println("No hay ningun equipo con ID=1");
        }
    }
    
}
