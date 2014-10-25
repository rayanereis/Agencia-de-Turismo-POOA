package br.iff.pooa20141.agencia.model.controller;

import java.util.List;

import javax.ejb.Remote;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20141.agencia.model.entity.Pacote;
import br.iff.pooa20141.agencia.model.entity.Qualificacaohotel;
import br.iff.pooa20141.agencia.model.entity.Qualificacaopassagem;
import br.iff.pooa20141.agencia.model.entity.Usuario;
@Remote

public interface UsuarioPersistenceRemote {

public Usuario inserir(String uid, String email, String nome, String senha);
public Usuario update(String uid, String email, String nome, String senha );
public Usuario find(String uid);
public void delete(String uid);
@XmlElement(name = "usuario")
public List<Usuario> findAll();



}

