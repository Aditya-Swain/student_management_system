package com.org.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.org.dao.AdminDao;
import com.org.dto.Admin;
import com.org.utility.Helper;
@Component
public class AdminDaoImpl implements AdminDao {

	@Override
	public void saveAdmin(Admin admin) {
		EntityManagerFactory emf = Helper.getFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.merge(admin);
		et.commit();
		
	}

	@Override
	public Admin fetchById(int id) {
		EntityManagerFactory emf = Helper.getFactory();
		EntityManager em = emf.createEntityManager();
		
		
		return em.find(Admin.class, id);
		
		
		
	}

	@Override
	public List<Admin> login(String email, String password) {
		EntityManagerFactory emf = Helper.getFactory();
		EntityManager em = emf.createEntityManager();
		
		String jpql = "SELECT a FROM Admin a WHERE email=?1 AND password=?2";
		Query query = em.createQuery(jpql);
		query.setParameter(1, email);
		query.setParameter(2, password);
		
		return query.getResultList();
		
		
		

		
	}

}
