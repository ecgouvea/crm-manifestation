package br.com.crm.manifestation.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.crm.manifestation.entity.Manifestacao;
import br.com.crm.manifestation.entity.TipoContato;

/**
 * @author DavidBen
 *
 */
@Repository
public interface ManifestacaoRepository extends CrudRepository<Manifestacao, Long> {

	Page<Manifestacao> findByTipoContato(TipoContato tipoContato, Pageable pageable);
	
	Page<Manifestacao> findByMotivoContato(TipoContato MotivoContato, Pageable pageable);
	
	Page<Manifestacao> findByCpf(String cpf, Pageable pageable);

}
