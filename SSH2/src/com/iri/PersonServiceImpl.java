package com.iri;

//基于hibernate的增删改查
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
@Component
@Transactional
public class PersonServiceImpl implements PersonService {
	@Resource private SessionFactory sessionFactory;

/* (non-Javadoc)
 * @see PersonService#save(Person)
 */
@Override
public void save(Person Person){
	
	Transaction tx = null;
	Session session=sessionFactory.openSession();
	try {
			
			tx=session.beginTransaction();
			session.save(Person);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			throw e;
		}
		finally{
			session.close();
			}
}

/* (non-Javadoc)
 * @see PersonService#del(java.lang.Long)
 */
@Override
public void del(Long id){
	
	Transaction tx = null;
	Session session=sessionFactory.openSession();
	try {
			Person Person=find(id);
			tx=session.beginTransaction();
			session.delete(Person);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			throw e;
		}
		finally{
			session.close();
			}
}

/* (non-Javadoc)
 * @see PersonService#update(Person)
 */
@Override
public void update(Person Person){
	
	Transaction tx = null;
	Session session=sessionFactory.openSession();
	try {
			
			tx=session.beginTransaction();
			session.update(Person);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			throw e;
		}
		finally{
			session.close();
			}
}

/* (non-Javadoc)
 * @see PersonService#find(java.lang.Long)
 */
@Override
public Person find(Long id){
	
	Transaction tx = null;
	Session session=sessionFactory.openSession();
	try {
			
			tx=session.beginTransaction();
			Person Person=(Person) session.get(Person.class,id);
			tx.commit();
			
			return Person;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			throw e;
			
		}
		finally{
			session.close();
			}
}

/* (non-Javadoc)
 * @see PersonService#getAll()
 */
@Override
public List<Person> getAll(){
	
	Transaction tx = null;
	Session session=sessionFactory.openSession();
	try {
			
			tx=session.beginTransaction();
			List<Person> list=session.createQuery("FROM Person").list();
			tx.commit();
			return list;
		} catch (Exception e) {
			tx.rollback();
			throw e;
			
		}
		finally{
			session.close();
			}
}

/* (non-Javadoc)
 * @see PersonService#getPage(int, int)
 */
@Override
public List<Person> getPage(int start,int pageRecode){
	
	Transaction tx = null;
	Session session=sessionFactory.openSession();
	try {
			
			tx=session.beginTransaction();
			List<Person> list=session.createQuery("FROM Person")
			.setFirstResult(start)
			.setMaxResults(pageRecode)
			.list();
			tx.commit();
			return list;
		} catch (Exception e) {
			tx.rollback();
			throw e;
		}
		finally{
			session.close();
			}
}
}
