package br.com.crm.manifestation.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "crm_manifestacao")
@TableGenerator(name = "crm_sequence", table = "crm_sequence", pkColumnName = "id_column", valueColumnName = "next_value", pkColumnValue = "id_manifestacao", allocationSize = 1)
public class Manifestacao implements Serializable {

	private static final long serialVersionUID = -6717385020358858601L;

	@Id
	@Column(name = "id_manifestacao", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "crm_sequence")
	private Long idManifestacao;
	
	private String protocolo;
	
	private String cpf;
	
	private String nome;
	
	private String email;
	
	private String telefone;
	
	private String celular;
	
	private Date dataCriacao = new Date();
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_contato")
	private TipoContato tipoContato;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "motivo_contato")
	private MotivoContato motivoContato;
	
	private String mensagem;

	public Long getIdManifestacao() {
		return idManifestacao;
	}

	public void setIdManifestacao(Long idManifestacao) {
		this.idManifestacao = idManifestacao;
	}

	public String getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(String protocolo) {
		this.protocolo = protocolo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public TipoContato getTipoContato() {
		return tipoContato;
	}

	public void setTipoContato(TipoContato tipoContato) {
		this.tipoContato = tipoContato;
	}

	public MotivoContato getMotivoContato() {
		return motivoContato;
	}

	public void setMotivoContato(MotivoContato motivoContato) {
		this.motivoContato = motivoContato;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
}
