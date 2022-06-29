package com.zupedu.bancodigital.cadastrarProposta;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Proposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nomeCompleto;

    @NotBlank
    @CPF
    private String cpf;

    @NotBlank
    @Email
    private String email;

    @Embedded
    private @Valid @NotNull Endereco endereco;

    public Proposta(@NotBlank String nomeCompleto,
                    @NotBlank @CPF String cpf,
                    @NotBlank @Email String email,
                    @Valid @NotNull Endereco endereco) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.email = email;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }
}
