package br.com.betha.projetotecnicoapi.controlers;

import br.com.betha.projetotecnicoapi.modules.Cliente;
import br.com.betha.projetotecnicoapi.repositorys.ClienteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/cliente")
public class ClienteControler {

    private ClienteRepository repository;

    public ClienteControler(ClienteRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Cliente> findAll()
    {
        return repository.findAll();
    }

    @PostMapping("add")
    public Cliente save(Cliente cliente)
    {
        return this.repository.save(cliente);
    }

    @DeleteMapping("/{id}")
    public Cliente delete(@PathVariable(name = "id") Long id) {

        Optional<Cliente> optional = this.repository.findById(id);

        if (optional.isPresent()) {

            Cliente cliente = optional.get();

            this.repository.deleteById(id);

            return cliente;

        } else {

            throw new RuntimeException("Cliente ID = " + id + " não encontrado!!!");

        }

    }

    @GetMapping("/{id}")
    public Cliente find(@PathVariable(name="id") Long id) {

        Optional<Cliente> optional = this.repository.findById(id);

        if (optional.isPresent()) {

            return optional.get();

        } else {
            throw new RuntimeException("Cliente ID = " + id + " não encontrado!!!");
        }
    }

}
