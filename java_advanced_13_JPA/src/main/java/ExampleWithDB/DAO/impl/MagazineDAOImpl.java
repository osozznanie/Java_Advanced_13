package ExampleWithDB.DAO.impl;

import ExampleWithDB.DAO.MagazineDAO;
import ExampleWithDB.Models.ConnectionUtils;
import ExampleWithDB.Shared.FactoryManager;
import ExampleWithDB.shop.Magazine;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MagazineDAOImpl implements MagazineDAO {
    private EntityManager em = FactoryManager.getEntityManager();

    @Override
    public void create(Magazine magazine) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        try {
            em.getTransaction().begin();
            em.persist(magazine);
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Magazine> readAll() {
        Query query = null;
        try {
            query = em.createQuery("SELECT e FROM Magazine e");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return query.getResultList();
    }

    @Override
    public void update(Magazine magazine) {
        // not used
    }

    @Override
    public void deleteById(int id) {
        // not used

    }

    @Override
    public Magazine getUserByEmail(String email) {
        return null;
    }


    @Override
    public Magazine readById(Integer id) {
        Magazine magazine = null;
        try {
            magazine = em.find(Magazine.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return magazine;
    }
}

//    static String INSERT = "INSERT INTO magazines (name_of_magazine, description, price) VALUE(?,?,?)";
//    static String READ_ALL = "SELECT * FROM magazines";
//    static String UPDATE = "UPDATE magazines SET name_of_magazine = ?, description = ?, price = ?";
//    static String DELETE = "DELETE FROM magazines WHERE id = ?";
//    private static String READ_BY_ID = "select * from magazines where id =?";
//
//    private final Connection dbConnection = ConnectionUtils.openConnection();
//    private PreparedStatement preparedStatement;
//
//
//    private final static Logger LOG = Logger.getLogger(MagazineDAOImpl.class);
//
//
//    public MagazineDAOImpl() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
//    }
//
//
//    @Override
//    public void create(Magazine magazines) {
//        try {
//            preparedStatement = dbConnection.prepareStatement(INSERT);
//            preparedStatement.setString(1, magazines.getNameOfMagazine());
//            preparedStatement.setString(2, magazines.getDescription());
//            preparedStatement.setInt(3, magazines.getPrice());
//
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException e) {
//            LOG.error(e);
//        }
//
//
//    }
//
//    @Override
//    public List<Magazine> readAll() {
//        List<Magazine> magazinesList = new ArrayList<>();
//        try {
//            preparedStatement = dbConnection.prepareStatement(READ_ALL);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                Magazine magazines = new Magazine();
//                magazines.setId(resultSet.getInt("id"));
//                magazines.setNameOfMagazine(resultSet.getString("name_of_magazine"));
//                magazines.setDescription(resultSet.getString("description"));
//                magazines.setPrice(resultSet.getInt("price"));
//
//
//                magazinesList.add(magazines);
//            }
//
//        } catch (SQLException e) {
//            LOG.error(e);
//        }
//
//        return magazinesList;
//    }
//
//
//    @Override
//    public void update(Magazine magazines) {
//        try {
//            preparedStatement = dbConnection.prepareStatement(UPDATE);
//            preparedStatement.setString(1, magazines.getNameOfMagazine());
//            preparedStatement.setString(2, magazines.getDescription());
//            preparedStatement.setInt(3, magazines.getPrice());
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
//    public void deleteById(int id) {
//        try {
//            preparedStatement = dbConnection.prepareStatement(DELETE);
//            preparedStatement.setInt(1, id);
//
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            LOG.error(e);
//        }
//
//    }
//
//    @Override
//    public Magazine getUserByEmail(String email) {
//        return null;
//    }
//
//    @Override
//    public Magazine readById(Integer id) {
//        Magazine magazine = null;
//        try {
//            preparedStatement = dbConnection.prepareStatement(READ_BY_ID);
//            preparedStatement.setInt(1, id);
//            ResultSet result = preparedStatement.executeQuery();
//            result.next();
//
//            Integer magId = result.getInt("id");
//            String name = result.getString("name_of_magazine");
//            String description = result.getString("description");
//            Integer purchasePrice = result.getInt("price");
//            magazine = new Magazine(magId, name, description, purchasePrice);
//
//        } catch (SQLException e) {
//            LOG.error(e);
//        }
//
//        return magazine;
//    }
