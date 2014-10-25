package br.iff.pooa20141.agencia.web.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import br.iff.pooa20141.agencia.model.controller.AgenciaPersistence;
import br.iff.pooa20141.agencia.model.controller.QualificacaoPassagemPersistence;
import br.iff.pooa20141.agencia.model.controller.UsuarioPersistence;
import br.iff.pooa20141.agencia.model.entity.Agencia;
import br.iff.pooa20141.agencia.model.entity.Qualificacaopassagem;
import br.iff.pooa20141.agencia.model.entity.Usuario;


@ManagedBean(name = "qualificacaopassagemPrime")
@SessionScoped
public class QualificacaoPassagemWebController {

	@EJB(lookup = "java:app/AgenciaWEB/AgenciaPersistence!br.iff.pooa20141.agencia.model.controller.AgenciaPersistence")
	private AgenciaPersistence jagencia;

	@EJB(lookup = "java:app/AgenciaWEB/UsuarioPersistence!br.iff.pooa20141.agencia.model.controller.UsuarioPersistence")
	private UsuarioPersistence jusuario;
	
	@EJB(lookup = "java:app/AgenciaWEB/QualificacaoPassagemPersistence!br.iff.pooa20141.agencia.model.controller.QualificacaoPassagemPersistence")
	private QualificacaoPassagemPersistence jqualificacaopassagem;

	private Qualificacaopassagem qualificacaopassagem;
	private Qualificacaopassagem qualificacaopassagemSelecionado = new Qualificacaopassagem();

	public Qualificacaopassagem getQualificacaopassagem() {
		if (qualificacaopassagem == null) {
			qualificacaopassagem = new Qualificacaopassagem();
		}
		return qualificacaopassagem;
	}

	public List<Qualificacaopassagem> getAllQualificacaopassagem() {
		return jqualificacaopassagem.findAll();
	}

	public List<Agencia> getAllAgencia() {
		return jagencia.findAll();
	}

	public List<Usuario> getAllUsuario() {
		return jusuario.findAll();
	}
	public void salva() {
		
		if (jqualificacaopassagem.find(qualificacaopassagem.getUid()) != null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("qualificacao de diaria Ja Cadastrado"));

		} else {

			jqualificacaopassagem.insert(qualificacaopassagem);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Cadastrado com sucesso!"));
		}
		
		RequestContext.getCurrentInstance().execute("cadastro.hide()");
		;
		
	}

	public void delete() {

		if (jqualificacaopassagem.find(qualificacaopassagemSelecionado.getUid()) == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("A qualificacao de diaria não Existe"));

		} else {
			jqualificacaopassagem.delete(qualificacaopassagemSelecionado.getUid());

		}
		RequestContext.getCurrentInstance().execute("deleta.hide()");
	}

	public Qualificacaopassagem getQualificacaopassagemSelecionado() {

		return qualificacaopassagemSelecionado;
	}

	public void setQualificacaopassagemSelecionado(Qualificacaopassagem qualificacaopassagemSelecionado) {
		this.qualificacaopassagemSelecionado = qualificacaopassagemSelecionado;

	}

	public void update() {

		
		if (jqualificacaopassagem.find(qualificacaopassagemSelecionado.getUid()) == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage(" A qualificacao da diaria não Existe"));

		} else {

			jqualificacaopassagem.update(qualificacaopassagemSelecionado);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Alterado com sucesso!"));
		}
		RequestContext.getCurrentInstance().execute("altera.hide()");
		;
		
	}

	public QualificacaoPassagemWebController() {

	}

}