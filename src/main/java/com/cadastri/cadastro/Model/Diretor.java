package com.cadastri.cadastro.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class Diretor {

    private static final long serialVersionUIDLONG = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank
    private String nomeCompleto;
    @NotBlank
    private String dataNascimento;
    @NotBlank
    private String genero;
    @NotBlank
    private String rg;
    @NotBlank
    private String cpf;
    @NotBlank
    private String endereco;
    @NotBlank
    private String email;
    @NotBlank
    private String formacaoAcademica;

}
