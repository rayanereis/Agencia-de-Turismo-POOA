package br.iff.pooa20141.agencia.model.test;
import static org.junit.Assert.assertEquals;

import java.util.UUID;

import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.iff.pooa20141.agencia.model.controller.UsuarioPersistenceRemote;
import br.iff.pooa20141.agencia.model.entity.Usuario;



public class UsuarioTest {
	private UsuarioPersistenceRemote usuarioPR;

	@Before
	public void setUp() throws Exception {
		
			Context context = null;
			usuarioPR = null;
			try {

				context = JNDILookupClass.getInitialContext();
				

				usuarioPR = (UsuarioPersistenceRemote) context
						.lookup("ejb:AgenciaEAR/agenciaEJB/UsuarioPersistence!br.iff.pooa20141.agencia.model.controller.UsuarioPersistenceRemote");
			} catch (NamingException e) {
				e.printStackTrace();

			}
		}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInserir() {
		String uid = UUID.randomUUID().toString();
		Usuario usuario = usuarioPR.inserir(uid,"email", "nome", "senha");
		assertEquals(usuario.getUid(), uid);
		usuarioPR.delete(uid);
	}
	@Test
	public void testupdate() {
		String uid = UUID.randomUUID().toString();
		usuarioPR.inserir(uid,"email", "nome", "senha");

		Usuario usuarioUp = usuarioPR.update(uid,"email", "nome1", "senha");

		assertEquals(usuarioUp.getNome(), "nome1");
		usuarioPR.delete(uid);
	}

	@Test
	public void testfind() {
		String uid = UUID.randomUUID().toString();
		usuarioPR.inserir(uid,"email", "nome", "senha");

		Usuario usuarioUp = usuarioPR.find(uid);

		assertEquals(usuarioUp.getNome(), "nome");
		usuarioPR.delete(uid);
	}
	@Test
	public void testdelete() {
		String uid = UUID.randomUUID().toString();
		usuarioPR.inserir(uid,"email", "nome", "senha");

		usuarioPR.delete(uid);
		assertEquals(usuarioPR.find(uid),null);
	}


}


