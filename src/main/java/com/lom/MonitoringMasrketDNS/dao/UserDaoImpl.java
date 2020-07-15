package com.lom.MonitoringMasrketDNS.dao;

import com.lom.MonitoringMasrketDNS.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDaoImpl implements UsersDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
        logger.info("user was added with name: " + user.getName() + "and email: " + user.getEmail());
    }

    @Override
    public void updateUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
        logger.info("user was update with name: " + user.getName() + "and email: " + user.getEmail());
    }

    @Override
    public void removeUser(long userId) {
        Session session = this.sessionFactory.getCurrentSession();
        User userToDelete = session.load(User.class, userId);
        if (userToDelete != null) {
            session.delete(userToDelete);
            logger.info("user deleted : " + userToDelete.getName() + "ID = " + userToDelete.getId());
        }
    }

    @Override
    public User getUserById(long id) {
        Session session = this.sessionFactory.getCurrentSession();
        User findedUser = session.load(User.class, id);
        logger.info("User  : " + findedUser.getName() + "ID = " + findedUser.getId());
        return findedUser;
    }

    @Override
    @SuppressWarnings("unckecked")
    public List<User> getAllUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> findedUser = session.createQuery("from USER").list();
        for (User user : findedUser) {
            logger.info("User name : " + user);
        }
        return findedUser;
    }
}
