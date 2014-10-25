package br.iff.pooa20141.agencia.model.controller;

	import java.util.List;

import javax.ejb.Remote;
import javax.xml.bind.annotation.XmlElement;
import br.iff.pooa20141.agencia.model.entity.Agencia;

	@Remote
	public interface AgenciaPersistenceRemote {
		
	public Agencia inserir(String uid, String nome, String cnpj, String email);
	public Agencia update(String uid, String nome, String cnpj, String email);
	public Agencia find(String uid);
	public void delete(String uid);
	@XmlElement(name = "agencia")
	public List<Agencia> findAll();
	
}
	