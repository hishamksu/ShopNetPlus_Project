package NetPlus;
import java.time.LocalDate;

public class Benefit {
private	int id;
private String benefitName;
private String benefitDescription;

public Benefit(int id, String benefitName, String benefitDescription) {
	this.id = id;
	this.benefitName = benefitName;
	this.benefitDescription = benefitDescription;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getBenefitName() {
	return benefitName;
}
public void setBenefitName(String benefitName) {
	this.benefitName = benefitName;
}
public String getBenefitDescription() {
	return benefitDescription;
}
public void setBenefitDescription(String benefitDescription) {
	this.benefitDescription = benefitDescription;
}




}
