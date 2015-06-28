package service.impl;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import domain.Person;
@Component("personServiceImpl")
@Transactional
public class PersonServiceImpl implements PersonService {
@Resource private SessionFactory sessionFactory;


	/* (non-Javadoc)
	 * @see service.impl.PersonService#save()
	 */
	@Override
	public void save(){
		sessionFactory.getCurrentSession().save(new Person("byg"));
	}
	
	/* (non-Javadoc)
	 * @see service.impl.PersonService#update(long)
	 */
	@Override
	public void update(long id){
		Person person=find(id);
		person.setUsername("xxx");
		sessionFactory.getCurrentSession()
		.merge(person);
	}
	
	/* (non-Javadoc)
	 * @see service.impl.PersonService#find(long)
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@Override
	public Person find(long id){
		return (Person) sessionFactory.getCurrentSession().get(Person.class, id);
		
	}
	
	
	/* (non-Javadoc)
	 * @see service.impl.PersonService#delete(long)
	 */
	@Override
	public void delete(long id){
		sessionFactory.getCurrentSession().delete(find(id));
		
	}
	
	
	/* (non-Javadoc)
	 * @see service.impl.PersonService#getAll()
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@Override
	public List<Person> getAll(){
		List<Person> list = null;
//		try {
			list = sessionFactory.getCurrentSession().createQuery("from Person").list();
//		} catch (HibernateException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return list;
	}
	
}
