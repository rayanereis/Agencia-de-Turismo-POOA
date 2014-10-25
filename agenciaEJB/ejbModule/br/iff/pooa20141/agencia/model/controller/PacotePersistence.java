package br.iff.pooa20141.agencia.model.controller;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20141.agencia.model.entity.Hotel;
import br.iff.pooa20141.agencia.model.entity.Pacote;
import br.iff.pooa20141.agencia.model.entity.Reservadiaria;
import br.iff.pooa20141.agencia.model.entity.Reservapassagem;
import br.iff.pooa20141.agencia.model.entity.Usuario;

@Stateless
@LocalBean
public class PacotePersistence extends AbstractPersistence implements
		PacotePersistenceRemote {

	/* (non-Javadoc)
	 * @see br.iff.pooa20141.agencia.model.controller.PacotePersistenceRemote#inserir(java.lang.String, java.lang.String)
	 */
	@Override
	public Pacote inserir(String uid,String destino,  float total, Reservadiaria reservadiaria, 
			Reservapassagem reservapassagem, Usuario usuario, Integer quantidadepessoas)
			{
	
		
		Pacote pacote = new Pacote();
		pacote.setUid(uid);
		pacote.setDestino(destino);
		pacote.setTotal(total);
		
		pacote.setReservadiariaBean(reservadiaria);
		pacote.setReservapassagemBean(reservapassagem);
		pacote.setUsuarioBean(usuario);
		pacote.setQuantidadepessoas(quantidadepessoas);
		
		super.insert(pacote);
		return pacote;
	
	}

	/* (non-Javadoc)
	 * @see br.iff.pooa20141.agencia.model.controller.PacotePersistenceRemote#update(java.lang.String, java.lang.String)
	 */
	@Override
	public Pacote update(String uid,String destino,  float total, Reservadiaria reservadiaria, 
			Reservapassagem reservapassagem, Usuario usuario, Integer quantidadepessoas)
	{
		Pacote pacote = super.find(Pacote.class, uid);
		
		pacote.setUid(uid);
		pacote.setDestino(destino);
		pacote.setTotal(total);
		pacote.setQuantidadepessoas(quantidadepessoas);
		pacote.setReservadiariaBean(reservadiaria);
		pacote.setReservapassagemBean(reservapassagem);
		pacote.setUsuarioBean(usuario);
		
		
		super.update(pacote);
		return pacote;
	}

	/* (non-Javadoc)
	 * @see br.iff.pooa20141.agencia.model.controller.PacotePersistenceRemote#find(java.lang.String)
	 */
	@Override
	public Pacote find(String uid) {
		return super.find(Pacote.class, uid);
	}

	/* (non-Javadoc)
	 * @see br.iff.pooa20141.agencia.model.controller.PacotePersistenceRemote#delete(java.lang.String)
	 */
	@Override
	public void delete(String uid) {
		super.delete(Pacote.class, uid);

	}

	/* (non-Javadoc)
	 * @see br.iff.pooa20141.agencia.model.controller.PacotePersistenceRemote#findAll()
	 */
	@XmlElement(name = "pacotes")
	public List<Pacote> findAll() {
		// TODO Auto-generated method stub
		return  super.findAll(Pacote.class);
	}

}
