package br.iff.pooa20141.agencia.model.controller;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20141.agencia.model.entity.Agencia;
import br.iff.pooa20141.agencia.model.entity.Reservapassagem;

@Remote

public interface ReservapassagemPersistenceRemote {
	


public Reservapassagem inserir(String uid, Date datapartida, String destino, Integer horapartida,
		Integer minutopartida,String origem, float  valorunitario, Agencia agencia, Integer vagasdisponiveis);
public Reservapassagem update(String uid, Date datapartida, String destino, Integer horapartida,
		Integer minutopartida,String origem, float valorunitario, Agencia agencia, Integer vagasdisponiveis);
public Reservapassagem find(String uid);
public void delete(String uid);
@XmlElement(name = "Reservapassagem")
public List<Reservapassagem> findAll();



}

