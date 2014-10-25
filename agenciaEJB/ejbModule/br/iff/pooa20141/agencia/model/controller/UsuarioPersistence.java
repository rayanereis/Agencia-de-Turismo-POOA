
package br.iff.pooa20141.agencia.model.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20141.agencia.model.entity.Usuario;


@Stateless
@LocalBean
public class UsuarioPersistence extends AbstractPersistence implements
		UsuarioPersistenceRemote {
	
	@Override
	public Usuario inserir(String uid, String email, String nome, String senha) {
		Usuario usuario = new Usuario();
		usuario.setUid(uid);
		usuario.setEmail(email);
		usuario.setNome(nome);
		usuario.setSenha(senha);
		
		
		super.insert(usuario);
		return usuario;
	}

	@Override
	public Usuario update(String uid, String email, String nome, String senha) {
		Usuario usuario = super.find(Usuario.class, uid);
		usuario.setUid(uid);
		usuario.setEmail(email);
		usuario.setNome(nome);
		usuario.setSenha(senha);
		super.update(usuario);
		return usuario;
	}
	
	@Override
	public Usuario find(String uid) {
		return super.find(Usuario.class, uid);
	}


	@Override
	public void delete(String uid) {
		super.delete(Usuario.class, uid);

	}

	@XmlElement(name = "usuarios")
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return  super.findAll(Usuario.class);
	}

}
