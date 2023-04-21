package az.developia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.LocalDate;


public class Database {
	public static void insertObject(Student student) {
		
		try {
   
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java10?useSSl=false", "root", "1234");
			Statement st = conn.createStatement();
			st.executeUpdate("insert into student (name,surname,birthday,sector,langs) values('"+student.getName()+"','"+student.getSurname()+"',"
					+ "'"+student.getBirthday()+"','"+student.getSector()+"','"+student.getLangs()+"')");

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
