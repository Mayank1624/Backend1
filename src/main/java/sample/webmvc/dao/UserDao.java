package sample.webmvc.dao;



import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sample.webmvc.entity.User;

@Repository
public class UserDao {

	@Autowired
	 private SessionFactory sessionFactory;

	@Transactional
	public void saveUser(User user) {
		sessionFactory.getCurrentSession().persist(user);
		System.out.println("UserDao.saveUser()");
	}

}
