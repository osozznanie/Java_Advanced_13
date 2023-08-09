package ExampleWithDB.DAO.impl;

import ExampleWithDB.DAO.UserDAO;

import ExampleWithDB.Models.ConnectionUtils;
import ExampleWithDB.Shared.FactoryManager;
import ExampleWithDB.shop.AccessLevel;
import ExampleWithDB.shop.User;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jpa.QueryHints;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.cfg.Configuration;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private EntityManager em = FactoryManager.getEntityManager();
    private Session session;

    public UserDAOImpl() {
        session = em.unwrap(Session.class); // Инициализация сессии
    }
    public UserDAOImpl(EntityManager em) {
        this.em = em;
        session = em.unwrap(Session.class); // Инициализация сессии
    }
    @Override
    public void create(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    @Override
    public List<User> readAll() {
        List<User> userList = new ArrayList<>();

        return userList;
    }

    @Override
    public void update(User user) {
        // not used
    }

    @Override
    public void deleteById(int id) {
        // not used
    }

    @Override
    public User getUserByEmail(String email) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MagazineShopPersistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<User> query = cb.createQuery(User.class);
            Root<User> root = query.from(User.class);

            query.select(root).where(cb.equal(root.get("email"), email));

            TypedQuery<User> typedQuery = entityManager.createQuery(query);
            typedQuery.setMaxResults(1);

            List<User> result = typedQuery.getResultList();
            System.out.println(result + " --> userDaoIMPL");

            if (!result.isEmpty()) {
                System.out.println(result + " --> userDaoIMPL");
                return result.get(0);
            } else {
                return null;
            }
        } finally {
            entityManager.close();
        }
    }


    @Override
    public User readById(Integer id) {
        User user = null;
        user = em.find(User.class, id);
        return user;
    }
}


//    static String INSERT = "INSERT INTO user (first_name, last_name, email, password, level) VALUE(?,?,?,?,?)";
//    static String READ_ALL = "SELECT * FROM user";
//    static String UPDATE = "UPDATE user SET first_name = ?, last_name = ?, email = ?, password = ?, level = ?";
//    static String DELETE = "DELETE FROM user WHERE id = ?";
//    private final Connection dbConnection = ConnectionUtils.openConnection();
//    private PreparedStatement preparedStatement;
//
//    private final static Logger LOG = Logger.getLogger(UserDAOImpl.class);
//
//
//    public UserDAOImpl() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
//    }
//
//    @Override
//    public void create(User users) {
//        try {
//            preparedStatement = dbConnection.prepareStatement(INSERT);
//            preparedStatement.setString(1, users.getFirstName());
//            preparedStatement.setString(2, users.getLastName());
//            preparedStatement.setString(3, users.getEmail());
//            preparedStatement.setString(4, users.getPassword());
//            preparedStatement.setString(5, users.getAccessLevel().name());
//
//
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            LOG.error(e);
//        }
//
//
//    }
//
//    @Override
//    public List<User> readAll() {
//        List<User> usersList = new ArrayList<>();
//        try {
//            preparedStatement = dbConnection.prepareStatement(READ_ALL);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()){
//                User users = new User();
//                users.setId(resultSet.getInt("id"));
//                users.setFirstName(resultSet.getString("first_name"));
//                users.setLastName(resultSet.getString("last_name"));
//                users.setEmail(resultSet.getString("email"));
//                users.setPassword(resultSet.getString("password"));
//                users.setAccessLevel(AccessLevel.valueOf(resultSet.getString("level")));
//
//                usersList.add(users);
//            }
//
//        } catch (SQLException e) {
//            LOG.error(e);
//        }
//
//        return usersList;
//    }
//
//
//    @Override
//    public void update(User users) {
//        try {
//            preparedStatement = dbConnection.prepareStatement(UPDATE);
//            preparedStatement.setString(1, users.getFirstName());
//            preparedStatement.setString(2, users.getLastName());
//            preparedStatement.setString(3, users.getEmail());
//            preparedStatement.setString(4, users.getPassword());
//            preparedStatement.setString(5, users.getAccessLevel().name());
//
//
//
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            LOG.error(e);
//        }
//
//
//
//    }
//
//    @Override
//    public void deleteById(int id) {
//        try {
//            preparedStatement = dbConnection.prepareStatement(DELETE);
//            preparedStatement.setInt(1,id);
//
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            LOG.error(e);
//        }
//
//    }
//    @Override
//    public User getUserByEmail(String email) {
//        String query = "SELECT * FROM user WHERE email = ?";
//        try {
//            PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
//            preparedStatement.setString(1, email);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            if (resultSet.next()) {
//                User user = new User();
//                user.setId(resultSet.getInt("id"));
//                user.setFirstName(resultSet.getString("first_name"));
//                user.setLastName(resultSet.getString("last_name"));
//                user.setEmail(resultSet.getString("email"));
//                user.setPassword(resultSet.getString("password"));
//                user.setAccessLevel(AccessLevel.valueOf(resultSet.getString("level")));
//                return user;
//            }
//        } catch (SQLException e) {
//            LOG.error(e);
//        }
//        return null;
//    }
//
//    @Override
//    public User readById(Integer id) {
//        return null;
//    }

