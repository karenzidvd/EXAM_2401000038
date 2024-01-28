package question1;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Student {
	private String fname;
	private String lname;
	private String Gender;
	private String rnumber;
	
	public Student(String fname, String lname, String Gender, String rnumber) {
		this.fname = fname;
		this.lname = lname;
		this.Gender = Gender;
		this.rnumber = rnumber;
	}
	public String getfname() {
		return fname;
	}
	public void setfname(String fname) {
		this.fname = fname;
	}
	public String getlname() {
		return lname;
	}
	public void setlname(String lname) {
		this.lname = lname;
	}
	public String setGender(String Gender) {
		return Gender;
	}
	
	public String getGender() {
		return this.Gender= Gender;
	}
	
	public String getrnumber() {
		return rnumber;
	}
	public void setrnumber(String rnumber) {
		this.fname = rnumber;
	}
	public void register() {
		String host = "jdbc:mysql://localhost/School";
		String Student = "root";
		String fname = "";
		String lname = "";
		String Gender = "";
		String rnumber = "";

		// SQL query to insert data
		String sql = "INSERT INTO Student (fname,lname,Gender,rnumber) VALUES (?, ?)";
		String sqlQuery = "SELECT fname FROM Student";

		try (// Establish the connection
				Connection connection = DriverManager.getConnection(host, Student, lname);
				// Create a prepared statement
				PreparedStatement preparedStatementcheck = connection.prepareStatement(sqlQuery);
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				ResultSet resultSet = preparedStatementcheck.executeQuery()
				) {

			List<String> dataArray = new ArrayList<>();
			while (resultSet.next()) {
				String data = resultSet.getString("fname");
				dataArray.add(data);
			}
			String[] dataArrayAsArray = dataArray.toArray(new String[0]);
			for (String data : dataArrayAsArray) {
				System.out.println(data);
			}
			// Set the values for the prepared statement
			preparedStatement.setString(1, this.fname);
			preparedStatement.setString(2, this.lname);
			preparedStatement.setString(1, this.Gender);
			preparedStatement.setString(2, this.rnumber);
			for(String data:dataArray) {
				if (data==this.fname) {
					System.out.println("The usename you entered is already used!");
				}else {
					// Execute the query
					int rowsAffected = preparedStatement.executeUpdate();
					// Check the result
					if (rowsAffected > 0) {
						//System.out.println("Data inserted successfully!");
						JOptionPane.showMessageDialog(null, "Data inserted successfully!.");
					} else {
						//System.out.println("Failed to insert data.");
						JOptionPane.showMessageDialog(null, "Failed to insert data.", 
								"Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void registertwo() {
		String host = "jdbc:mysql://localhost/School";
		String Student = "root";
		String lname = "";

		// SQL query to insert data
		String sql = "INSERT INTO Student (fname,lname,Gender,rnumber) VALUES (?, ?, ?, ?)";
		String sqlQuery = "SELECT fname,laname,Gender,rnumber FROM Student";

		try (
				// Establish the connection
				Connection connection = DriverManager.getConnection(host);
				// Create a prepared statement
				PreparedStatement preparedStatementCheck = connection.prepareStatement(sqlQuery);
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				ResultSet resultSet = preparedStatementCheck.executeQuery()
				) {

			List<String> dataArray = new ArrayList<>();
			while (resultSet.next()) {
				String data = resultSet.getString("fname");
				dataArray.add(data);
			}

			/*for (String data : dataArray) {
				System.out.println(data);
			}*/

			// Check for duplicate fname
			if (dataArray.contains(this.fname)) {
				System.out.println("The fname you entered is already used!");
				JOptionPane.showMessageDialog(null, "The fname you entered is already used!.",
						"Error", JOptionPane.ERROR_MESSAGE);
			}else if(this.fname.isBlank() && this.lname.isBlank()){
				JOptionPane.showMessageDialog(null, "Please fill in the required informations!.",
						"Error", JOptionPane.ERROR_MESSAGE);
			}else if(this.fname.length()>10){
				JOptionPane.showMessageDialog(null, "The size of the fname cannot be greatter that 10 characters!.",
						"Error", JOptionPane.ERROR_MESSAGE);
			}else {
				// Set the values for the prepared statement
				preparedStatement.setString(1, this.fname);
				preparedStatement.setString(2, this.lname);
				preparedStatement.setString(1, this.Gender);
				preparedStatement.setString(2, this.rnumber);

				// Execute the query
				int rowsAffected = preparedStatement.executeUpdate();

				// Check the result
				if (rowsAffected > 0) {
					// System.out.println("Data inserted successfully!");
					JOptionPane.showMessageDialog(null, "Data inserted successfully!.");
				} else {
					// System.out.println("Failed to insert data.");
					JOptionPane.showMessageDialog(null, "Failed to insert data.",
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void displayInformation() {
		StudentForm loginForm=new StudentForm();
		String host = "jdbc:mysql://localhost/School";
	        String Student = "root";
	        String fname = "";
	        String lname = "";
	        String Gender = "";
	        String rnumber = "";

	        String sql = "SELECT * FROM Student"; // replace your_table with the actual table name

	        try (Connection connection = DriverManager.getConnection(host);
	             PreparedStatement preparedStatement = connection.prepareStatement(sql);
	             ResultSet resultSet = preparedStatement.executeQuery()) {

	            // Get column names
	            int columnCount = resultSet.getMetaData().getColumnCount();
	            Vector<String> columnNames = new Vector<>();
	            for (int i = 1; i <= columnCount; i++) {
	                columnNames.add(resultSet.getMetaData().getColumnName(i));
	            }

	            // Get data rows
	            Vector<Vector<Object>> data = new Vector<>();
	            while (resultSet.next()) {
	                Vector<Object> row = new Vector<>();
	                for (int i = 1; i <= columnCount; i++) {
	                    row.add(resultSet.getObject(i));
	                }
	                data.add(row);
	            }

	            // Create DefaultTableModel and set data
	            DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
	            loginForm.table.setModel(tableModel);

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}
	public void displaytwo() {
		String url = "jdbc:mysql://localhost/School1";
		String Student = "root";
		String lname = "";
		// SQL query to retrieve data
		String sql = "SELECT * from Student";

		try (
				// Establish the con
				Connection con = DriverManager.getConnection(url, Student, lname);
				// Create a prepared statement
				PreparedStatement stm = con.prepareStatement(sql);

				// Execute the query and get the result set
				ResultSet resultSet = stm.executeQuery();
				)
		{
			// Process the result set
			while (resultSet.next()) {
				int column1Value = resultSet.getInt("id");
				String column2Value = resultSet.getString("fname");
				String column3Value = resultSet.getString("lname");
				String column4Value = resultSet.getString("Gender");
				String column5Value = resultSet.getString("rnumber");

				System.out.println("id: " + column1Value + ", fname: " + column2Value + ", lname: " + column3Value +", Gender: " + column4Value + ",rnumber: " + column5Value);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused") DefaultTableModel populateTable() {
		String host = "jdbc:mysql://localhost/School";
		String Student = "root";
		String fname = "";
		String lname = "";
		String Gender = "";
		String rnumber = "";

		String sql = "SELECT * FROM Student"; // replace your_table with the actual table name
		DefaultTableModel tableModel = null;// = new DefaultTableModel(data, columnNames);
		try (Connection connection = DriverManager.getConnection(host);

				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				ResultSet resultSet = preparedStatement.executeQuery()) {

			// Get column names
			int columnCount = resultSet.getMetaData().getColumnCount();

			Vector<String> columnNames = new Vector<>();
			for (int i = 1; i <= columnCount; i++) {
				columnNames.add(resultSet.getMetaData().getColumnName(i));
			}

			// Get data rows
			Vector<Vector<Object>> data = new Vector<>();
			while (resultSet.next()) {
				Vector<Object> row = new Vector<>();
				for (int i = 1; i <= columnCount; i++) {
					row.add(resultSet.getObject(i));
				}
				data.add(row);
			}

			// Create DefaultTableModel and set data
			tableModel = new DefaultTableModel(data, columnNames);
			//table.setModel(tableModel);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tableModel;
	}
	public void deletedata(int id) {
		String url = "jdbc:mysql://localhost/School";
		String Student = "root";
		String fname = "";
		String lname = "";
		String Gender = "";
		String rnumber = "";
		//String StudentInput = JOptionPane.showInputDialog(null, "Enter id:");
		//id=Integer.parseInt(StudentInput);
		//System.out.println("Student entered: " + StudentInput);
		// SQL query to delete data

		String sql = "DELETE FROM Student WHERE id = ?";
		if(id==0) 
			JOptionPane.showMessageDialog(null, "No id entered");
		try (
				// Establish the con
				Connection con = DriverManager.getConnection(url);
				// Create a prepared statement
				PreparedStatement stm = con.prepareStatement(sql);
				) {
			// Set the value for the WHERE clause
			stm.setInt(1, id); // Assuming there is a column named 'id' for the WHERE clause

			// Execute the delete

			int result = JOptionPane.showConfirmDialog(null, "Do you really want to delete the Student with id "+id+"\n?", "Question", JOptionPane.YES_NO_OPTION);

			// Check the Student's choice
			if (result == JOptionPane.YES_OPTION) {
				//System.out.println("Student clicked Yes");
				int rowsAffected = stm.executeUpdate();
				if (rowsAffected > 0) {
					JOptionPane.showMessageDialog(null, "The Student with id: "+id+"\n was deleted!");

				} else {
					//System.out.println("Failed to delete data. No matching record found.");

					JOptionPane.showMessageDialog(null, "Failed to delete data. No matching record found.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				//System.out.println("Student clicked No");
				JOptionPane.showMessageDialog(null, "We can't delete the Student");


			}
			// Check the result


		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updatedata(int id) {
		String url = "jdbc:mysql://localhost/School";
        String Student = "root";
        String fname = "";
        String lname = "";
        String Gender = "";
        String rnumber = "";

        // SQL query to update data
        String sql = "UPDATE Student SET fname = ?, lname = ?, Gender = ?, rnumber = ? where id='"+id+"'";

        try (
            // Establish the con
            Connection con = DriverManager.getConnection(url, Student, lname);

            // Create a prepared statement
            PreparedStatement stm = con.prepareStatement(sql);
        ) {
            // Set the new values for the update
            stm.setString(1, this.fname);
            stm.setString(2, this.lname);
            stm.setString(1, this.Gender);
            stm.setString(2, this.rnumber);
            
            int result = JOptionPane.showConfirmDialog(null, "Do you really want to update the Student with idd"+id+"\n?", "Question", JOptionPane.YES_NO_OPTION);
            
            // Check the Student's choice
            if (result == JOptionPane.YES_OPTION) {
            	// Execute the update
                int rowsAffected = stm.executeUpdate();

                // Check the result
                if (rowsAffected > 0) {
                   // System.out.println("Data updated successfully!");
                    JOptionPane.showMessageDialog(null, "Data updated successfully!");

                } else {
                    System.out.println("Failed to update data. No matching record found.");
                    JOptionPane.showMessageDialog(null, "Failed to update data. No matching record found.", "Error", JOptionPane.ERROR_MESSAGE);

                }
            } else {
                //System.out.println("Student clicked No");
                JOptionPane.showMessageDialog(null, "We will not delete your data");

            }
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	public void updatedata(int id,String uname,String pwd) {
		String url = "jdbc:mysql://localhost/School";
        String Student = "root";
        String fname = "";
        String lname = "";
        String Gender = "";
        String rnumber = "";

        // SQL query to update data
        String sql = "UPDATE Student SET fname = ?, lname = ?,Gender = ?,rnumber = ? where id='"+id+"'";

        try (
            // Establish the con
            Connection con = DriverManager.getConnection(url, Student, lname);

            // Create a prepared statement
            PreparedStatement stm = con.prepareStatement(sql);
        ) {
            // Set the new values for the update
            stm.setString(1, fname);
            stm.setString(2, lname);
            stm.setString(1, Gender);
            stm.setString(2, rnumber);
            
            int result = JOptionPane.showConfirmDialog(null, "Do you really want to update the Student with idd"+id+"\n?", "Question", JOptionPane.YES_NO_OPTION);
            
            // Check the Student's choice
            if (result == JOptionPane.YES_OPTION) {
            	// Execute the update
                int rowsAffected = stm.executeUpdate();

                // Check the result
                if (rowsAffected > 0) {
                   // System.out.println("Data updated successfully!");
                    JOptionPane.showMessageDialog(null, "Data updated successfully!");

                } else {
                    System.out.println("Failed to update data. No matching record found.");
                    JOptionPane.showMessageDialog(null, "Failed to update data. No matching record found.", "Error", JOptionPane.ERROR_MESSAGE);

                }
            } else {
                //System.out.println("Student clicked No");
                JOptionPane.showMessageDialog(null, "We will not delete your data");

            }
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
	}


}