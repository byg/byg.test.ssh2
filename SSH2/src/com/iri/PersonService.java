package com.iri;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
@Component
@Transactional
public interface PersonService {

	public abstract void save(Person Person);

	public abstract void del(Long id);

	public abstract void update(Person Person);

	public abstract Person find(Long id);

	public abstract List<Person> getAll();

	public abstract List<Person> getPage(int start, int pageRecode);

}