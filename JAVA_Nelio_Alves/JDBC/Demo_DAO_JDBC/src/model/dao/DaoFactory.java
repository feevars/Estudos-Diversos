package model.dao;

import db.DB;
import model.dao.implement.SellerDaoJDBC;

public class DaoFactory {

	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC(DB.getConnection());
		//não expõe implementação, apenas interface
	}
}
