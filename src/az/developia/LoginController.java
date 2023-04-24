package az.developia;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swt.FXCanvas;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class LoginController implements Initializable {
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
	private TableColumn<Student, LocalDate> studentBdC;

	@FXML
	private TableColumn<Student, String> studentLangsC;

	@FXML
	private TableColumn<Student, String> studentNameC;

	@FXML
	private TableColumn<Student, String> studentSectorC;

	@FXML
	private TableColumn<Student, String> studentSurnameC;

	@FXML
	private TableView<Student> studentsTable;

	public void saveData() {
		String name = studentName.getText();

		String surname = studentSurname.getText();
		LocalDate birthday = studentBirthday.getValue();
		String sector = studentSector.getValue();
		String langs = "";
		if (azLang.isSelected()) {
			langs += "Az";
		}
		if (turkLang.isSelected()) {
			langs += " Türk ";
		}
		if (engLang.isSelected()) {
			langs += " İngilis ";
		}
		if (rusLang.isSelected()) {
			langs += " Rus ";
		}
		if (gerLang.isSelected()) {
			langs += " Alman ";
		}
		if (frLang.isSelected()) {
			langs += " Fransız ";
		}
		Student student = new Student();
		student.setName(name);
		student.setSurname(surname);
		student.setBirthday(birthday);
		student.setSector(sector);
		student.setLangs(langs);

		Database.insertObject(student);
		fillTable();
	}

	private void fillTable() {
		ArrayList<Student> list=Database.getStudentObjects();
		ObservableList<Student> list2=FXCollections.observableArrayList();
        studentsTable.setItems(list2);
        list2.addAll(list);
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		studentSector.getItems().add("Az");
		studentSector.getItems().add("Rus");
		studentSector.getItems().add("Ingilis");
		studentSector.getItems().add("Türk");
		studentSector.getSelectionModel().select(0);

		studentNameC.setCellValueFactory(new PropertyValueFactory<>("name"));
		studentSurnameC.setCellValueFactory(new PropertyValueFactory<>("surname"));
		studentBdC.setCellValueFactory(new PropertyValueFactory<>("birthday"));
		studentSectorC.setCellValueFactory(new PropertyValueFactory<>("sector"));
		studentLangsC.setCellValueFactory(new PropertyValueFactory<>("langs"));

		fillTable();
	}
}
