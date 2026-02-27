package br.com.barberpro.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroCliente(
    @NotBlank String nome,
    @NotBlank @Email String email,
    @NotBlank String senha
) {}