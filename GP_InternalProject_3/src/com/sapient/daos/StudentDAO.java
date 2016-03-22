package com.sapient.daos;

import java.io.Serializable;
import java.util.*;

import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sapient.entity.Student;
import com.sapient.ifaces.MyDAO;
import com.sapient.utils.HiberUtils;
import com.sun.org.apache.xpath.internal.operations.Gte;

public class StudentDAO implements MyDAO<Student> {

	SessionFactory factory;
	Session session;
	Transaction tx;

	@Override
	public Serializable add(Student studentObj) {

		Integer key = null;
		try {

			factory = HiberUtils.getFactory();
			session = factory.openSession();
			tx = session.beginTransaction();
			key = (Integer) session.save(studentObj);
			tx.commit();
			factory.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return key;
	}

	@Override
	public Student find(Serializable obj) {

		factory = HiberUtils.getFactory();
		session = factory.openSession();
		tx = session.beginTransaction();
		Student studentObj = (Student) session.get(Student.class, (int) obj);
		tx.commit();
		factory.close();

		return studentObj;
	}

	@Override
	public List<Student> findAll() {

		factory = HiberUtils.getFactory();
		session = factory.openSession();

		@SuppressWarnings("unchecked")
		List<Student> studentList = session.createQuery("from Student").list();

		session.close();
		factory.close();

		return studentList;
	}

	@Override
	public Student update(Student studentObj) {

		factory = HiberUtils.getFactory();
		session = factory.openSession();
		tx = session.beginTransaction();
		session.update(studentObj);
		tx.commit();
		session.close();
		factory.close();

		return studentObj;
	}

	@Override
	public boolean delete(Serializable obj) {

		factory = HiberUtils.getFactory();
		session = factory.openSession();
		tx = session.beginTransaction();
		session.delete((Student) session.get(Student.class, (Integer) obj));
		tx.commit();
		session.close();
		factory.close();

		return true;
	}

	@Override
	public List<Student> findTopThree(Serializable t) {

		factory = HiberUtils.getFactory();
		session = factory.openSession();
		String hql = "FROM Student S WHERE S.department='" + t + "' ORDER BY S.total DESC";
		Query query = session.createQuery(hql);
		query.setMaxResults(3);

		List<Student> results = (List<Student>) query.list();
		return results;
	}

}
