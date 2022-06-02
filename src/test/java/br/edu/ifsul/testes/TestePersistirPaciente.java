/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

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
public class TestePersistirPaciente {
    
    public static void main(String[] args) throws ParseException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Hospital-ModelPU");
        EntityManager em = emf.createEntityManager();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sdf.parse("24-03-1998"));
        Paciente p = new Paciente();
        p.setNome("Marta");
        p.setNascimento(calendar);
        p.setSexo("Feminino");
        p.setAltura(1.63);
        p.setPeso(50.8);
        p.setTelefone("996854589");
        p.setHistorico("Nenhum");
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
