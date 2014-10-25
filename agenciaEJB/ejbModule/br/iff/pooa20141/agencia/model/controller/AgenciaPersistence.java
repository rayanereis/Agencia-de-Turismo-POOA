
package br.iff.pooa20141.agencia.model.controller;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.xml.bind.annotation.XmlElement;
import br.iff.pooa20141.agencia.model.entity.Agencia;

@Stateless
@LocalBean
public class AgenciaPersistence extends AbstractPersistence implements
		AgenciaPersistenceRemote {

	@Override
	public Agencia inserir(String uid, String nome, String cnpj, String email) {
		Agencia agencia = new Agencia();
		agencia.setUid(uid);
		agencia.setNome(nome);
		agencia.setEmail(email);
		agencia.setCnpj(cnpj);
		super.insert(agencia);
		return agencia;

	}
	
	@Override
	public Agencia update (String uid, String nome, String cnpj, String email) {
		Agencia agencia = super.find(Agencia.class, uid);
		agencia.setUid(uid);
		agencia.setNome(nome);
		agencia.setEmail(email);
		agencia.setCnpj(cnpj);
		super.update(agencia);
		
		//igual ao inserir, mas nao cria um novo obj mas sim busca no bd
		
		return agencia;
	}

	@Override
	public Agencia find(String uid) {
		return super.find(Agencia.class, uid);
	}

	@Override
	public void delete(String uid) {
		super.delete(Agencia.class, uid);
	}
	
	@XmlElement(name = "agencias")
	@Override
	public List<Agencia> findAll() {
		return super.findAll(Agencia.class);
	}
	
}