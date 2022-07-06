/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Medicamento;
import br.edu.ifsul.modelo.Receituario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Elias Dalvite
 */
public class TestePersistirMedicamentos {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Hospital-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Receituario r = em.find(Receituario.class, 8);
        Medicamento m = em.find(Medicamento.class, 1);
        
        r.getMedicamentos().add(m);
        
        /*Usuario u = em.find(Usuario.class, "jorgebavaresco");
        Permissao pusuario = em.find(Permissao.class, "USUARIO");
        Permissao padmin = em.find(Permissao.class, "ADMINISTRADOR");
        u.getPermissoes().add(padmin);
        u.getPermissoes().add(pusuario);*/
        
        em.getTransaction().begin();
        em.persist(r);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
    }
}
