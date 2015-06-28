package com.iri;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
@Component
@Scope("prototype")
public class UserServiceAction {
@Resource private PersonService personService;
private String username;
private String password;
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

public String login(){
	
	HttpServletRequest request= ServletActionContext.getRequest();
//	personService=new PersonServiceImpl();
	Person person=personService.find(1l);
	System.out.println("username="+person.getUsername());
	System.out.println("password="+person.getPassword());
	request.setAttribute("message", "µÇÂ½³É¹¦");
	return "success";
}
}
