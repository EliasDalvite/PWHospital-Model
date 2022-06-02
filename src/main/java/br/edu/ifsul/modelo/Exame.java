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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Elias Dalvite
 */
@Entity
@Table(name = "exame")
public class Exame implements Serializable{
    
    @Id
    @SequenceGenerator(name="seq_exame", sequenceName = "seq_exame_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_exame", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Length(max = 30, message = "O nome nao pode ter mais que {max} caracteres")
    @NotBlank(message = "O nome nao pode ficar em branco")
    @Column(name = "nome", nullable = false, length = 30)
    private String nome;
    
    @Length(max = 50, message = "A descricao não pode ter mais que {max} caracteres")
    @NotBlank(message = "A descricao nao pode ficar em branco")
    @Column(name = "descricao", nullable = false, length = 50)
    private String descricao;
    
    @ManyToOne
    @NotNull(message = "A consulta deve ser informada")
    @JoinColumn(name = "consulta", referencedColumnName = "id", nullable = false)
    private Consulta consulta;

    public Exame(){
        
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final Exame other = (Exame) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
