package company.att.br.pessoa.controller;
import company.att.br.pessoa.pessoa.DadosCadastroPessoa;
import company.att.br.pessoa.pessoa.Pessoa;
import company.att.br.pessoa.repository.PessoaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("pessoas")

public class PessoaController {
    @Autowired
    private PessoaRepository pessoaRepository;


    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastroPessoa dados){

        pessoaRepository.save(new Pessoa(dados));
    }

    @GetMapping("/listar")
    public List<Pessoa> listar(){
        return pessoaRepository.findAll();
    }

    @GetMapping({"/id"})
    public ResponseEntity<Pessoa> pessoa (@RequestParam("id")Long id){
        return ResponseEntity.ok().build();
    }

    @PutMapping("/editar")
    public ResponseEntity<Pessoa> editar(@RequestParam Long id , @RequestBody Pessoa dadosPessoa){
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        if(!pessoa.isPresent()){
            return (ResponseEntity<Pessoa>) ResponseEntity.badRequest();
        }
        pessoa.get().setNome(dadosPessoa.getNome());
        pessoa.get().setDataNascimento(dadosPessoa.getDataNascimento());

        return ResponseEntity.ok(pessoaRepository.save(pessoa.get()));

    }
    
}

















