package dao;

import javax.persistence.EntityManager;

import entites.Category;
import utils.JpaUtil;

public class CategoryDAO {
	private EntityManager em;

	public CategoryDAO() {
		this.em = JpaUtil.getEntityManager();
	}
	
	public Category create(Category cate) {
		try {
			this.em.getTransaction().begin();
			this.em.persist(cate);
			this.em.flush();
			this.em.getTransaction().commit();
			
			return cate;
		} catch (Exception e) {
			this.em.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}
}
