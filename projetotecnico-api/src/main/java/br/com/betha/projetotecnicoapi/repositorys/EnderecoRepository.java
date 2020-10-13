package br.com.betha.projetotecnicoapi.repositorys;

import br.com.betha.projetotecnicoapi.modules.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco,Long> {
}
