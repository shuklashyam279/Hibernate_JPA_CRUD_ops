package com.jspider.hibernate_jpa_crud_operation.controller;

import java.util.List;
import java.util.Scanner;

import com.jspider.hibernate_jpa_crud_operation.dto.Company;
import com.jspider.hibernate_jpa_crud_operation.service.CompanyService;

public class CompanyController {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		CompanyService companyService = new CompanyService();

		while (true) {
			System.out.println();
			System.out.println("Choose Your Given  Options :- ");
			System.out.print("\n     1.  Create a new Company" +
							 "\n     2.  Delete a Company" + 
							 "\n     3.  Display All Company Details" + 
							 "\n     4.  Display Specific Company" + 
							 "\n     5.  Update Specific Company" + 
							 "\n     6.  Exit\n");
			System.out.print("Enter Your Option   :   ");
			int option = scanner.nextInt();

			switch (option) {
				case 1:
					createNewCompany(scanner, companyService);
					break;
				case 2:
					deleteCompanyByIdController(scanner, companyService);
					break;
				case 3:
					displayAllCompanyController(companyService);
					break;
				case 4:
					getCompanyByIdController(scanner, companyService);
					break;
				case 5:
					updateCompanyByIDController(scanner, companyService);
					break;
				case 6:
					scanner.close();
					exit();
					break;
				default:
					System.out.println("Invalid choice. Try again.");
			}
		}
	}

	private static void updateCompanyByIDController(Scanner scanner, CompanyService companyService) {
		System.out.println("Enter Company ID to update: ");
		int id = scanner.nextInt();
		System.out.println();
		System.out.print("\n     1.  Update Company E-mail" + "\n     2.  Update Company No. Of Employee");
		System.out.println("Choose Your Given  Options :  ");
		int choise = scanner.nextInt();
		switch (choise) {
		case 1:
			System.out.print("Please Enter New Email Address  :  ");
			String email = scanner.next();
			companyService.updateProductByIDService(id, email);
			if (companyService.updateProductByIDService(id, email) != null) {
				System.out.println("Updated Successfully!");
			} else {
				System.out.println("Failed To Update!");
			}

			break;
		case 2:
			System.out.print("Please Enter No. of Employee : 	");
			int empCount = scanner.nextInt();
			companyService.updateCompanyByIdService(id, empCount);
			if (companyService.updateCompanyByIdService(id, empCount) != null) {
				System.out.println("Updated Successfully!");
			} else {
				System.out.println("Failed To Update!");
			}
			break;
		default:
			System.out.println("Invalid Choice! Please try Again.");
		}
	}

	private static void getCompanyByIdController(Scanner scanner, CompanyService companyService) {
		System.out.print("Enter Company ID :  ");
		int id = scanner.nextInt();
		Company company = companyService.getCompanyByIdService(id);
//		displayHeader(company);
		System.out.println(company);
	}

	// Method
	public static void createNewCompany(Scanner scanner, CompanyService companyService) {
		System.out.print("Enter Company ID :  ");
		int id = scanner.nextInt();
		System.out.print("Enter Company Name :  ");
		String name = scanner.next();
		System.out.print("Enter Company email :  ");
		String email = scanner.next();
		System.out.print("Enter Company Address :  ");
		String address = scanner.next();
		scanner.nextLine();
		System.out.print("Enter No. of Employees work in Company :  ");					// Done
		int noOfEmployee = scanner.nextInt();

		Company company = new Company(id, name, email, address, noOfEmployee);
		company = companyService.saveCompanyService(company);
		System.out.println("");
		if (company != null) {
			System.out.println("Data Inserted Successfully..");
		} else if (company == null) {
			System.out.println("Something Went Wrong...");
		}
	}

	// Method
	public static void deleteCompanyByIdController(Scanner scanner, CompanyService companyService) {
		System.out.print("Enter Company ID :  ");
		int id = scanner.nextInt();
		int result = companyService.deleteCompanyByIdService(id);
		if (result==1) {
			System.out.println("Data Deleted Successfully..");							// Done
		} else if(result ==0){
			System.out.println("Something Went Wrong...");
		}
	}

	// Method
	private static void displayAllCompanyController(CompanyService companyService) {
		List<Company> companies = companyService.displayAllCompanyController();
		displayHeader(companies);

	}

	// utility method
	private static void displayHeader(List<Company> companies) {
		System.out.println();
		System.out.println("Company :");
		System.out.println("+---------+----------------+----------------+-------------+-----------------------+");
		System.out.println("| ID      | Name           | E-mail         | Employee No.| Address               |");
		System.out.println("+---------+----------------+----------------+-------------+-----------------------+");
		for (Company company : companies) {
			System.out.printf("| %-5d   | %-14s | %-15s| %-10d  | %-15s      |\n", company.getId(), company.getName(),
					company.getEmail(), company.getNoOfEmployee(), company.getAddress());
			System.out.println("+---------+----------------+----------------+-------------+-----------------------+");
		}
	}

	// utility method
	private static void displayHeader(Company company) {
		System.out.println();
		System.out.println("Company :");
		System.out.println("+---------+----------------+----------------+-------------+-----------------------+");
		System.out.println("| ID      | Name           | E-mail         | Employee No.| Address               |");
		System.out.println("+---------+----------------+----------------+-------------+-----------------------+");
		System.out.printf("| %-5d   | %-14s | %-15s| %-10d  | %-15s      |\n", company.getId(), company.getName(),
				company.getEmail(), company.getNoOfEmployee(), company.getAddress());
		System.out.println("+---------+----------------+----------------+-------------+-----------------------+");
	}

	// Method
	private static void exit() {
		System.out.print("Exiting System");
		int i = 10;
		while (i != 0) {
			System.out.print(".");
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i--;
		}
		System.out.println();
		System.out.println("Thank You !!!");
		java.lang.System.exit(0);
	}
	
	
}
