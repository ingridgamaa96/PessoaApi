package company.att.br.pessoa.controller;
import company.att.br.pessoa.endereco.Endereco;
import company.att.br.pessoa.pessoa.Pessoa;
import company.att.br.pessoa.repository.EnderecoRepository;
import company.att.br.pessoa.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("endereco")
public class EnderecoController {
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @PostMapping("cadastrar")
    public ResponseEntity<Endereco> cadastrarEndereco(@RequestParam Long idPessoa, @RequestBody Endereco endereco ){
        Optional<Pessoa> pessoa = pessoaRepository.findById(idPessoa);
        if(!pessoa.isPresent()){
           return (ResponseEntity<Endereco>) ResponseEntity.badRequest();
        }
        var enderecosPessoa = enderecoRepository.findBypessoaId(idPessoa);

        if(enderecosPessoa.size() > 0){
            endereco.setEnderecoPrincipal(false);
        }else
            endereco.setEnderecoPrincipal(true);

        endereco.setPessoa(pessoa.get());
        return ResponseEntity.ok(enderecoRepository.save(endereco));
    }

    @GetMapping("{id}listar")
    public List<Endereco> listaEndereco(@RequestParam Long id) {
        Pessoa pessoa = pessoaRepository.findById(id).get();
        return enderecoRepository.findBypessoa(pessoa);
    }
}