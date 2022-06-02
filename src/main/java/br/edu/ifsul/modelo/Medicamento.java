/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Elias Dalvite
 */
@Entity
@Table(name="medicamento")
public class Medicamento implements Serializable{
    
    @Id
    @SequenceGenerator(name="seq_medicamento", sequenceName = "seq_medicamento_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_medicamento", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Length(max = 30, message = "O nome nao pode ter mais que {max} caracteres")
    @NotBlank(message = "O nome nao pode ficar em branco")
    @Column(name = "nome", nullable = false, length = 30)
    private String nome;
    
    public Medicamento(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final Medicamento other = (Medicamento) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
