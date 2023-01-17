package company.att.br.pessoa.repository;

import company.att.br.pessoa.endereco.Endereco;
import company.att.br.pessoa.pessoa.Pessoa;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EnderecoRepository extends JpaRepository <Endereco, Long> {

    List<Endereco> findBypessoa(Pessoa pessoa);
    List<Endereco> findBypessoaId(Long IdPessoa);

}

