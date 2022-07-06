/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Consulta;
import br.edu.ifsul.modelo.Medico;
import br.edu.ifsul.modelo.Paciente;
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
public class TestePersistirConsulta {
    
    public static void main(String[] args) throws ParseException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Hospital-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sdf.parse("24-03-1998"));
        
        SimpleDateFormat sdfh = new SimpleDateFormat("HH-mm-ss");
        Calendar hora = Calendar.getInstance();
        hora.setTime(sdfh.parse("15-10-15"));
        
        Consulta c = new Consulta();
        c.setData(calendar);
        c.setHora(hora);
            c.setPaciente(em.find(Paciente.class, 4));
        c.setPreconsulta("Texto PREconsulta2");
        c.setPosconsulta("Texto POSconsulta2");
        c.setMedico(em.find(Medico.class, 14));
                
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
