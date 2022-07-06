/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Elias Dalvite
 */
@Entity
@Table(name = "consulta")
public class Consulta implements Serializable{
    
    @Id
    @SequenceGenerator(name="seq_consulta", sequenceName = "seq_consulta_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_consulta", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data deve ser informada")
    @Column(name = "data", nullable = false)
    private Calendar data;
    
    @NotBlank(message = "A preconsulta nao pode ficar em branco")
    @Column(name = "preconsulta", nullable = false)
    private String preconsulta;
    
    @NotBlank(message = "A posconsulta nao pode ficar em branco")
    @Column(name = "posconsulta", nullable = false)
    private String posconsulta;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A hora deve ser informada")
    @Column(name = "hora", nullable = false)
    private Calendar hora;  
    
    @ManyToOne
    @NotNull(message = "O paciente deve ser informado")
    @JoinColumn(name = "paciente", referencedColumnName = "id", nullable = false)
    private Paciente paciente;
    
    @ManyToOne
    @NotNull(message = "O Medico deve ser informado")
    @JoinColumn(name = "medico", referencedColumnName = "crm", nullable = false)
    private Medico medico;
    
    @OneToMany(mappedBy = "consulta", cascade = CascadeType.ALL, 
            orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Exame> exames = new ArrayList<>();
    
    @OneToMany(mappedBy = "consulta", cascade = CascadeType.ALL, 
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Receituario> receituarios = new ArrayList<>();
    
    public Consulta(){
        
    }

     public void adicionarExame(Exame obj){
        obj.setConsulta(this);
        this.exames.add(obj);
    }
    
    public void removerExame(int index){
        this.exames.remove(index);
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public String getPreconsulta() {
        return preconsulta;
    }

    public void setPreconsulta(String preconsulta) {
        this.preconsulta = preconsulta;
    }

    public String getPosconsulta() {
        return posconsulta;
    }

    public void setPosconsulta(String posconsulta) {
        this.posconsulta = posconsulta;
    }

    public Calendar getHora() {
        return hora;
    }

    public void setHora(Calendar hora) {
        this.hora = hora;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Consulta other = (Consulta) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public List<Exame> getExames() {
        return exames;
    }

    public void setExames(List<Exame> exames) {
        this.exames = exames;
    }

    public List<Receituario> getReceituarios() {
        return receituarios;
    }

    public void setReceituarios(List<Receituario> receituarios) {
        this.receituarios = receituarios;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
}
