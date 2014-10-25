package br.iff.pooa20141.agencia.web.controller;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import br.iff.pooa20141.agencia.model.controller.AgenciaPersistence;
import br.iff.pooa20141.agencia.model.entity.Agencia;

@ManagedBean(name = "agenciaPrime")
@SessionScoped

public class AgenciaWebController {
	@EJB(lookup = "java:app/AgenciaWEB/AgenciaPersistence!br.iff.pooa20141.agencia.model.controller.AgenciaPersistence")
			
	private AgenciaPersistence jagencia;
	private Agencia agencia;
	private Agencia agenciaSelecionado = new Agencia();

	public Agencia getAgencia() {
		if (agencia == null) {
			agencia = new Agencia();
		}
		return agencia;
	}

	public List<Agencia> getAllAgencia() {
		return jagencia.findAll();
	}

	public void salva() {

		if (jagencia.find(agencia.getUid()) != null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("agencia Ja Cadastrado"));

		} else {
			jagencia.insert(agencia);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Cadastrado com sucesso!"));
		}
		RequestContext.getCurrentInstance().execute("cadastro.hide()");
		;
	}

	public void delete() {

		if (jagencia.find(agenciaSelecionado.getUid()) == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("agencia não Existe"));

		} else {
			jagencia.delete(agenciaSelecionado.getUid());

		}
		RequestContext.getCurrentInstance().execute("deleta.hide()");
	}

	public Agencia getAgenciaSelecionado() {

		return agenciaSelecionado;
	}

	public void setAgenciaSelecionado(Agencia agenciaSelecionado) {
		this.agenciaSelecionado = agenciaSelecionado;

	}

	public void update() {

		if (jagencia.find(agenciaSelecionado.getUid()) == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("agencia não Existe"));

		} else {

			jagencia.update(agenciaSelecionado);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Alterado com sucesso!"));
		}
		RequestContext.getCurrentInstance().execute("altera.hide()");
		;
	}

	public AgenciaWebController() {

	}

}