package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	/*
	 * Không đặt static em & emf
	 * https://stackoverflow.com/a/8621429
	 * https://stackoverflow.com/a/54722284/5938111
	 */

	public static EntityManagerFactory getEMFactory() {
		EntityManagerFactory factory =
			Persistence.createEntityManagerFactory("SP22B2_SOF3011_IT16301");
		return factory;
	}

	public static EntityManager getEntityManager() {
		EntityManager em =
			JpaUtil.getEMFactory().createEntityManager();
		return em;
	}
}
