package NetPlus;
import java.time.LocalDate;

public class PlatformAdmin extends User {
private String adminRole;
private String departmentName;

public PlatformAdmin(int id, String emailAddress, String passwordHash, LocalDate registerDate, String adminRole,String departmentName) {
	super(id, emailAddress, passwordHash, registerDate);
	this.adminRole = adminRole;
	this.departmentName = departmentName;
}

public String getAdminRole() {
	return adminRole;
}

public void setAdminRole(String adminRole) {
	this.adminRole = adminRole;
}

public String getDepartmentName() {
	return departmentName;
}

public void setDepartmentName(String departmentName) {
	this.departmentName = departmentName;
}



}
