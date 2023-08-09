package ExampleWithDB.Service.impl;

import ExampleWithDB.DAO.SubscribeDAO;
import ExampleWithDB.DAO.impl.SubscribeDAOImpl;
import ExampleWithDB.Models.ConnectionUtils;
import ExampleWithDB.Service.SubscribeService;
import ExampleWithDB.shop.Subscribe;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SubscribeServiceImpl implements SubscribeService {
    private SubscribeDAO subscribeDAO;
    private final static Logger LOG = Logger.getLogger(SubscribeServiceImpl.class);
    private static SubscribeService subscribeServiceImpl;
    private final Connection dbConnection = ConnectionUtils.openConnection();


    public static SubscribeService getSubscribeServiceImpl(){
        if (subscribeServiceImpl == null) {
            try {
                return new SubscribeServiceImpl();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return subscribeServiceImpl;
    }

    public SubscribeServiceImpl() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
            subscribeDAO = new SubscribeDAOImpl();
    }

    @Override
    public void create(Subscribe subscribe) {
        try {
            subscribeDAO.create(subscribe);
        } catch (SQLException | IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            LOG.error(e);
        }
    }

    @Override
    public List<Subscribe> readAll() {
        return subscribeDAO.readAll();
    }

    @Override
    public void update(Subscribe subscribe) {
        subscribeDAO.update(subscribe);
    }

    @Override
    public void deleteById(int id) {
        subscribeDAO.deleteById(id);
    }

    @Override
    public Subscribe getUserByEmail(String email) {
        return subscribeDAO.getUserByEmail(email);
    }

    @Override
    public Subscribe readById(Integer id) {
        return null;
    }


}
