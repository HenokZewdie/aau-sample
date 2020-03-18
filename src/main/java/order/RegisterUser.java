package order;

import java.util.Scanner;

import com.studentRegistrar.aau.model.Branch;
import com.studentRegistrar.aau.model.Customer;

public class RegisterUser {

	public Customer customer(){
		Scanner scanner = new Scanner(System.in);
		Customer customer = new Customer();
		System.out.println("Enter First Name: ");
		String firstName = scanner.nextLine();
		System.out.println("Enter Last Name: ");
		String lastName = scanner.nextLine();
		System.out.println("Enter Phone Number: ");
		String phone = scanner.nextLine();
		System.out.println("Enter Branch name: ");
		String branchName = scanner.nextLine();
		
		customer.setCustName(firstName);
		customer.setCustLastName(lastName);
		customer.setPhone(phone);
		customer.setBranch(branchName);
		scanner.close();
		return customer;
	}

	public Branch branch() {
		Scanner scanner = new Scanner(System.in);
		Branch branch = new Branch();
		System.out.println("Enter Branch name: ");
		String branchName = scanner.nextLine();
		System.out.println("Enter Phone Number: ");
		String phone = scanner.nextLine();
		
		branch.setBranchName(branchName);
		branch.setCustPhone(phone);
	
		scanner.close();
		return branch;
	}
}
