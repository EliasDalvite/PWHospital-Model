package br.edu.ifsul.utilrelatorios;

import br.edu.ifsul.modelo.Paciente;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Elias Dalvite
 */
public class FabricaObjetos {

    public static List<Paciente> carregaPacientes(){
        List<Paciente> lista = new ArrayList<>();
        
        Paciente p = new Paciente();
        p.setId(1);
        p.setNome("Marta");
        p.setHistorico("Diabética");
        p.setNascimento(Calendar.getInstance());
        p.setAltura(1.65);
        p.setPeso(59.3);
        p.setSexo("Feminino");
        p.setTelefone("54996153451");
        
        lista.add(p);
        return lista;
    }
}
