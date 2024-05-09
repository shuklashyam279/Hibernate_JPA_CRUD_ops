package com.jspider.hibernate_jpa_crud_operation.dao;

import java.util.List;

import javax.persistence.*;
import com.jspider.hibernate_jpa_crud_operation.dto.Company;

public class CompanyDao {
	/*
	 * Below 3 lines of code, is creating connection with DB with help of
	 * persistence.xml file. Persistence.xml file is handles DB connection related
	 * code and some other instructions. <persistence-unit name="jpa"> the value in
	 * this attribute of persistence.xml file must be same as the parameter in given
	 * createEntityManagerFactory("jpa") method. This value can be any String or
	 * Character.
	 */

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	EntityManager entityManager = emf.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	// method
	public Company saveCompanyDao(Company company) {
		/*
		 * begin(), commit() & rollback() method of EntityTransaction (Interface) is
		 * used to assure that DB stay concurrent. To lock and unlock the process for
		 * each transactions in DB.
		 */
		entityTransaction.begin();
		entityManager.persist(company); // to insert data in DB where parameter is a object.
		entityTransaction.commit();

		return company;
	}

	//method
//	public int deleteCompanyByIdDao(int id) {
//		/*
//		 * finding entity with help find method and storing in Company type of Reference 
//		 * then, passing it to remove method for transaction.
//		 */
//		Company company = entityManager.find(Company.class, id);
//		if(company!= null) {
//		entityTransaction.begin();
//		entityManager.remove(company);
//		entityTransaction.commit();
//		return 1;
//		}
//		return 0;
//	}
	
	
//	method
	public int deleteCompanyByIdDao(int id) {
		String deleteQuery = "delete Company com where com.id = ?1";		//JPQL. It uses position parameter 
		Query query = entityManager.createQuery(deleteQuery);
		
		query.setParameter(1, id);
		entityTransaction.begin();
		int toReturn = query.executeUpdate();
		entityTransaction.commit();
		return toReturn;
	}

	//method
//	public int deleteCompanyByIdDao(int id) {
//		String deleteQuery = "Delete Company com where com.id = :cId";		//JPQL. It uses Named parameter 
//		Query query = entityManager.createQuery(deleteQuery);
//		
//		query.setParameter("cId", deleteQuery);
//		entityTransaction.begin();
//		int toReturn = query.executeUpdate();
//		entityTransaction.commit();
//		return toReturn;
//	}
	
	// method
	public Company getCompanyByIdDao(int id) {
		Company company = entityManager.find(Company.class, id);
		if(company != null) {
			return company;
		}
		return null;
	}

	// method
	public Company updateCompanyByIdDao(int id, String email) {
		Company company = getCompanyByIdDao(id);
		if (company != null) {
			company.setEmail(email);
			entityTransaction.begin();
			entityManager.merge(company);		// used to update attribute
			entityTransaction.commit();
			return company;
		}
		return null;
	}
	
	// method
	public Company updateCompanyByIdDao(int id, int empCount) {
		Company company = getCompanyByIdDao(id);
		if (company != null) {
			company.setNoOfEmployee(empCount);
			entityTransaction.begin();
			entityManager.merge(company);		// used to update attribute
			entityTransaction.commit();
			return company;
		}
		return null;
	}

		// method
	public List<Company> displayAllCompanyDao() {
		//JPQL syntax for select all elements, where 'c' is alias.
		String selectAll = "SELECT c FROM Company c";
		// Reading the query using createQuery("...") method.
		Query query = entityManager.createQuery(selectAll);
		
		return query.getResultList();
	}
	

}
