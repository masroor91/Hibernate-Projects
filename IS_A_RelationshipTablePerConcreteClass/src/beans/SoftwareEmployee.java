package beans;

public class SoftwareEmployee extends Employee {
	
	private String tool;
	
	public SoftwareEmployee() {
		// TODO Auto-generated constructor stub
	}

	
	public SoftwareEmployee(int id, String name, String email, int salary, String tool) {
		super(id, name, email, salary);
		this.tool = tool;
	}



	public String getTool() {
		return tool;
	}

	public void setTool(String tool) {
		this.tool = tool;
	}
	

}
