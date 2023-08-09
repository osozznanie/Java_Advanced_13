package ExampleWithDB.Service.impl;

import ExampleWithDB.DAO.UserDAO;
import ExampleWithDB.DAO.impl.UserDAOImpl;
import ExampleWithDB.Service.UserService;
import ExampleWithDB.Shared.FactoryManager;
import ExampleWithDB.shop.User;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO;
    private UserDAOImpl userRepository;
    private final static Logger LOG = Logger.getLogger(UserServiceImpl.class);
    private static UserService userServiceImpl;

    public static UserService getUserServiceImpl() {
        if (userServiceImpl == null) {
            return new UserServiceImpl();
        }
        return userServiceImpl;
    }

    public UserServiceImpl() {
        EntityManager entityManager = FactoryManager.getEntityManager();
        userDAO = new UserDAOImpl(entityManager);
    }

    @Override
    public void create(User user){
        try {
            userDAO.create(user);
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            LOG.error(e);
        }
    }

    @Override
    public List<User> readAll() {
        return userDAO.readAll();
    }

    @Override
    public void update(User user) {
        userDAO.update(user);
    }

    @Override
    public void deleteById(int id) {
        userDAO.deleteById(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userDAO.getUserByEmail(email);
    }

    @Override
    public User readById(Integer id) {
        return userDAO.readById(id);
    }
}
