package company.att.br.pessoa.pessoa;

import company.att.br.pessoa.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( name = "tb_pessoa")
public class Pessoa {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDate dataNascimento;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<Endereco> endereco) {
        this.endereco = endereco;
    }
    @OneToMany
    @JoinTable(name = "tb_endereco", joinColumns = @JoinColumn(name="pessoa_id"),inverseJoinColumns = @JoinColumn(name = "id"))

   private List<Endereco> endereco = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Pessoa(DadosCadastroPessoa dados) {
        this.id = dados.id();

        this.nome = dados.nome();
        this.dataNascimento = dados.dataNascimento();
       // this.endereco = new Endereco(dados.endereco());
        this.endereco = new ArrayList<Endereco>();
    }
}
