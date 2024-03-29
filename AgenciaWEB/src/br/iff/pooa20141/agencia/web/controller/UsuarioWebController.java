package br.iff.pooa20141.agencia.web.controller;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import br.iff.pooa20141.agencia.model.controller.UsuarioPersistence;
import br.iff.pooa20141.agencia.model.entity.Usuario;




@ManagedBean(name = "usuarioPrime")
@SessionScoped

public class UsuarioWebController {
	@EJB(lookup = "java:app/AgenciaWEB/UsuarioPersistence!br.iff.pooa20141.agencia.model.controller.UsuarioPersistence")
			
	private UsuarioPersistence jusuario;
	private Usuario usuario;
	private Usuario usuarioSelecionado = new Usuario();

	public Usuario getUsuario() {
		if (usuario == null) {
			usuario = new Usuario();
		}
		return usuario;
	}

	public List<Usuario> getAllUsuario() {
		return jusuario.findAll();
	}

	public void salva() {

		if (jusuario.find(usuario.getUid()) != null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("usuario Ja Cadastrado"));

		} else {
			jusuario.insert(usuario);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Cadastrado com sucesso!"));
		}
		RequestContext.getCurrentInstance().execute("cadastro.hide()");
		;
	}

	public void delete() {

		if (jusuario.find(usuarioSelecionado.getUid()) == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("usuario não Existe"));

		} else {
			jusuario.delete(usuarioSelecionado.getUid());

		}
		RequestContext.getCurrentInstance().execute("deleta.hide()");
	}

	public Usuario getUsuarioSelecionado() {

		return usuarioSelecionado;
	}

	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;

	}

	public void update() {

		if (jusuario.find(usuarioSelecionado.getUid()) == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("usuario não Existe"));

		} else {

			jusuario.update(usuarioSelecionado);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Alterado com sucesso!"));
		}
		RequestContext.getCurrentInstance().execute("altera.hide()");
		;
	}

	public UsuarioWebController() {

	}

}