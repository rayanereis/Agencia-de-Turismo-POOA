package br.iff.pooa20141.agencia.model.controller;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20141.agencia.model.entity.Hotel;
import br.iff.pooa20141.agencia.model.entity.Reservadiaria;

@Remote

public interface ReservadiariaPersistenceRemote {
	

public Reservadiaria inserir(String uid, Date periodofinal, Date periodoinicial, Integer vagasdisponiveis, float  valorunitario, Hotel hotel);

public Reservadiaria update(String uid, Date periodofinal, Date periodoinicial, Integer vagasdisponiveis, float  valorunitario, Hotel hotel);

public Reservadiaria find(String uid);
public void delete(String uid);
@XmlElement(name = "reservadiaria")
public List<Reservadiaria> findAll();



}
