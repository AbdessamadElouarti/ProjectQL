package ma.ensa.dao;

import java.util.List;











import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ma.ensa.model.*;



@Repository
public class Dao implements Idao{
	
	private SessionFactory sessionFactory;

	//	public Dao()
//	{
//		sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
//		session=sessionFactory.openSession();
//	}
//	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<User> findAll() {
		Session session = sessionFactory.openSession();
		
		try {
		Query query = session.createQuery("from User");
		return query.list();
		}  
		
		finally {
		session.close();
			}
		}
	@Override
	public User getUserByLogin(String login) 
	{
		Session session = sessionFactory.openSession();
		List<User> user=session.createQuery("From User where login='"+login+"'").list();
		session.close();
		return user.get(0);
	}
	
	public void persist(Object obj) 
	{
		Session session = sessionFactory.openSession();
		Transaction tx=session.getTransaction();
		tx.begin();
		session.save(obj);
		tx.commit();
		session.close();
	}

	public void updateRecord(Object entite)
	{
		Session session = sessionFactory.openSession();
		Transaction tx=session.getTransaction();
		tx.begin();
		session.update(entite);
		tx.commit();
		session.close();
	}
	
}
