package br.com.crm.manifestation.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.crm.manifestation.entity.Manifestacao;
import br.com.crm.manifestation.repository.ManifestacaoRepository;
import br.com.crm.manifestation.util.ResponseEntityUtil;

/**
 * @author DavidBen
 *
 */
@RestController
@RequestMapping("/manifestations")
public class ManifestacaoController {

	@Autowired
	private ManifestacaoRepository manifestacaoRepository;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@Valid @RequestBody Manifestacao m) {
		RestTemplate restTemplate = new RestTemplate();
        String  protocolo = restTemplate.getForObject("http://crm-protocol:8181/protocols/new", String.class);
		m.setProtocolo(protocolo);
		m = manifestacaoRepository.save(m);
		return ResponseEntityUtil.created("idManifestacao", m.getIdManifestacao());
	}
	
	@RequestMapping(value = "/{idManifestacao}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@PathVariable("idManifestacao") Long idManifestacao, @Valid @RequestBody Manifestacao m) {
		m.setIdManifestacao(idManifestacao);
		m = manifestacaoRepository.save(m);
		return ResponseEntityUtil.noContent();
	}
	
	@RequestMapping(value = "/{idManifestacao}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long idManifestacao) {
		manifestacaoRepository.delete(idManifestacao);
		return ResponseEntityUtil.noContent();
	}
	
	@RequestMapping(value = "/{idManifestacao}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Long idManifestacao)  {
		Manifestacao m = manifestacaoRepository.findOne(idManifestacao);
		return ResponseEntityUtil.ok(m, 0L);
	}
	
}
