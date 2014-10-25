package br.iff.pooa20141.agencia.model.test;
import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.UUID;

import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.iff.pooa20141.agencia.model.controller.ReservapassagemPersistenceRemote;
import br.iff.pooa20141.agencia.model.controller.AgenciaPersistenceRemote;
import br.iff.pooa20141.agencia.model.entity.Reservapassagem;
import br.iff.pooa20141.agencia.model.entity.Agencia;


public class ReservaPassagemTeste {

	private AgenciaPersistenceRemote agenciaPR;
	private ReservapassagemPersistenceRemote reservaPassagemPR;

	Agencia agencia;
	String uidAgencia = UUID.randomUUID().toString();
	
	@Before
	public void setUp() throws Exception {
		Context context = null;

		reservaPassagemPR = null;
		agenciaPR= null;

		try {

			context = JNDILookupClass.getInitialContext();

			agenciaPR = (AgenciaPersistenceRemote) context
					.lookup("ejb:AgenciaEAR/agenciaEJB/AgenciaPersistence!br.iff.pooa20141.agencia.model.controller.AgenciaPersistenceRemote");

		} catch (NamingException e) {
			e.printStackTrace();

		}
		try {

			context = JNDILookupClass.getInitialContext();

			reservaPassagemPR = (ReservapassagemPersistenceRemote) context
					.lookup("ejb:AgenciaEAR/agenciaEJB/ReservapassagemPersistence!br.iff.pooa20141.agencia.model.controller.ReservapassagemPersistenceRemote");

		} catch (NamingException e) {
			e.printStackTrace();

		}

		uidAgencia = UUID.randomUUID().toString();
		agencia = agenciaPR.inserir(uidAgencia, "Nome", "cnpj", "email");
		
	}

	@After
	public void tearDown() throws Exception {
		
		agenciaPR.delete(uidAgencia);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testInserir() {
		Date data;
		String uid = UUID.randomUUID().toString();
		data = new Date("12/08/2014");
		Reservapassagem reservaPassagem = reservaPassagemPR.inserir(uid,data,"Fortaleza", 13,
						20,"Rio de Janeiro", 990, agencia, 100);
						
						
		assertEquals(reservaPassagem.getUid(), uid);
		reservaPassagemPR.delete(uid);
	}

	@Test
	public void testupdate() {
		Date data;
		
		String uid = UUID.randomUUID().toString();
		data = new Date("12/08/2014");
		reservaPassagemPR.inserir(uid,data,"Fortaleza", 13,20,"Rio de Janeiro", 990, agencia, 100);

		Reservapassagem reservaPassagemUp = reservaPassagemPR.update(uid,data,"Fortaleza", 13,20,"Vitoria", 990, agencia,120);

		assertEquals(reservaPassagemUp.getOrigem(), "Vitoria");
		reservaPassagemPR.delete(uid);
	}

	@Test
	public void testfind() {
		Date data;
		
		data = new Date("12/08/2014");
		String uid = UUID.randomUUID().toString();
		reservaPassagemPR.inserir(uid,data,"Fortaleza", 13,20,"Rio de Janeiro", 990, agencia, 100);

		Reservapassagem reservaPassagemUp = reservaPassagemPR.find(uid);

		assertEquals(reservaPassagemUp.getOrigem(), "Rio de Janeiro");
		reservaPassagemPR.delete(uid);
	}
	@Test
	public void testdelete() {
		Date data;
		
		data = new Date("12/08/2014");
		String uid = UUID.randomUUID().toString();
		reservaPassagemPR.inserir(uid,data,"Fortaleza", 13,20,"Rio de Janeiro", 990, agencia, 100);

		reservaPassagemPR.delete(uid);
		assertEquals(reservaPassagemPR.find(uid),null);
	}


}