package com.sapient.testing;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sapient.daos.StudentDAO;
import com.sapient.entity.Student;

public class HibernateTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() {

		Student stud = new Student(101, "ABC", "IT", 80, 50, 40, 70);
		StudentDAO dao = new StudentDAO();
		int result = (int) dao.add(stud);
		System.out.println(result);
	}

	@Test
	public void testFind() {

		StudentDAO dao = new StudentDAO();
		Student result = dao.find(101);
		System.out.println(result);

	}

	@Test
	public void testFindAll() {

		try {
			StudentDAO dao = new StudentDAO();
			List<Student> studentList = dao.findAll();

			for (Student student : studentList) {
				System.out.println(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDelete() {

		try {
			StudentDAO dao = new StudentDAO();
			dao.delete(101);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdate() {

		try {
			StudentDAO dao = new StudentDAO();

			Student stud = new Student(101, "ABC", "CSE", 70, 60, 67, 45);
			stud = dao.update(stud);

			System.out.println(stud);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
