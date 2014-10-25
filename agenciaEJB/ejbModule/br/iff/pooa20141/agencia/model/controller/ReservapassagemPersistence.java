package br.iff.pooa20141.agencia.model.controller;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20141.agencia.model.entity.Agencia;
import br.iff.pooa20141.agencia.model.entity.Reservapassagem;

@Stateless
@LocalBean
public class ReservapassagemPersistence extends AbstractPersistence implements
		ReservapassagemPersistenceRemote {

	/* (non-Javadoc)
	 * @see br.iff.pooa20141.agencia.model.controller.ReservapassagemPersistenceRemote#inserir(java.lang.String, java.lang.String)
	 */
	@Override
	public Reservapassagem inserir(String uid, Date datapartida, String destino, Integer horapartida,
			Integer minutopartida,String origem, float  valorunitario, Agencia agencia,Integer vagasdisponiveis)
	{
		Reservapassagem reservapassagem = new Reservapassagem();
		reservapassagem.setUid(uid);
		reservapassagem.setDatapartida(datapartida);
		reservapassagem.setDestino(destino);
		reservapassagem.setHorapartida(horapartida);
		reservapassagem.setOrigem(origem);	
		reservapassagem.setValorunitario(valorunitario);
		reservapassagem.setVagasdisponiveis(vagasdisponiveis);
		reservapassagem.setAgenciaBean(agencia);
		super.insert(reservapassagem);
		return reservapassagem;
	
	}

	/* (non-Javadoc)
	 * @see br.iff.pooa20141.agencia.model.controller.ReservapassagemPersistenceRemote#update(java.lang.String, java.lang.String)
	 */
	@Override
	public Reservapassagem update(String uid, Date datapartida, String destino, Integer horapartida,
			Integer minutopartida,String origem, float  valorunitario, Agencia agencia, Integer vagasdisponiveis)
	{
		Reservapassagem reservapassagem = super.find(Reservapassagem.class, uid);
		reservapassagem.setUid(uid);
		reservapassagem.setDatapartida(datapartida);
		reservapassagem.setDestino(destino);
		reservapassagem.setHorapartida(horapartida);
		reservapassagem.setOrigem(origem);	
		reservapassagem.setValorunitario(valorunitario);	
		reservapassagem.setVagasdisponiveis(vagasdisponiveis);
		reservapassagem.setAgenciaBean(agencia);
		
		super.update(reservapassagem);
		return reservapassagem;
	}

	/* (non-Javadoc)
	 * @see br.iff.pooa20141.agencia.model.controller.ReservapassagemPersistenceRemote#find(java.lang.String)
	 */
	@Override
	public Reservapassagem find(String uid) {
		return super.find(Reservapassagem.class, uid);
	}

	/* (non-Javadoc)
	 * @see br.iff.pooa20141.agencia.model.controller.ReservapassagemPersistenceRemote#delete(java.lang.String)
	 */
	@Override
	public void delete(String uid) {
		super.delete(Reservapassagem.class, uid);

	}

	/* (non-Javadoc)
	 * @see br.iff.pooa20141.agencia.model.controller.ReservapassagemPersistenceRemote#findAll()
	 */
	@XmlElement(name = "reservapassagens")
	public List<Reservapassagem> findAll() {
		// TODO Auto-generated method stub
		return  super.findAll(Reservapassagem.class);
	}

}
