package question3;
import java.util.ArrayList;
import java.util.List;

import Entities.all.School;
import Entities.all.Student;
import Entities.all.Teacher;

public class TestSchool {

	public static void main(String[] args) {
		//creation of teachers
		Teacher joas=new Teacher(1, "Niyitegeka Jean Joas",300000);
		Teacher emmy=new Teacher(2, "Bizimana Emmanuel",230000);
		Teacher k=new Teacher(3, "Kamana Jean Aime",150000);
		ArrayList<Teacher>teacherlList=new ArrayList<>();
		teacherlList.add(joas);
		teacherlList.add(emmy);
		teacherlList.add(k);
		//System.out.println(teacherlList);
		//System.out.println(teacherlList.get(1).getSalary());
        //Instance student:Information about Students
		Student d=new Student(1, "Karenzi David", 1);
		Student v=new Student(2, "Simpigirwa Venat", 2);
		Student kk=new Student(3, "Kami Karen", 7);
		ArrayList<Student>studentlist=new ArrayList<>();
		studentlist.add(d);
		studentlist.add(v);
		studentlist.add(kk);
		//Information about the school
		school mipc=new School(teacherlList, studentlist);
		Teacher m=new Teacher(5, "Mary Magdalen", 184567);
		mipc.addTeacher(m);
		//System.out.println(teacherlList);
		//Payment of students
		d.PayFees(165726);
		v.PayFees(350000);
		
		System.out.println("MIPC has earned Frw "+mipc.getTotalMoneyEarned() );
		//make salary payment
		
		System.out.println("----Making School pay Salary------");
		joas.receiveSalary(joas.getSalary());
		System.out.println("MIPC has spent  frw  "+joas.getSalary()+" for salary of "+joas.getName()+" and now has Frw "+mipc.getTotalMoneyEarned());
	m.receiveSalary(m.getSalary());
	System.out.println("MIPC has spent  frw  "+m.getSalary()+" for salary of "+m.getName()+" and now has Frw "+mipc.getTotalMoneyEarned());
	System.out.println(k);
	emmy.receiveSalary(emmy.getSalary());
	System.out.println(emmy);
	//kk.PayFees(250000);
	System.out.println(mipc.getTotalMoneyEarned());
	
	
	}

}