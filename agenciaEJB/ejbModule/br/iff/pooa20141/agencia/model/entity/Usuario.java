package br.iff.pooa20141.agencia.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	private String email;

	private String nome;

	private String senha;

	//bi-directional many-to-one association to Pacote
	@OneToMany(mappedBy="usuarioBean")
	private List<Pacote> pacotes;

	//bi-directional many-to-one association to Qualificacaohotel
	@OneToMany(mappedBy="usuarioBean")
	private List<Qualificacaohotel> qualificacaohotels;

	//bi-directional many-to-one association to Qualificacaopassagem
	@OneToMany(mappedBy="usuarioBean")
	private List<Qualificacaopassagem> qualificacaopassagems;

	public Usuario() {
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Pacote> getPacotes() {
		return this.pacotes;
	}

	public void setPacotes(List<Pacote> pacotes) {
		this.pacotes = pacotes;
	}

	public Pacote addPacote(Pacote pacote) {
		getPacotes().add(pacote);
		pacote.setUsuarioBean(this);

		return pacote;
	}

	public Pacote removePacote(Pacote pacote) {
		getPacotes().remove(pacote);
		pacote.setUsuarioBean(null);

		return pacote;
	}

	public List<Qualificacaohotel> getQualificacaohotels() {
		return this.qualificacaohotels;
	}

	public void setQualificacaohotels(List<Qualificacaohotel> qualificacaohotels) {
		this.qualificacaohotels = qualificacaohotels;
	}

	public Qualificacaohotel addQualificacaohotel(Qualificacaohotel qualificacaohotel) {
		getQualificacaohotels().add(qualificacaohotel);
		qualificacaohotel.setUsuarioBean(this);

		return qualificacaohotel;
	}

	public Qualificacaohotel removeQualificacaohotel(Qualificacaohotel qualificacaohotel) {
		getQualificacaohotels().remove(qualificacaohotel);
		qualificacaohotel.setUsuarioBean(null);

		return qualificacaohotel;
	}

	public List<Qualificacaopassagem> getQualificacaopassagems() {
		return this.qualificacaopassagems;
	}

	public void setQualificacaopassagems(List<Qualificacaopassagem> qualificacaopassagems) {
		this.qualificacaopassagems = qualificacaopassagems;
	}

	public Qualificacaopassagem addQualificacaopassagem(Qualificacaopassagem qualificacaopassagem) {
		getQualificacaopassagems().add(qualificacaopassagem);
		qualificacaopassagem.setUsuarioBean(this);

		return qualificacaopassagem;
	}

	public Qualificacaopassagem removeQualificacaopassagem(Qualificacaopassagem qualificacaopassagem) {
		getQualificacaopassagems().remove(qualificacaopassagem);
		qualificacaopassagem.setUsuarioBean(null);

		return qualificacaopassagem;
	}

}