package br.iff.pooa20141.agencia.model.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20141.agencia.model.entity.Hotel;

@Stateless
@LocalBean

public class HotelPersistence extends AbstractPersistence implements
	HotelPersistenceRemote {
	
	@Override
	public Hotel inserir(String uid, String nome, String cnpj,  String cidade, String pais) {
		Hotel hotel = new Hotel();
		hotel.setUid(uid);
		hotel.setNome(nome);
		hotel.setCnpj(cnpj);
		hotel.setCidade(cidade);
		hotel.setPais(pais);
		
		super.insert(hotel);
		return hotel;
	}	
	
	@Override
	public Hotel update (String uid, String nome, String cnpj,  String cidade, String pais){
		Hotel hotel = super.find(Hotel.class, uid);
		
		hotel.setUid(uid);
		hotel.setNome(nome);
		hotel.setCnpj(cnpj);
		hotel.setCidade(cidade);
		hotel.setPais(pais);
		
		super.update(hotel);
		return hotel;
		
		//igual ao inserir, mas nao cria um novo obj mas sim busca no bd
	
	}

	@Override
	public Hotel find(String uid) {
		return super.find(Hotel.class, uid);
	}

	@Override
	public void delete(String uid) {
		super.delete(Hotel.class, uid);
	}
	

	@XmlElement(name = "hoteis")
	@Override
	public List<Hotel> findAll() {
		return super.findAll(Hotel.class);
	}

}









	