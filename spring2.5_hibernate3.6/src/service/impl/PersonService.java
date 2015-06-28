package service.impl;

import java.util.List;

import domain.Person;

public interface PersonService {

	public abstract void save();

	public abstract void update(long id);

	public abstract Person find(long id);

	public abstract void delete(long id);

	public abstract List<Person> getAll();

}