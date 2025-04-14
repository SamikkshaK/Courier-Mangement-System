package entities;

public class Employee {
    private int id;
    private String name;
    private int contactNumber;
    private String email;
    private String role;
    private float salary;

    public Employee() {}

    public Employee(String name, int contactNumber, String email, String role, float salary) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.email = email;
        this.role = role;
        this.salary = salary;
    }

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }
    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email; 
		
	}
	public String getRole() {
	    return role;
	}
	public void setRole(String role) {
	    this.role = role;
	}
	public float getSalary() {
	    return salary;
	}
	public void setSalary(float salary) {
	    this.salary = salary;
	}
	
}
