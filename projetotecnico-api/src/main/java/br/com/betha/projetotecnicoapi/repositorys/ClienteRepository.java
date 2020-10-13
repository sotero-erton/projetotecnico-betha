package br.com.betha.projetotecnicoapi.repositorys;

import br.com.betha.projetotecnicoapi.modules.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
