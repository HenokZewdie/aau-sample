package order;

import com.studentRegistrar.aau.model.Branch;
import com.studentRegistrar.aau.model.Customer;

public class OrderResponse {

	private Customer customer;
	private Branch branch;
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	
	
}
