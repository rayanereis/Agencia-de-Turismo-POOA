package br.iff.pooa20141.agencia.web.controller;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import br.iff.pooa20141.agencia.model.controller.HotelPersistence;
import br.iff.pooa20141.agencia.model.entity.Hotel;




@ManagedBean(name = "hotelPrime")
@SessionScoped

public class HotelWebController {
	@EJB(lookup = "java:app/AgenciaWEB/HotelPersistence!br.iff.pooa20141.agencia.model.controller.HotelPersistence")
			
	private HotelPersistence jhotel;
	private Hotel hotel;
	private Hotel hotelSelecionado = new Hotel();

	public Hotel getHotel() {
		if (hotel == null) {
			hotel = new Hotel();
		}
		return hotel;
	}

	public List<Hotel> getAllHotel() {
		return jhotel.findAll();
	}

	public void salva() {

		if (jhotel.find(hotel.getUid()) != null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("hotel Ja Cadastrado"));

		} else {
			jhotel.insert(hotel);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Cadastrado com sucesso!"));
		}
		RequestContext.getCurrentInstance().execute("cadastro.hide()");
		;
	}

	public void delete() {

		if (jhotel.find(hotelSelecionado.getUid()) == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("hotel não Existe"));

		} else {
			jhotel.delete(hotelSelecionado.getUid());

		}
		RequestContext.getCurrentInstance().execute("deleta.hide()");
	}

	public Hotel getHotelSelecionado() {

		return hotelSelecionado;
	}

	public void setHotelSelecionado(Hotel hotelSelecionado) {
		this.hotelSelecionado = hotelSelecionado;

	}

	public void update() {

		if (jhotel.find(hotelSelecionado.getUid()) == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("hotel não Existe"));

		} else {

			jhotel.update(hotelSelecionado);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Alterado com sucesso!"));
		}
		RequestContext.getCurrentInstance().execute("altera.hide()");
		;
	}

	public HotelWebController() {

	}

}