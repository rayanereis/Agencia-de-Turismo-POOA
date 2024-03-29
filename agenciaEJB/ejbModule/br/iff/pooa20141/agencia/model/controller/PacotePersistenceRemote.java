package br.iff.pooa20141.agencia.model.controller;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20141.agencia.model.entity.Hotel;
import br.iff.pooa20141.agencia.model.entity.Pacote;
import br.iff.pooa20141.agencia.model.entity.Reservadiaria;
import br.iff.pooa20141.agencia.model.entity.Reservapassagem;
import br.iff.pooa20141.agencia.model.entity.Usuario;

@Remote

public interface PacotePersistenceRemote {
	
	
public Pacote inserir(String uid,String destino,  float total, Reservadiaria reservadiaria, 
		Reservapassagem reservapassagem, Usuario usuario, Integer quantidadepessoas);
public Pacote update(String uid,String destino,  float total, Reservadiaria reservadiaria, 
		Reservapassagem reservapassagem, Usuario usuario, Integer quantidadepessoas_);
public Pacote find(String uid);
public void delete(String uid);
@XmlElement(name = "pacote")
public List<Pacote> findAll();



}

