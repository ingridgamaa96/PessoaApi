package company.att.br.pessoa.endereco;

import company.att.br.pessoa.pessoa.Pessoa;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;

//@Embeddable
@Getter
@NoArgsConstructor

@Entity
@Table(name = "tb_endereco")
public class Endereco {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String logradouro;

    private String cep;
    private String numero;

    private String cidade;


    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    @ManyToOne
   // @JoinColumn(name="pessoa_id")
   // @JsonManagedReference
    private Pessoa pessoa ;
    private boolean EnderecoPrincipal;

    public boolean isEnderecoPrincipal() {
        return EnderecoPrincipal;
    }

    public void setEnderecoPrincipal(boolean enderecoPrincipal) {
        EnderecoPrincipal = enderecoPrincipal;
    }

    public Endereco(DadosEndereco dados) {
        this.logradouro = dados.logradouro();
        this.cep = dados.cep();
        this.numero = dados.numero();
        this.cidade = dados.cidade();
        this.pessoa = dados.pessoa();
        this.id= dados.id();
    }
}
