package br.iff.pooa20141.agencia.model.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20141.agencia.model.entity.Qualificacaohotel;
import br.iff.pooa20141.agencia.model.entity.Usuario;
import br.iff.pooa20141.agencia.model.entity.Hotel;

@Stateless
@LocalBean
public class QualificacaoHotelPersistence extends AbstractPersistence implements
		QualificacaoHotelPersistenceRemote {

	/* (non-Javadoc)
	 * @see br.iff.pooa20141.agencia.model.controller.QualificacaohotelPersistenceRemote#inserir(java.lang.String, java.lang.String)
	 */
	@Override
	public Qualificacaohotel inserir(String uid, String comentario, 
			Boolean concretizado,Integer justificativa, Usuario usuario,  Hotel hotel, 
			Integer nivel)
	{
		Qualificacaohotel qualificacaohotel = new Qualificacaohotel();
		qualificacaohotel.setUid(uid);
		qualificacaohotel.setComentario(comentario);
		qualificacaohotel.setConcretizado(concretizado);
		qualificacaohotel.setJustificativa(justificativa);
		qualificacaohotel.setNivel(nivel);	
		qualificacaohotel.setUsuarioBean(usuario);
		qualificacaohotel.setHotelBean(hotel);
		super.insert(qualificacaohotel);
		return qualificacaohotel;
	}

	/* (non-Javadoc)
	 * @see br.iff.pooa20141.agencia.model.controller.QualificacaohotelPersistenceRemote#update(java.lang.String, java.lang.String)
	 */
	@Override
	public Qualificacaohotel update(String uid, String comentario, 
			Boolean concretizado,Integer justificativa, Usuario usuario,  Hotel hotel,
			Integer nivel)
	{
		Qualificacaohotel qualificacaohotel = super.find(Qualificacaohotel.class, uid);
		qualificacaohotel.setUid(uid);
		qualificacaohotel.setComentario(comentario);
		qualificacaohotel.setConcretizado(concretizado);
		qualificacaohotel.setJustificativa(justificativa);
		qualificacaohotel.setNivel(nivel);	
		qualificacaohotel.setUsuarioBean(usuario);
		qualificacaohotel.setHotelBean(hotel);
		super.update(qualificacaohotel);
		return qualificacaohotel;
	}

	/* (non-Javadoc)
	 * @see br.iff.pooa20141.agencia.model.controller.QualificacaohotelPersistenceRemote#find(java.lang.String)
	 */
	@Override
	public Qualificacaohotel find(String uid) {
		return super.find(Qualificacaohotel.class, uid);
	}

	/* (non-Javadoc)
	 * @see br.iff.pooa20141.agencia.model.controller.QualificacaohotelPersistenceRemote#delete(java.lang.String)
	 */
	@Override
	public void delete(String uid) {
		super.delete(Qualificacaohotel.class, uid);

	}

	/* (non-Javadoc)
	 * @see br.iff.pooa20141.agencia.model.controller.QualificacaohotelPersistenceRemote#findAll()
	 */
	@XmlElement(name = "qualificacaohoteis")
	public List<Qualificacaohotel> findAll() {
		// TODO Auto-generated method stub
		return  super.findAll(Qualificacaohotel.class);
	}

}
