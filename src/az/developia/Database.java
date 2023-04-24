package az.developia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;


public class Database {
	private static final String JDBC_MYSQL_LOCALHOST_3306_JAVA10_USE_S_SL_FALSE = "jdbc:mysql://localhost:3306/java10?useSSl=false";



	public static void insertObject(Student student) {
		
		try {
   
			Connection conn = DriverManager.getConnection(JDBC_MYSQL_LOCALHOST_3306_JAVA10_USE_S_SL_FALSE, "root", "1234");
			Statement st = conn.createStatement();
			st.executeUpdate("insert into student (name,surname,birthday,sector,langs) values('"+student.getName()+"','"+student.getSurname()+"',"
					+ "'"+student.getBirthday()+"','"+student.getSector()+"','"+student.getLangs()+"')");

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static ArrayList<Student> getStudentObjects() {
		ArrayList<Student> students=new ArrayList<>();
		try {
   
			Connection conn = DriverManager.getConnection(JDBC_MYSQL_LOCALHOST_3306_JAVA10_USE_S_SL_FALSE, "root", "1234");
			Statement st = conn.createStatement();
	ResultSet rs=st.executeQuery("select*from student");
    while(rs.next()) {
    String name=rs.getString("name");
    String surname=rs.getString("surname");
    
    Date  bd=rs.getDate("birthday");
    LocalDate bdDate=bd.toLocalDate();
    
    String sector=rs.getString("sector");
    String langs=rs.getString("langs");
    	
    Student s=new Student();
    s.setName(name);
    s.setSurname(surname);
    s.setBirthday(bdDate);
    s.setSector(sector);
    s.setLangs(langs);
    students.add(s);
   
    }
	
	
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return students;
	}
}
