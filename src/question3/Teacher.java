package question3;



public class Teacher {
	private int id;
	private String name;
	private int salary;
	private int salaryEarned;
	
	public Teacher(int id, String name, int salary)
	{
		
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.salaryEarned=0;
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
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getSalaryEarned() {
		return salaryEarned;
	}
	public void setSalaryEarned(int salary) {
		this.salaryEarned = salaryEarned;
	}
	
	//key public
	public void receiveSalary(int salary) {
		if(school.getTotalMoneyEarnedd()>salary) {
		this.salaryEarned+=salary;
		//Trigger update in school
		school.updateTotalMoneySpent(salary);
		}else{
			System.out.println("No enough money for this payment");
		}
	}
	@Override
	public String toString() {
		return "\nTeacher'sname:" + this.name + "\n Total salaryEarned so far Frw:" + this.salaryEarned;
	}
	
	

}