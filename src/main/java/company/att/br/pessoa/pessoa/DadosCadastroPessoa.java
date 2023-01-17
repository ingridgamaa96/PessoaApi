package company.att.br.pessoa.pessoa;

import company.att.br.pessoa.endereco.DadosEndereco;
import jakarta.validation.Valid;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record DadosCadastroPessoa(

        Long id,

        @NotBlank
        String nome,

        LocalDate dataNascimento,
        @NotNull @Valid
        DadosEndereco endereco) {
}
