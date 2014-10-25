package br.iff.pooa20141.agencia.model.test;
import static org.junit.Assert.assertEquals;

import java.util.UUID;

import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.iff.pooa20141.agencia.model.controller.HotelPersistenceRemote;
import br.iff.pooa20141.agencia.model.entity.Hotel;



public class HotelTeste {
	private HotelPersistenceRemote hotelPR;

	@Before
	public void setUp() throws Exception {
		
			Context context = null;
			hotelPR = null;
			try {

				context = JNDILookupClass.getInitialContext();

				hotelPR = (HotelPersistenceRemote) context
						.lookup("ejb:AgenciaEAR/agenciaEJB/HotelPersistence!br.iff.pooa20141.agencia.model.controller.HotelPersistenceRemote");

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
		Hotel hotel = hotelPR.inserir(uid,"Nome", "cnpj", "cidade", "pais");
		assertEquals(hotel.getUid(), uid);
		hotelPR.delete(uid);
	}
	
 @Test
	public void testupdate() {
		String uid = UUID.randomUUID().toString();
		hotelPR.inserir(uid,"Nome", "cnpj", "cidade", "pais");

		Hotel hotelUp = hotelPR.update(uid,"Nome1", "cnpj", "cidade", "pais");

		assertEquals(hotelUp.getNome(), "Nome1");
		hotelPR.delete(uid);
	}

 @Test
	public void testfind() {
		String uid = UUID.randomUUID().toString();
		hotelPR.inserir(uid,"Nome", "cnpj", "cidade", "pais");

		Hotel hotelUp = hotelPR.find(uid);

		assertEquals(hotelUp.getNome(), "Nome");
		hotelPR.delete(uid);
	}
@Test
	public void testdelete() {
		String uid = UUID.randomUUID().toString();
		hotelPR.inserir(uid,"Nome", "cnpj", "cidade", "pais");

		hotelPR.delete(uid);
		assertEquals(hotelPR.find(uid),null);
	}
	


}


