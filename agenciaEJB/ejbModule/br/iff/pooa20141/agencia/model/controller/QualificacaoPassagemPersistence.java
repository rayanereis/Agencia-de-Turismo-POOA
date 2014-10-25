package br.iff.pooa20141.agencia.model.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20141.agencia.model.entity.Agencia;
import br.iff.pooa20141.agencia.model.entity.Qualificacaopassagem;
import br.iff.pooa20141.agencia.model.entity.Usuario;

@Stateless
@LocalBean
public class QualificacaoPassagemPersistence extends AbstractPersistence implements
		QualificacaoPassagemPersistenceRemote {

	/* (non-Javadoc)
	 * @see br.iff.pooa20141.agencia.model.controller.QualificacaopassagemPersistenceRemote#inserir(java.lang.String, java.lang.String)
	 */
	@Override
	public Qualificacaopassagem inserir( String uid, String comentario, Boolean concretizado,  
			Integer justificativa, Usuario usuario, Agencia agencia, Integer nivel)
	{
		Qualificacaopassagem qualificacaopassagem = new Qualificacaopassagem();
		qualificacaopassagem.setUid(uid);
		qualificacaopassagem.setComentario(comentario);
		qualificacaopassagem.setConcretizado(concretizado);
		qualificacaopassagem.setJustificativa(justificativa);
		qualificacaopassagem.setNivel(nivel);	
		qualificacaopassagem.setUsuarioBean(usuario);
		qualificacaopassagem.setAgenciaBean(agencia);
		
		super.insert(qualificacaopassagem);
		return qualificacaopassagem;
	}

	/* (non-Javadoc)
	 * @see br.iff.pooa20141.agencia.model.controller.QualificacaopassagemPersistenceRemote#update(java.lang.String, java.lang.String)
	 */
	@Override
	public Qualificacaopassagem update(String uid, String comentario, 
			Boolean concretizado,Integer justificativa, Usuario usuario, Agencia agencia,
			Integer nivel)
			
	{
		Qualificacaopassagem qualificacaopassagem = super.find(Qualificacaopassagem.class, uid);
		qualificacaopassagem.setUid(uid);
		qualificacaopassagem.setComentario(comentario);
		qualificacaopassagem.setConcretizado(concretizado);
		qualificacaopassagem.setJustificativa(justificativa);
		qualificacaopassagem.setNivel(nivel);	
		qualificacaopassagem.setUsuarioBean(usuario);
		qualificacaopassagem.setAgenciaBean(agencia);
		
		super.update(qualificacaopassagem);
		return qualificacaopassagem;
	}

	/* (non-Javadoc)
	 * @see br.iff.pooa20141.agencia.model.controller.QualificacaopassagemPersistenceRemote#find(java.lang.String)
	 */
	@Override
	public Qualificacaopassagem find(String uid) {
		return super.find(Qualificacaopassagem.class, uid);
	}

	/* (non-Javadoc)
	 * @see br.iff.pooa20141.agencia.model.controller.QualificacaopassagemPersistenceRemote#delete(java.lang.String)
	 */
	@Override
	public void delete(String uid) {
		super.delete(Qualificacaopassagem.class, uid);

	}

	/* (non-Javadoc)
	 * @see br.iff.pooa20141.agencia.model.controller.QualificacaopassagemPersistenceRemote#findAll()
	 */
	@XmlElement(name = "qualificacaopassagens")
	public List<Qualificacaopassagem> findAll() {
		// TODO Auto-generated method stub
		return  super.findAll(Qualificacaopassagem.class);
	}

}
