package company.att.br.pessoa.repository;

import company.att.br.pessoa.pessoa.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PessoaRepository extends JpaRepository<Pessoa,Long> {


}