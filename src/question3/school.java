package question3;
import java.util.ArrayList;
import java.util.List;

public class school{
	private ArrayList<Teacher>teachers;
	private List<Student> students;
	private static int totalMoneyEarned;
	private static int totalMoneySpent;
	public school(ArrayList<Teacher> teachers, List<Student> students) {
		this.teachers = teachers;
		this.students = students;
	}
	public ArrayList<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(ArrayList<Teacher> teachers) {
		this.teachers = teachers;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public void addTeacher(Teacher teacher)
	{
		teachers.add(teacher);
	}
	public void addStudent(Student student)
	{
		students.add(student);
	}
	public int getTotalMoneyEarned()
	{
		return totalMoneyEarned;
	}
	public static void updatealMoneyEarned(int moneyEarned)
	{
		totalMoneyEarned+=moneyEarned;
	}
	public static int getTotalMoneyEarnedd()
	{
		return totalMoneyEarned;
	}
	
	public int getTotalMoneySpent()
	{
		return totalMoneySpent;
	}
	public static void updateTotalMoneySpent(int moneyspent) 
	{
		totalMoneyEarned-=moneyspent;
	}
	@Override
	public String toString() {
		return "School [teachers=" + teachers + ", students=" + students + "]";
	}
	
}