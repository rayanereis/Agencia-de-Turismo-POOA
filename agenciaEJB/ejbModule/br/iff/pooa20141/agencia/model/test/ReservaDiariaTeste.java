package br.iff.pooa20141.agencia.model.test;
import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.UUID;

import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.iff.pooa20141.agencia.model.controller.ReservadiariaPersistenceRemote;
import br.iff.pooa20141.agencia.model.controller.HotelPersistenceRemote;
import br.iff.pooa20141.agencia.model.entity.Reservadiaria;
import br.iff.pooa20141.agencia.model.entity.Hotel;


public class ReservaDiariaTeste {

	private HotelPersistenceRemote hotelPR;
	private ReservadiariaPersistenceRemote reservaDiariaPR;

	Hotel hotel;
	String uidHotel = UUID.randomUUID().toString();
	
	@Before
	public void setUp() throws Exception {
		Context context = null;

		reservaDiariaPR = null;
		hotelPR= null;

		try {

			context = JNDILookupClass.getInitialContext();

			hotelPR = (HotelPersistenceRemote) context
					.lookup("ejb:AgenciaEAR/agenciaEJB/HotelPersistence!br.iff.pooa20141.agencia.model.controller.HotelPersistenceRemote");

		} catch (NamingException e) {
			e.printStackTrace();

		}
		try {

			context = JNDILookupClass.getInitialContext();

			reservaDiariaPR = (ReservadiariaPersistenceRemote) context
					.lookup("ejb:AgenciaEAR/agenciaEJB/ReservadiariaPersistence!br.iff.pooa20141.agencia.model.controller.ReservadiariaPersistenceRemote");

		} catch (NamingException e) {
			e.printStackTrace();

		}

		uidHotel = UUID.randomUUID().toString();
		hotel = hotelPR.inserir(uidHotel,"Nome", "cnpj", "cidade", "pais");
		
	}

	@After
	public void tearDown() throws Exception {
		
		hotelPR.delete(uidHotel);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testInserir() {

		String uid = UUID.randomUUID().toString();
		
		
		Reservadiaria reservaDiaria =reservaDiariaPR.inserir(uid,new Date("12/08/2014"),new Date("14/08/2014"), 120,224.2f , hotel);
			
		assertEquals(reservaDiaria.getUid(), uid);
		reservaDiariaPR.delete(uid);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testupdate() {
		
		
		String uid = UUID.randomUUID().toString();
		reservaDiariaPR.inserir(uid,new Date("12/08/2014"),new Date("14/08/2014"), 120,224.2f , hotel);

		Reservadiaria reservaDiariaUp =reservaDiariaPR.update(uid,new Date("12/08/2014"),new Date("14/08/2014"), 120,224.2f , hotel);

		assertEquals(reservaDiariaUp.getVagasdisponiveis(), 120,0);
		reservaDiariaPR.delete(uid);
	}

	@Test
	public void testfind() {
		
		String uid = UUID.randomUUID().toString();
		reservaDiariaPR.inserir(uid,new Date("12/08/2014"),new Date("14/08/2014"), 100,224.2f , hotel);
		
		Reservadiaria reservaDiariaUp =reservaDiariaPR.find(uid);

		assertEquals(reservaDiariaUp.getVagasdisponiveis(), 100,0);
		reservaDiariaPR.delete(uid);
	}
	@Test
	public void testdelete() {
		
		String uid = UUID.randomUUID().toString();
		reservaDiariaPR.inserir(uid,new Date("12/08/2014"),new Date("14/08/2014"), 120,224.2f , hotel);
		reservaDiariaPR.delete(uid);
		assertEquals(reservaDiariaPR.find(uid),null);
	}


}