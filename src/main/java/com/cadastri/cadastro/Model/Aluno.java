package com.cadastri.cadastro.Model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Entity
@Data
public class Aluno {

    private static final long serialVersionUIDLONG = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank
    @NotNull
    private String nome;

    @NotBlank
    @NotNull
    private String rg;

    @NotBlank
    @NotNull
    private String dataNascimento;
}
