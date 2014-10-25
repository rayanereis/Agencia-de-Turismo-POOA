package br.iff.pooa20141.agencia.web.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import br.iff.pooa20141.agencia.model.controller.AgenciaPersistence;
import br.iff.pooa20141.agencia.model.controller.ReservapassagemPersistence;
import br.iff.pooa20141.agencia.model.entity.Agencia;
import br.iff.pooa20141.agencia.model.entity.Reservapassagem;


@ManagedBean(name = "reservapassagemPrime")
@SessionScoped
public class ReservaPassagemWebController {

	@EJB(lookup = "java:app/AgenciaWEB/AgenciaPersistence!br.iff.pooa20141.agencia.model.controller.AgenciaPersistence")
	private AgenciaPersistence jagencia;

	@EJB(lookup = "java:app/AgenciaWEB/ReservapassagemPersistence!br.iff.pooa20141.agencia.model.controller.ReservapassagemPersistence")
	private ReservapassagemPersistence jreservapassagem;

	private Reservapassagem reservapassagem;
	private Reservapassagem reservapassagemSelecionado = new Reservapassagem();

	public Reservapassagem getReservapassagem() {
		if (reservapassagem == null) {
			reservapassagem = new Reservapassagem();
		}
		return reservapassagem;
	}

	public List<Reservapassagem> getAllReservapassagem() {
		return jreservapassagem.findAll();
	}

	public List<Agencia> getAllAgencia() {
		return jagencia.findAll();
	}

	public void salva() {
		
		if (jreservapassagem.find(reservapassagem.getUid()) != null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("reserva de diaria Ja Cadastrado"));

		} else {

			jreservapassagem.insert(reservapassagem);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Cadastrado com sucesso!"));
		}
		
		RequestContext.getCurrentInstance().execute("cadastro.hide()");
		;
		
	}

	public void delete() {

		if (jreservapassagem.find(reservapassagemSelecionado.getUid()) == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("A reserva de diaria não Existe"));

		} else {
			jreservapassagem.delete(reservapassagemSelecionado.getUid());

		}
		RequestContext.getCurrentInstance().execute("deleta.hide()");
	}

	public Reservapassagem getReservapassagemSelecionado() {

		return reservapassagemSelecionado;
	}

	public void setReservapassagemSelecionado(Reservapassagem reservapassagemSelecionado) {
		this.reservapassagemSelecionado = reservapassagemSelecionado;

	}

	public void update() {

		
		if (jreservapassagem.find(reservapassagemSelecionado.getUid()) == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage(" A reserva da diaria não Existe"));

		} else {

			jreservapassagem.update(reservapassagemSelecionado);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Alterado com sucesso!"));
		}
		RequestContext.getCurrentInstance().execute("altera.hide()");
		;
		
	}

	public ReservaPassagemWebController() {

	}

}