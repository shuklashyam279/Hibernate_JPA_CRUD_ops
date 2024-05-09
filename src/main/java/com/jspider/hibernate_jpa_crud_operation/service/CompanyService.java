package com.jspider.hibernate_jpa_crud_operation.service;

import java.util.List;

import com.jspider.hibernate_jpa_crud_operation.dao.CompanyDao;
import com.jspider.hibernate_jpa_crud_operation.dto.Company;

public class CompanyService {

	CompanyDao companyDao = new CompanyDao();

	// method
	public Company saveCompanyService(Company company) {
		if(company instanceof Company) {
		return companyDao.saveCompanyDao(company);
		}
		return null;
	}
	
	// method
	public int deleteCompanyByIdService(int id) {
		if (id > 0 && companyDao.deleteCompanyByIdDao(id)>0) {
			return 1;
		}
		return 0;
	}
	
	// method
	public List<Company> displayAllCompanyController() {
		
		return companyDao.displayAllCompanyDao();
	}

	// method
	public Company getCompanyByIdService(int id) {
		Company company =companyDao.getCompanyByIdDao(id);
		if(company != null) {
			return company;
		}
		return null;
	}
	
	// methods
	public Company updateCompanyByIdService(int id, int empCount) {
		
		return companyDao.updateCompanyByIdDao(id, empCount);
	}
	
	// methods
	public Company updateProductByIDService(int id, String email) {
		

		return companyDao.updateCompanyByIdDao(id, email);
	}
		
}
