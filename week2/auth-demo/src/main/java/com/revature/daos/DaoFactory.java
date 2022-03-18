package com.revature.daos;

/*
 * Singleton + Factory design pattern
 */
public class DaoFactory {

	private static DaoFactory df;
	private EmployeeDao ed;

	// private constructor to restrict instantiation of DaoFactory class
	private DaoFactory() {
	}

	// public getter to retrieve an existing daofactory instance otherwise creates one.
	public static synchronized DaoFactory getDAOFactory() {
		if (df == null) {
			df = new DaoFactory();
		}
		return df;
	}
	
	public EmployeeDao getEmployeeDao() {
		if(ed == null) {
			ed = new EmployeePostgres();
		}
		return ed;
	}
}
