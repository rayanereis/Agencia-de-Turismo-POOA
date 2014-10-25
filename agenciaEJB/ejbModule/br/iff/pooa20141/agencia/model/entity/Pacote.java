package br.iff.pooa20141.agencia.model.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pacote database table.
 * 
 */
@Entity
@NamedQuery(name="Pacote.findAll", query="SELECT p FROM Pacote p")
public class Pacote implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	private String destino;

	private Integer quantidadepessoas;

	private float total;

	//bi-directional many-to-one association to Reservadiaria
	@ManyToOne
	@JoinColumn(name="reservadiaria")
	private Reservadiaria reservadiariaBean;

	//bi-directional many-to-one association to Reservapassagem
	@ManyToOne
	@JoinColumn(name="reservapassagem")
	private Reservapassagem reservapassagemBean;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuario")
	private Usuario usuarioBean;

	public Pacote() {
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getDestino() {
		return this.destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Integer getQuantidadepessoas() {
		return this.quantidadepessoas;
	}

	public void setQuantidadepessoas(Integer quantidadepessoas) {
		this.quantidadepessoas = quantidadepessoas;
	}

	public float getTotal() {
		return this.total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Reservadiaria getReservadiariaBean() {
		return this.reservadiariaBean;
	}

	public void setReservadiariaBean(Reservadiaria reservadiariaBean) {
		this.reservadiariaBean = reservadiariaBean;
	}

	public Reservapassagem getReservapassagemBean() {
		return this.reservapassagemBean;
	}

	public void setReservapassagemBean(Reservapassagem reservapassagemBean) {
		this.reservapassagemBean = reservapassagemBean;
	}

	public Usuario getUsuarioBean() {
		return this.usuarioBean;
	}

	public void setUsuarioBean(Usuario usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

}