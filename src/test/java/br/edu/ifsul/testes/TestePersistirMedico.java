/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Especialidade;
import br.edu.ifsul.modelo.Medico;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Elias Dalvite
 */
public class TestePersistirMedico {
    
    public static void main(String[] args) throws ParseException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Hospital-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sdf.parse("02-11-1974"));
        
        Medico m = new Medico();
        m.setNome("Pietro");
        m.setTelefone("996458752");
        m.setSexo("Masculino");
        m.setHistorico("Varias Cirurgias Cardiovasculares");
        m.setNascimento(calendar);
        m.setPeso(89.8);
        m.setAltura(1.8);
        m.setCrm("34353-RS");
        m.setEspecialidade(em.find(Especialidade.class, 2));
        
        em.getTransaction().begin();
        em.persist(m);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
