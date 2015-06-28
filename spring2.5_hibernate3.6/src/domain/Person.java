package domain;


public class Person {
private long id;
private String username;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public Person(String username) {
	super();
	this.username = username;
}
public Person() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Person [id=" + id + ", username=" + username + "]";
}

}
