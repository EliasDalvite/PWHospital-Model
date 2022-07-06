/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Elias Dalvite
 */
@Entity
@Table(name="paciente")
@Inheritance(strategy = InheritanceType.JOINED)
public class Paciente implements Serializable{
    
    @Id
    @SequenceGenerator(name="seq_paciente", sequenceName = "seq_paciente_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_paciente", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Length(max = 30, message = "O nome nao pode ter mais que {max} caracteres")
    @NotBlank(message = "O nome nao pode ficar em branco")
    @Column(name = "nome", nullable = false, length = 30)
    private String nome;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "O nascimento deve ser informado")
    @Column(name = "nascimento", nullable = false)
    private Calendar nascimento;
       
    @NotNull(message = "O telefone deve ser informado")
    @Length(max = 15, message = "O numero nao pode ter mais que {max} caracteres")
    @Column(name = "telefone", nullable = false, length = 15)
    private String telefone;
       
    @NotNull(message = "O sexo deve ser informado")
    @Length(max = 10, message = "O sexo nao pode ter mais que {max} caracteres")
    @Column(name = "sexo", nullable = false, length = 10)
    private String sexo;
    
    @Length(message = "O histórico deve ser informado!")
    @NotBlank(message = "O historico nao pode ficar em branco")
    @Column(name = "historico", nullable = false)
    private String historico;
    
    @NotNull(message = "O peso deve ser informado")
    @Column(name = "peso", nullable = false, columnDefinition = "numeric(6,3)")
    private Double peso;
    
    @NotNull(message = "A altura deve ser informada")
    @Column(name = "altura", nullable = false, columnDefinition = "numeric(4,2)")
    private Double altura;
    
    public Paciente(){
        
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

    public Calendar getNascimento() {
        return nascimento;
    }

    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.id);
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
        final Paciente other = (Paciente) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
