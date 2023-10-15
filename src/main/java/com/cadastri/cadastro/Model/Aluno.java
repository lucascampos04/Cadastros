package com.cadastri.cadastro.Model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;


@Entity
@Data
public class Aluno {

    private static final long serialVersionUIDLONG = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank
    private String nome;

    @NotBlank
    @CPF
    private String rg;

    @jakarta.validation.constraints.NotBlank
    private String cpf;

    @NotBlank
    private String dataNascimento;
}
