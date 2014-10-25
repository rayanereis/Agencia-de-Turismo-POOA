package br.iff.pooa20141.agencia.model.test;
import static org.junit.Assert.assertEquals;

import java.util.UUID;

import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.iff.pooa20141.agencia.model.controller.AgenciaPersistenceRemote;
import br.iff.pooa20141.agencia.model.entity.Agencia;



public class AgenciaTeste {
	private AgenciaPersistenceRemote agenciaPR;

	@Before
	public void setUp() throws Exception {
		
			Context context = null;
			agenciaPR = null;
			try {

				context = JNDILookupClass.getInitialContext();
				

				agenciaPR = (AgenciaPersistenceRemote) context
						.lookup("ejb:AgenciaEAR/agenciaEJB/AgenciaPersistence!br.iff.pooa20141.agencia.model.controller.AgenciaPersistenceRemote");
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
		Agencia agencia = agenciaPR.inserir(uid,"Nome", "cnpj", "email");
		assertEquals(agencia.getUid(), uid);
		agenciaPR.delete(uid);
	}
	@Test
	public void testupdate() {
		String uid = UUID.randomUUID().toString();
		agenciaPR.inserir(uid,"Nome", "cnpj", "email");

		Agencia agenciaUp = agenciaPR.update(uid, "Nome", "cnpj1", "email");

		assertEquals(agenciaUp.getCnpj(), "cnpj1");
		agenciaPR.delete(uid);
	}

	@Test
	public void testfind() {
		String uid = UUID.randomUUID().toString();
		agenciaPR.inserir(uid, "Nome", "cnpj", "email");

		Agencia agenciaUp = agenciaPR.find(uid);

		assertEquals(agenciaUp.getNome(), "Nome");
		agenciaPR.delete(uid);
	}
	@Test
	public void testdelete() {
		String uid = UUID.randomUUID().toString();
		agenciaPR.inserir(uid,"Nome", "cnpj", "email");

		agenciaPR.delete(uid);
		assertEquals(agenciaPR.find(uid),null);
	}


}


