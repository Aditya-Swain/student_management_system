package com.org.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.org.dao.StudentDao;
import com.org.dto.Student;
import com.org.utility.Helper;
@Component
public class StudentDaoImpl implements StudentDao {

	@Override
	public void saveAndUpdateStudent(Student student) {
			EntityManagerFactory emf = Helper.getFactory();
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			
			et.begin();
			em.merge(student);
			et.commit();
	}

	@Override
	public List<Student> fetchAllStudent() {
		EntityManagerFactory emf = Helper.getFactory();
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select s from Student s";
		Query query = em.createQuery(jpql);
		List<Student> list = query.getResultList();
		
		return list;
	}

	@Override
	public Student fetchStudentById(int id) {
		EntityManagerFactory emf = Helper.getFactory();
		EntityManager em = emf.createEntityManager();
		
		return em.find(Student.class, id);
		
	}

	@Override
	public void removeStudentById(int id) {
		EntityManagerFactory emf = Helper.getFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Student student = em.find(Student.class, id);
		
		et.begin();
		em.remove(student);
		et.commit();
		
		
	}

}
