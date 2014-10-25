package br.iff.pooa20141.agencia.model.test;
import static org.junit.Assert.assertEquals;

import java.util.UUID;

import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.iff.pooa20141.agencia.model.controller.QualificacaoPassagemPersistenceRemote;
import br.iff.pooa20141.agencia.model.controller.UsuarioPersistenceRemote;
import br.iff.pooa20141.agencia.model.controller.AgenciaPersistenceRemote;
import br.iff.pooa20141.agencia.model.entity.Qualificacaopassagem;
import br.iff.pooa20141.agencia.model.entity.Usuario;
import br.iff.pooa20141.agencia.model.entity.Agencia;


public class QualificacaoPassagemTeste {

	private UsuarioPersistenceRemote usuarioPR;
	private AgenciaPersistenceRemote agenciaPR;
	private QualificacaoPassagemPersistenceRemote qualificacaoPassagemPR;

	
	Usuario usuario;
	String uidUsuario = UUID.randomUUID().toString();
	
	Agencia agencia;
	String uidAgencia = UUID.randomUUID().toString();
	

	@Before
	public void setUp() throws Exception {
		Context context = null;
		usuarioPR = null;
		qualificacaoPassagemPR = null;
		agenciaPR= null;
		
		try {

			context = JNDILookupClass.getInitialContext();

			usuarioPR = (UsuarioPersistenceRemote) context
					.lookup("ejb:AgenciaEAR/agenciaEJB/UsuarioPersistence!br.iff.pooa20141.agencia.model.controller.UsuarioPersistenceRemote");

		} catch (NamingException e) {
			e.printStackTrace();

		}
		
		
		try {

			context = JNDILookupClass.getInitialContext();

			agenciaPR = (AgenciaPersistenceRemote) context
					.lookup("ejb:AgenciaEAR/agenciaEJB/AgenciaPersistence!br.iff.pooa20141.agencia.model.controller.AgenciaPersistenceRemote");

		} catch (NamingException e) {
			e.printStackTrace();

		}
		try {

			context = JNDILookupClass.getInitialContext();

			qualificacaoPassagemPR = (QualificacaoPassagemPersistenceRemote) context
					.lookup("ejb:AgenciaEAR/agenciaEJB/QualificacaoPassagemPersistence!br.iff.pooa20141.agencia.model.controller.QualificacaoPassagemPersistenceRemote");

		} catch (NamingException e) {
			e.printStackTrace();

		}
		
		uidUsuario = UUID.randomUUID().toString();
		usuario = usuarioPR.inserir(uidUsuario,"email", "nome", "senha");
		
		uidAgencia = UUID.randomUUID().toString();
		agencia = agenciaPR.inserir(uidAgencia, "Nome", "cnpj", "email");
		
	}

	@After
	public void tearDown() throws Exception {
		
		agenciaPR.delete(uidAgencia);
		usuarioPR.delete(uidUsuario);
	}

	@Test
	public void testInserir() {
		String uid = UUID.randomUUID().toString();
		Qualificacaopassagem qualificacaoPassagem = qualificacaoPassagemPR.inserir(uid, "comentario", true,2, usuario, agencia, 6);
		assertEquals(qualificacaoPassagem.getUid(), uid);
		qualificacaoPassagemPR.delete(uid);
	}

	@Test
	public void testupdate() {
		String uid = UUID.randomUUID().toString();
		qualificacaoPassagemPR.inserir(uid, "comentario", true,2, usuario, agencia, 6);

		Qualificacaopassagem qualificacaoPassagemUp = qualificacaoPassagemPR.update(uid, "comentario1", true,2, usuario, agencia, 6);

		assertEquals(qualificacaoPassagemUp.getComentario(), "comentario1");
		qualificacaoPassagemPR.delete(uid);
	}

	@Test
	public void testfind() {
		String uid = UUID.randomUUID().toString();
		qualificacaoPassagemPR.inserir(uid, "comentario", true,2, usuario, agencia, 6);

		Qualificacaopassagem qualificacaoPassagemUp = qualificacaoPassagemPR.find(uid);

		assertEquals(qualificacaoPassagemUp.getComentario(), "comentario");
		qualificacaoPassagemPR.delete(uid);
	}
	@Test
	public void testdelete() {
		String uid = UUID.randomUUID().toString();
		qualificacaoPassagemPR.inserir(uid, "comentario", true,2, usuario, agencia, 6);

		qualificacaoPassagemPR.delete(uid);
		assertEquals(qualificacaoPassagemPR.find(uid),null);
	}


}