package br.com.betha.projetotecnicoapi.controlers;

import br.com.betha.projetotecnicoapi.modules.Telefone;
import br.com.betha.projetotecnicoapi.repositorys.TelefoneRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/telefone")
public class TelefoneControler {

    private TelefoneRepository repository;

    public TelefoneControler(TelefoneRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Telefone> findAll() {
        return this.repository.findAll();
    }

    @PostMapping("add")
    public Telefone save(Telefone telefone) {
        return this.repository.save(telefone);
    }

    @DeleteMapping("/{id}")
    public Telefone delete(@PathVariable(name = "id") Long id) {
        Telefone telefone = this.repository.findById(id).orElse(null);

        if (telefone == null) {
            throw new RuntimeException("Telefone ID = " + id + " não encontrado!!!");
        }
        this.repository.deleteById(id);

        return telefone;
    }

    @GetMapping("/{id}")
    public Telefone find(@PathVariable(name = "id") Long id) {

        Optional<Telefone> optional = this.repository.findById(id);

        if (optional.isPresent()) {

            return optional.get();

        } else {
            throw new RuntimeException("Telefone ID = " + id + " não encontrado!!!");
        }
    }

}
