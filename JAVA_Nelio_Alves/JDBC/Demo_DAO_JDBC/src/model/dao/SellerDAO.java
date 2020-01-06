package model.dao;

import java.util.List;

import model.entities.Seller;

public interface SellerDAO {
	
	void insert(SellerDAO obj);
	void update(SellerDAO obj);
	void deleteById(Integer id);
	SellerDAO findById(Integer id);
	List<SellerDAO> findAll();
	
}
