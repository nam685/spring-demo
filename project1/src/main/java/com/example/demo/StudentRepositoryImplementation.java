package com.example.demo;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

@Repository
public class StudentRepositoryImplementation implements StudentRepositoryCustom {
	
	EntityManager em;
	
	@Override
	public Iterable<Student> findByFirstOrLastName(String name) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Student> cq = cb.createQuery(Student.class);
		
		Root<Student> student = cq.from(Student.class);
		Predicate firstName = cb.equal(student.get("firstName"), name);
		Predicate lastName = cb.equal(student.get("lastName"), name);
		Predicate eitherName = cb.or(firstName, lastName);
		
		cq.where(eitherName);
		
		TypedQuery<Student> query = em.createQuery(cq);
		return query.getResultList();
	};
}
