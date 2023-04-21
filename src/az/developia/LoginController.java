package az.developia;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class LoginController implements Initializable{
	 @FXML
	    private CheckBox azLang;

	    @FXML
	    private CheckBox engLang;

	    @FXML
	    private CheckBox frLang;

	    @FXML
	    private CheckBox gerLang;

	    @FXML
	    private CheckBox rusLang;

	    @FXML
	    private DatePicker studentBirthday;

	    @FXML
	    private TextField studentName;

	    @FXML
	    private ComboBox<String> studentSector;

	    @FXML
	    private TextField studentSurname;

	    @FXML
	    private CheckBox turkLang;

	    @FXML
	   public void saveData() {
      String name=studentName.getText();
      
      String surname=studentSurname.getText();
      LocalDate birthday=studentBirthday.getValue();
      String sector=studentSector.getValue();
      String langs="";
      if(azLang.isSelected()) {
    	  langs+="Az";
      }
      if(turkLang.isSelected()) {
    	  langs+=" Türk ";
      }
      if(engLang.isSelected()) {
    	  langs+=" İngilis ";
      }
      if(rusLang.isSelected()) {
    	  langs+=" Rus ";
      }
      if(gerLang.isSelected()) {
    	  langs+=" Alman ";
      }
      if(frLang.isSelected()) {
    	  langs+=" Fransız ";
      }
      Student student=new Student();
      student.setName(name);
      student.setSurname(surname);
      student.setBirthday(birthday);
      student.setSector(sector);
      student.setLangs(langs);
      
     Database.insertObject(student);
      
	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			Student s=new Student();
		    s.setBirthday(LocalDate.now());
			studentSector.getItems().add("Az");
			studentSector.getItems().add("Rus");
			studentSector.getItems().add("Ingilis");
			studentSector.getItems().add("Türk");
			studentSector.getSelectionModel().select(0);
		}
}
