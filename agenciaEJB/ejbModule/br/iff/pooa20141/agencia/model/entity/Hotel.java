package br.iff.pooa20141.agencia.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the hotel database table.
 * 
 */
@Entity
@NamedQuery(name="Hotel.findAll", query="SELECT h FROM Hotel h")
public class Hotel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	private String cidade;

	private String cnpj;

	private String nome;

	private String pais;

	//bi-directional many-to-one association to Qualificacaohotel
	@OneToMany(mappedBy="hotelBean")
	private List<Qualificacaohotel> qualificacaohotels;

	//bi-directional many-to-one association to Reservadiaria
	@OneToMany(mappedBy="hotelBean")
	private List<Reservadiaria> reservadiarias;

	public Hotel() {
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public List<Qualificacaohotel> getQualificacaohotels() {
		return this.qualificacaohotels;
	}

	public void setQualificacaohotels(List<Qualificacaohotel> qualificacaohotels) {
		this.qualificacaohotels = qualificacaohotels;
	}

	public Qualificacaohotel addQualificacaohotel(Qualificacaohotel qualificacaohotel) {
		getQualificacaohotels().add(qualificacaohotel);
		qualificacaohotel.setHotelBean(this);

		return qualificacaohotel;
	}

	public Qualificacaohotel removeQualificacaohotel(Qualificacaohotel qualificacaohotel) {
		getQualificacaohotels().remove(qualificacaohotel);
		qualificacaohotel.setHotelBean(null);

		return qualificacaohotel;
	}

	public List<Reservadiaria> getReservadiarias() {
		return this.reservadiarias;
	}

	public void setReservadiarias(List<Reservadiaria> reservadiarias) {
		this.reservadiarias = reservadiarias;
	}

	public Reservadiaria addReservadiaria(Reservadiaria reservadiaria) {
		getReservadiarias().add(reservadiaria);
		reservadiaria.setHotelBean(this);

		return reservadiaria;
	}

	public Reservadiaria removeReservadiaria(Reservadiaria reservadiaria) {
		getReservadiarias().remove(reservadiaria);
		reservadiaria.setHotelBean(null);

		return reservadiaria;
	}

}