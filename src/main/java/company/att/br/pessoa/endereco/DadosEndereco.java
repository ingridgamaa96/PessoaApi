package company.att.br.pessoa.endereco;
import company.att.br.pessoa.pessoa.Pessoa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
public record DadosEndereco(

        Long id,
        Pessoa pessoa ,
        @NotBlank
        String logradouro,
        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String cep,
        @NotBlank
        String numero ,
        @NotBlank
        String cidade) {


}


