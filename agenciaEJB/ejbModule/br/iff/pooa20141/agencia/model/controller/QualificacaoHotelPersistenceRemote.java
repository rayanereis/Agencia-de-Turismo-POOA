package br.iff.pooa20141.agencia.model.controller;

import java.util.List;
import br.iff.pooa20141.agencia.model.entity.Hotel;

import javax.ejb.Remote;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20141.agencia.model.entity.Qualificacaohotel;
import br.iff.pooa20141.agencia.model.entity.Usuario;

@Remote

public interface QualificacaoHotelPersistenceRemote {

public Qualificacaohotel inserir( String uid, String comentario, Boolean concretizado,  
		Integer justificativa, Usuario usuario, Hotel hotel, Integer nivel);
public Qualificacaohotel update( String uid, String comentario, Boolean concretizado,  
		Integer justificativa, Usuario usuario,  Hotel hotel, Integer nivel);
public Qualificacaohotel find(String uid);
public void delete(String uid);
@XmlElement(name = "qualificacaohotel")
public List<Qualificacaohotel> findAll();



}

