/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Elias Dalvite
 */
@Entity
@Table(name = "medico")
public class Medico extends Paciente implements Serializable{

    @NotNull(message = "O CRM deve ser informado")
    @Length(max = 8, message = "O CRM não pode ter mais que {max} caracteres")
    @NotBlank(message = "O CRM nao pode ficar em branco")
    @Column(name = "crm", nullable = false, length = 8)
    private String crm;
    
    @ManyToOne
    @NotNull(message = "A especialidade deve ser informado")
    @JoinColumn(name = "especialidade", referencedColumnName = "id", nullable = false)
    private Especialidade especialidade;
    
    public Medico(){
        
    }
    
    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }
}
