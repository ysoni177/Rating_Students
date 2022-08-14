package corejava;

public class structures {


public structures(int id,String name,String sub,String ac,String d,int points) {
	super();
	this.id = id;
	this.name = name;
	
	this.subject = sub;
	this.asscat = ac;
	this.date = d;
	this.points = points;
	// TODO Auto-generated constructor stub
}
int id;
String name;
String subject;
String asscat;
String date;
int points;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public String getAsscat() {
	return asscat;
}
public void setAsscat(String asscat) {
	this.asscat = asscat;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public int getPoints() {
	return points;
}
public void setPoints(int points) {
	this.points = points;
}
public void printdata()
{
	System.out.print(id+" "+name+" "+subject+" "+asscat+" "+date+" "+points);
}

}
