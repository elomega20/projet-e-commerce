package com.el.Junit.payement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.el.beans.Payement;
import com.el.database.daofactory.DaoFactory;
import com.el.database.payements.PayementDao;
import com.el.exceptions.DaoException;

class AjouterPayementTest {

	@Test
	void testAjouterPayement() {
        DaoFactory daoFactory = DaoFactory.getInstance();
        PayementDao payementDao = daoFactory.getPayementDao();
        
        Payement payement = new Payement();
        payement.setNumeroTelephone("777778800");
        payement.setModePayement("orangeMoney");
         try {
			boolean test = payementDao.ajouterPayement(payement);
			assertEquals(true, test);
		} catch (DaoException e) {
            System.out.println(e.getMessage());
		}
	}

}
