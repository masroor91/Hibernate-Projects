package beans;

public class Admin extends Employee {
	
	private String branch;
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public Admin(int id, String name, String email, int salary, String branch) {
		super(id, name, email, salary);
		this.branch = branch;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	
	
}
