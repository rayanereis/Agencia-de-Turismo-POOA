package br.iff.pooa20141.agencia.model.test;

import static org.junit.Assert.assertEquals;

import java.util.UUID;

import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.iff.pooa20141.agencia.model.controller.HotelPersistenceRemote;
import br.iff.pooa20141.agencia.model.controller.QualificacaoHotelPersistenceRemote;
import br.iff.pooa20141.agencia.model.controller.UsuarioPersistenceRemote;
import br.iff.pooa20141.agencia.model.entity.Hotel;
import br.iff.pooa20141.agencia.model.entity.Qualificacaohotel;
import br.iff.pooa20141.agencia.model.entity.Usuario;


public class QualificacaoHotelTeste {

	private QualificacaoHotelPersistenceRemote qualificacaoHotelPR;
	private UsuarioPersistenceRemote usuarioPR;
	private HotelPersistenceRemote hotelPR;
	Usuario usuario;
	Hotel hotel;
	String uidUsuario = UUID.randomUUID().toString();
	String uidHotel = UUID.randomUUID().toString();

	@Before
	public void setUp() throws Exception {
		Context context = null;
		qualificacaoHotelPR = null;
		usuarioPR = null;
		hotelPR = null;
		
		try {

			context = JNDILookupClass.getInitialContext();

			usuarioPR = (UsuarioPersistenceRemote) context
					.lookup("ejb:AgenciaEAR/agenciaEJB/UsuarioPersistence!br.iff.pooa20141.agencia.model.controller.UsuarioPersistenceRemote");

		} catch (NamingException e) {
			e.printStackTrace();

		}
		try {

			context = JNDILookupClass.getInitialContext();

			hotelPR = (HotelPersistenceRemote) context
					.lookup("ejb:AgenciaEAR/agenciaEJB/HotelPersistence!br.iff.pooa20141.agencia.model.controller.HotelPersistenceRemote");

		} catch (NamingException e) {
			e.printStackTrace();

		}
		try {

			context = JNDILookupClass.getInitialContext();

			qualificacaoHotelPR = (QualificacaoHotelPersistenceRemote) context
					.lookup("ejb:AgenciaEAR/agenciaEJB/QualificacaoHotelPersistence!br.iff.pooa20141.agencia.model.controller.QualificacaoHotelPersistenceRemote");

		} catch (NamingException e) {
			e.printStackTrace();

		}
		uidUsuario = UUID.randomUUID().toString();
		usuario = usuarioPR.inserir(uidUsuario,"email", "nome", "senha");
		
		uidHotel = UUID.randomUUID().toString();
		hotel = hotelPR.inserir(uidHotel,"Nome", "cnpj", "cidade", "pais");
	}

	@After
	public void tearDown() throws Exception {
		usuarioPR.delete(uidUsuario);
		hotelPR.delete(uidHotel);
	}

	@Test
	public void testInserir() {
		String uid = UUID.randomUUID().toString();
		Qualificacaohotel qualificacaoHotel = qualificacaoHotelPR.inserir(uid,"comentario",true,2, 
				usuario,hotel, 4);

		assertEquals(qualificacaoHotel.getUid(), uid);
		qualificacaoHotelPR.delete(uid);
	}
	
	@Test
	public void testupdate() {
		String uid = UUID.randomUUID().toString();
		qualificacaoHotelPR.inserir(uid,"comentario",true,2,usuario, hotel,4);

		Qualificacaohotel qualificacaoHotelUp = qualificacaoHotelPR.update(uid,"comentario2",true,2, 
				usuario,hotel, 4);
		assertEquals(qualificacaoHotelUp.getComentario(), "comentario2");
		qualificacaoHotelPR.delete(uid);
	}
	
	@Test
	public void testfind() {
		String uid = UUID.randomUUID().toString();
		qualificacaoHotelPR.inserir(uid,"comentario",true,2, 
				usuario,hotel, 4);

		Qualificacaohotel qualificacaoHotelUp = qualificacaoHotelPR.find(uid);

		assertEquals(qualificacaoHotelUp.getComentario(), "comentario");
		qualificacaoHotelPR.delete(uid);
	}
	@Test
	public void testdelete() {
		String uid = UUID.randomUUID().toString();
		qualificacaoHotelPR.inserir(uid,"comentario",true,2, 
				usuario,hotel, 4);


		qualificacaoHotelPR.delete(uid);
		assertEquals(qualificacaoHotelPR.find(uid),null);
	}


}