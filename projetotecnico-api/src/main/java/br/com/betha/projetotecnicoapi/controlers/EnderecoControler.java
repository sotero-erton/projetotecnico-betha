package br.com.betha.projetotecnicoapi.controlers;

import br.com.betha.projetotecnicoapi.modules.Endereco;
import br.com.betha.projetotecnicoapi.repositorys.EnderecoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/endereco")
public class EnderecoControler {

    private EnderecoRepository repository;

    public EnderecoControler(EnderecoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Endereco> findAll() {
        return this.repository.findAll();
    }

    @PostMapping("add")
    public Endereco save(Endereco endereco) {
        return this.repository.save(endereco);
    }

    @DeleteMapping("/{id}")
    public Endereco delete(@PathVariable(name = "id") Long id) {
        Endereco endereco = repository.findById(id).orElse(null);

        if (endereco == null) {
            throw new RuntimeException("Endereço ID" + id + " não foi encontrado!!!");
        }

        this.repository.deleteById(id);

        return endereco;
    }

    @GetMapping("/{id}")
    public Endereco find(@PathVariable(name = "id") Long id) {

        Optional<Endereco> optional = this.repository.findById(id);

        if (optional.isPresent()) {

            return optional.get();

        } else {
            throw new RuntimeException("Endereco ID = " + id + " não encontrado!!!");
        }
    }

}
