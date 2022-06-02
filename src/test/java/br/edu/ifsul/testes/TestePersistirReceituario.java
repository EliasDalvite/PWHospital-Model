/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Consulta;
import br.edu.ifsul.modelo.Receituario;
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
public class TestePersistirReceituario {
    
    public static void main(String[] args) throws ParseException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Hospital-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sdf.parse("30-04-2025"));
        
        Receituario r = new Receituario();
        r.setConsulta(em.find(Consulta.class, 3));
        r.setPosologia("Adulto: 10 a 15mg/dose, intervalos de 4 a 6 horas, não exceda 50-75mg em 24 horas. Crianças: Consultar o médico antes do uso.");
        r.setValidade(calendar);
                
        em.getTransaction().begin();
        em.persist(r);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
