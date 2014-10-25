package br.iff.pooa20141.agencia.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the agencia database table.
 * 
 */
@Entity
@NamedQuery(name="Agencia.findAll", query="SELECT a FROM Agencia a")
public class Agencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	private String cnpj;

	private String email;

	private String nome;

	//bi-directional many-to-one association to Qualificacaopassagem
	@OneToMany(mappedBy="agenciaBean")
	private List<Qualificacaopassagem> qualificacaopassagems;

	//bi-directional many-to-one association to Reservapassagem
	@OneToMany(mappedBy="agenciaBean")
	private List<Reservapassagem> reservapassagems;

	public Agencia() {
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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

	public List<Qualificacaopassagem> getQualificacaopassagems() {
		return this.qualificacaopassagems;
	}

	public void setQualificacaopassagems(List<Qualificacaopassagem> qualificacaopassagems) {
		this.qualificacaopassagems = qualificacaopassagems;
	}

	public Qualificacaopassagem addQualificacaopassagem(Qualificacaopassagem qualificacaopassagem) {
		getQualificacaopassagems().add(qualificacaopassagem);
		qualificacaopassagem.setAgenciaBean(this);

		return qualificacaopassagem;
	}

	public Qualificacaopassagem removeQualificacaopassagem(Qualificacaopassagem qualificacaopassagem) {
		getQualificacaopassagems().remove(qualificacaopassagem);
		qualificacaopassagem.setAgenciaBean(null);

		return qualificacaopassagem;
	}

	public List<Reservapassagem> getReservapassagems() {
		return this.reservapassagems;
	}

	public void setReservapassagems(List<Reservapassagem> reservapassagems) {
		this.reservapassagems = reservapassagems;
	}

	public Reservapassagem addReservapassagem(Reservapassagem reservapassagem) {
		getReservapassagems().add(reservapassagem);
		reservapassagem.setAgenciaBean(this);

		return reservapassagem;
	}

	public Reservapassagem removeReservapassagem(Reservapassagem reservapassagem) {
		getReservapassagems().remove(reservapassagem);
		reservapassagem.setAgenciaBean(null);

		return reservapassagem;
	}

}