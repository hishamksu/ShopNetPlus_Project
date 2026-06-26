package NetPlus;
import java.time.LocalDate;


public abstract class User {
protected int id;
protected String emailAddress;
protected String passwordHash;
protected LocalDate registerDate;

public User(int id,String emailAddress,String passwordHash,LocalDate registerDate) {
	this.id = id;
	this.emailAddress = emailAddress;
	this.passwordHash = passwordHash;
	this.registerDate = registerDate;
}
public User(int id,String emailAddress,String passwordHash) {
	this.id = id;
	this.emailAddress = emailAddress;
	this.passwordHash = passwordHash;
}

public boolean passwordIsValid(String inputPass) {
	if(passwordHash.equals(inputPass)) {
		System.out.println("password is valid");
		return true;
	}
	else {
		System.out.println("Error");
		return false;
	}
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getEmailAddress() {
	return emailAddress;
}
public void setEmailAddress(String emailAddress) {
	this.emailAddress = emailAddress;
}
public String getPasswordHash() {
	return passwordHash;
}
public void setPasswordHash(String passwordHash) {
	this.passwordHash = passwordHash;
}
public LocalDate getRegisterDate() {
	return registerDate;
}
public void setRegisterDate(LocalDate registerDate) {
	this.registerDate = registerDate;
}





}











