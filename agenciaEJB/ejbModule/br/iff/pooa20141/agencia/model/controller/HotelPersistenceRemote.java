package br.iff.pooa20141.agencia.model.controller;
import java.sql.Array;
import java.util.List;

import javax.ejb.Remote;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20141.agencia.model.entity.Hotel;

@Remote

public interface HotelPersistenceRemote {

	
public Hotel inserir(String uid, String nome, String cnpj, String cidade, String pais);
public Hotel update(String uid, String nome, String cnpj,  String cidade, String pais);
public Hotel find(String uid);
public void delete(String uid);
@XmlElement(name = "hotel")
public List<Hotel> findAll();



}
