package br.iff.pooa20141.agencia.model.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the qualificacaopassagem database table.
 * 
 */
@Entity
@NamedQuery(name="Qualificacaopassagem.findAll", query="SELECT q FROM Qualificacaopassagem q")
public class Qualificacaopassagem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	private String comentario;

	private Boolean concretizado;

	private Integer justificativa;

	private Integer nivel;

	//bi-directional many-to-one association to Agencia
	@ManyToOne
	@JoinColumn(name="agencia")
	private Agencia agenciaBean;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuario")
	private Usuario usuarioBean;

	public Qualificacaopassagem() {
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getComentario() {
		return this.comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Boolean getConcretizado() {
		return this.concretizado;
	}

	public void setConcretizado(Boolean concretizado) {
		this.concretizado = concretizado;
	}

	public Integer getJustificativa() {
		return this.justificativa;
	}

	public void setJustificativa(Integer justificativa) {
		this.justificativa = justificativa;
	}

	public Integer getNivel() {
		return this.nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public Agencia getAgenciaBean() {
		return this.agenciaBean;
	}

	public void setAgenciaBean(Agencia agenciaBean) {
		this.agenciaBean = agenciaBean;
	}

	public Usuario getUsuarioBean() {
		return this.usuarioBean;
	}

	public void setUsuarioBean(Usuario usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

}