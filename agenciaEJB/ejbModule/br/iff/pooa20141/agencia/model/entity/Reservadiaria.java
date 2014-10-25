package br.iff.pooa20141.agencia.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the reservadiaria database table.
 * 
 */
@Entity
@NamedQuery(name="Reservadiaria.findAll", query="SELECT r FROM Reservadiaria r")
public class Reservadiaria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	@Temporal(TemporalType.DATE)
	private Date periodofinal;

	@Temporal(TemporalType.DATE)
	private Date periodoinicial;

	private Integer vagasdisponiveis;

	private float valorunitario;

	//bi-directional many-to-one association to Pacote
	@OneToMany(mappedBy="reservadiariaBean")
	private List<Pacote> pacotes;

	//bi-directional many-to-one association to Hotel
	@ManyToOne
	@JoinColumn(name="hotel")
	private Hotel hotelBean;

	public Reservadiaria() {
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Date getPeriodofinal() {
		return this.periodofinal;
	}

	public void setPeriodofinal(Date periodofinal) {
		this.periodofinal = periodofinal;
	}

	public Date getPeriodoinicial() {
		return this.periodoinicial;
	}

	public void setPeriodoinicial(Date periodoinicial) {
		this.periodoinicial = periodoinicial;
	}

	public Integer getVagasdisponiveis() {
		return this.vagasdisponiveis;
	}

	public void setVagasdisponiveis(Integer vagasdisponiveis) {
		this.vagasdisponiveis = vagasdisponiveis;
	}

	public float getValorunitario() {
		return this.valorunitario;
	}

	public void setValorunitario(float valorunitario) {
		this.valorunitario = valorunitario;
	}

	public List<Pacote> getPacotes() {
		return this.pacotes;
	}

	public void setPacotes(List<Pacote> pacotes) {
		this.pacotes = pacotes;
	}

	public Pacote addPacote(Pacote pacote) {
		getPacotes().add(pacote);
		pacote.setReservadiariaBean(this);

		return pacote;
	}

	public Pacote removePacote(Pacote pacote) {
		getPacotes().remove(pacote);
		pacote.setReservadiariaBean(null);

		return pacote;
	}

	public Hotel getHotelBean() {
		return this.hotelBean;
	}

	public void setHotelBean(Hotel hotelBean) {
		this.hotelBean = hotelBean;
	}

}