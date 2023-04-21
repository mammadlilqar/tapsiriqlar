package az.developia;

import java.time.LocalDate;

public class Student {
private String name;
private String surname;
private LocalDate birthday;
private String sector;
private String langs;


public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSurname() {
	return surname;
}
public void setSurname(String surname) {
	this.surname = surname;
}
public LocalDate getBirthday() {
	return birthday;
}
public void setBirthday(LocalDate birthday) {
	this.birthday = birthday;
}
public String getSector() {
	return sector;
}
public void setSector(String sector) {
	this.sector = sector;
}
public String getLangs() {
	return langs;
}
public void setLangs(String langs) {
	this.langs = langs;
}







}
