package com.sapient.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HiberUtils {

	private static SessionFactory factory;

	// Use static Factory Singleton Pattern

	static {
		try {

			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getFactory() {

		return factory;
	}
}
