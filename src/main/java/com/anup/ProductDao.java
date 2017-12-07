package com.anup;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.anup.entity.Product;

@Repository
public class ProductDao {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void save(Product p) {
		em.persist(p);
	}

	@Transactional
	public Product getByProductId(Integer id) {
		Product oldProduct = em.find(Product.class, id);

		return oldProduct;
	}

	@Transactional
	public void update(Product p) {
		em.merge(p);
	}

}
