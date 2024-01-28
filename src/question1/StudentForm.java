package question1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentForm implements ActionListener {
	JFrame frame;
	//Labels
		JLabel fnameLabel=new JLabel("fname");
		JLabel lnameLabel=new JLabel("lname");
		JLabel genderLabel=new JLabel("Gender");
		JLabel rnumberLabel= new JLabel("rnumber");
		//Fields
		JTextField fnameTextField=new JTextField("fname");
		JTextField lnameTextField=new JTextField("lname");
		JTextField genderTextField=new JTextField("gender");
		JTextField rnumberTextField=new JTextField("rnumber");
		//Buttons
    
  //Buttons
  	
  	
  	JButton insert=new JButton("Register");
  	JButton read=new JButton("Display");
  	JButton updButton=new JButton("Update");
  	JButton delButton=new JButton("Delete");
  	JTable table=new JTable();
	 JScrollPane scrollPane = new JScrollPane(table);
    //add(scrollPane, BorderLayout.CENTER);
	//Check box
	JCheckBox showPassword=new JCheckBox("Show Password");
	//constructor
	public StudentForm() {
		createWindow();
		setLocationsAndSize();
		addcompontentstoFrame();
		addActionEvent();
	}
	private void addActionEvent() {
		
		showPassword.addActionListener(this);
		insert.addActionListener(this);
		read.addActionListener(this);
		updButton.addActionListener(this);
		delButton.addActionListener(this);
		
	}
	private void addcompontentstoFrame() {
		//userLabel;	passwordLabel; 	userTextField; 		passwordField;
				//showPassword; 		loginButton; 		resetButton;
		frame.add(fnameLabel);
		frame.add(fnameTextField);	
		frame.add(lnameLabel);
		frame.add(lnameTextField);
		frame.add(genderLabel);
		frame.add(genderTextField);
		frame.add(rnumberLabel);
		frame.add(rnumberTextField);
		
		
		
		frame.add(insert);
		frame.add(read);
		frame.add(updButton);
		frame.add(delButton);
		frame.add(table);
		table.add(scrollPane, BorderLayout.CENTER);
	}
	private void setLocationsAndSize() {
		
		fnameLabel.setBounds(20, 20, 100, 30);
		lnameLabel.setBounds(20, 20, 100, 30);
		genderLabel.setBounds(20, 20, 100, 30);
		rnumberLabel.setBounds(20, 20, 100, 30);
		
		insert.setBounds(20,220,100,30);
		read.setBounds(150, 220,100,30);
		
		updButton.setBounds(20,270,100,30);
		delButton.setBounds(150, 270,100,30);
		table.setBounds(10, 320, 345, 220);
	
	}
	private void createWindow() {
		frame=new JFrame();
		frame.setTitle("Login Form");
		frame.setBounds(10,10,380,600);
		frame.getContentPane().setBackground(Color.gray);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
	}
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		Student myuser=new Student(null, null, null, null);
		if(e.getSource()==insert) {
			
			myuser.setfname(fnameTextField.getText());
			myuser.setlname(lnameTextField.getText());
			myuser.setGender(genderTextField.getText());
			myuser.setrnumber(rnumberTextField.getText());
			
		}
		
		if(e.getSource()==insert) {
			myuser.setfname(fnameTextField.getText());
			myuser.setlname(lnameTextField.getText());
			myuser.setGender(genderTextField.getText());
			myuser.setrnumber(rnumberTextField.getText());
			myuser.registertwo();
			DefaultTableModel tableModel=myuser.populateTable();
			table.setModel(tableModel);
		}/*if(e.getSource()==read) {
			//myuser.displaytwo();
			DefaultTableModel tableModel=myuser.populateTable();
			table.setModel(tableModel);
		}*/
		if(e.getSource()==read) {
			myuser.displayInformation();
		}
		if(e.getSource()==delButton) {
			String userInput = JOptionPane.showInputDialog(null, "Enter id:");
			myuser.deletedata(Integer.parseInt(userInput));
		}
		if(e.getSource()==updButton) {
			String userInput = JOptionPane.showInputDialog(null, "Enter id:");
			myuser.setfname(fnameTextField.getText());
			myuser.setlname(lnameTextField.getText());
			myuser.setGender(genderTextField.getText());
			myuser.setrnumber(rnumberTextField.getText());
			myuser.updatedata(Integer.parseInt(userInput));
			//myuser.updatedata(Integer.parseInt(userInput),userTextField.getText(),passwordField.getText());
		}
		
		}

	

public static void main(String[] args) {
	StudentForm lgnfm=new StudentForm();
}}