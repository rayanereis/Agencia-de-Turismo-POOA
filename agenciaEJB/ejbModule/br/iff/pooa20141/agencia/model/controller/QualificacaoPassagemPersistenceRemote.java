package br.iff.pooa20141.agencia.model.controller;

import java.util.List;

import javax.ejb.Remote;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20141.agencia.model.entity.Agencia;
import br.iff.pooa20141.agencia.model.entity.Qualificacaopassagem;
import br.iff.pooa20141.agencia.model.entity.Usuario;

@Remote

public interface QualificacaoPassagemPersistenceRemote {

public Qualificacaopassagem inserir( String uid, String comentario, Boolean concretizado,  
		Integer justificativa, Usuario usuario,Agencia agencia, Integer nivel);
public Qualificacaopassagem update( String uid, String comentario, Boolean concretizado,  
		Integer justificativa, Usuario usuario, Agencia agencia, Integer nivel);
public Qualificacaopassagem find(String uid);
public void delete(String uid);
@XmlElement(name = "Qualificacaopassagem")
public List<Qualificacaopassagem> findAll();



}

