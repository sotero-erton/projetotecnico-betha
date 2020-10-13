package br.com.betha.projetotecnicoapi.repositorys;

import br.com.betha.projetotecnicoapi.modules.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefoneRepository extends JpaRepository<Telefone,Long> {
}
