/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name="receituario")
public class Receituario implements Serializable{
    
    @Id
    @SequenceGenerator(name="seq_receituario", sequenceName = "seq_receituario_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_receituario", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "A dosagem deve ser informada")
    @NotBlank(message = "A dosagem nao pode ficar em branco")
    @Column(name = "posologia", nullable = false)
    private String posologia;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A validade deve ser informada")
    @NotBlank(message = "A validade nao pode ficar em branco")
    @Column(name = "validade", nullable = false)
    private Calendar validade;
    
    @ManyToMany
    /*@JoinTable(name = "medicamento_receituario",
            joinColumns = @JoinColumn(name = "posologia", referencedColumnName = "posologia", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "medicamento", referencedColumnName = "nome", nullable = false))*/
    private Set<Medicamento> medicamentos = new HashSet<>();
    
    @ManyToOne
    @NotNull(message = "A consulta deve ser informada")
    @JoinColumn(name = "consulta", referencedColumnName = "id", nullable = false)
    private Consulta consulta;
    
    public Receituario(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPosologia() {
        return posologia;
    }

    public void setPosologia(String posologia) {
        this.posologia = posologia;
    }

    public Calendar getValidade() {
        return validade;
    }

    public void setValidade(Calendar validade) {
        this.validade = validade;
    }

    public Set<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(Set<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
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
        final Receituario other = (Receituario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
}
