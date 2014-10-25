package br.iff.pooa20141.agencia.web.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import br.iff.pooa20141.agencia.model.controller.HotelPersistence;
import br.iff.pooa20141.agencia.model.controller.ReservadiariaPersistence;
import br.iff.pooa20141.agencia.model.entity.Hotel;
import br.iff.pooa20141.agencia.model.entity.Reservadiaria;


@ManagedBean(name = "reservadiariaPrime")
@SessionScoped
public class ReservaDiariaWebController {

	@EJB(lookup = "java:app/AgenciaWEB/HotelPersistence!br.iff.pooa20141.agencia.model.controller.HotelPersistence")
	private HotelPersistence jhotel;

	@EJB(lookup = "java:app/AgenciaWEB/ReservadiariaPersistence!br.iff.pooa20141.agencia.model.controller.ReservadiariaPersistence")
	private ReservadiariaPersistence jreservadiaria;

	private Reservadiaria reservadiaria;
	private Reservadiaria reservadiariaSelecionado = new Reservadiaria();

	public Reservadiaria getReservadiaria() {
		if (reservadiaria == null) {
			reservadiaria = new Reservadiaria();
		}
		return reservadiaria;
	}

	public List<Reservadiaria> getAllReservadiaria() {
		return jreservadiaria.findAll();
	}

	public List<Hotel> getAllHotel() {
		return jhotel.findAll();
	}

	public void salva() {
		
		if (jreservadiaria.find(reservadiaria.getUid()) != null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("reserva de diaria Ja Cadastrado"));

		} else {

			jreservadiaria.insert(reservadiaria);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Cadastrado com sucesso!"));
		}
		
		RequestContext.getCurrentInstance().execute("cadastro.hide()");
		;
		
	}

	public void delete() {

		if (jreservadiaria.find(reservadiariaSelecionado.getUid()) == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("A reserva de diaria não Existe"));

		} else {
			jreservadiaria.delete(reservadiariaSelecionado.getUid());

		}
		RequestContext.getCurrentInstance().execute("deleta.hide()");
	}

	public Reservadiaria getReservadiariaSelecionado() {

		return reservadiariaSelecionado;
	}

	public void setReservadiariaSelecionado(Reservadiaria reservadiariaSelecionado) {
		this.reservadiariaSelecionado = reservadiariaSelecionado;

	}

	public void update() {

		
		if (jreservadiaria.find(reservadiariaSelecionado.getUid()) == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage(" A reserva da diaria não Existe"));

		} else {

			jreservadiaria.update(reservadiariaSelecionado);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Alterado com sucesso!"));
		}
		RequestContext.getCurrentInstance().execute("altera.hide()");
		;
		
	}

	public ReservaDiariaWebController() {

	}

}