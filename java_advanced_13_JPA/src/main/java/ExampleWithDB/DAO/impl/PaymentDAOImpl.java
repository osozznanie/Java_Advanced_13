package ExampleWithDB.DAO.impl;

import ExampleWithDB.DAO.PaymentDAO;
import ExampleWithDB.Models.ConnectionUtils;
import ExampleWithDB.shop.Payment;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAOImpl implements PaymentDAO {
    static String INSERT = "INSERT INTO payments (id_subscribe, sum) VALUE(?,?)";
    static String READ_ALL = "SELECT * FROM payments";
    static String UPDATE = "UPDATE payments SET id_subscribe = ?, sum = ?";
    static String DELETE = "DELETE FROM payments WHERE id = ?";
    private final Connection dbConnection = ConnectionUtils.openConnection();
    private PreparedStatement preparedStatement;
    private final static Logger LOG = Logger.getLogger(PaymentDAOImpl.class);


    public PaymentDAOImpl() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
    }

    @Override
    public void create(Payment payments) {
        try {
            preparedStatement = dbConnection.prepareStatement(INSERT);
            preparedStatement.setInt(1, payments.getIdSubscribe());
            preparedStatement.setInt(2, payments.getSum());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOG.error(e);
        }


    }

    @Override
    public List<Payment> readAll() {
        List<Payment> paymentsList = new ArrayList<>();
        try {
            preparedStatement = dbConnection.prepareStatement(READ_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Payment payments = new Payment();
                payments.setId(resultSet.getInt("id"));
                payments.setIdSubscribe(resultSet.getInt("id_subscribe"));
                payments.setSum(resultSet.getInt("sum"));
                payments.setDate(resultSet.getDate("date"));


                paymentsList.add(payments);
            }

        } catch (SQLException e) {
            LOG.error(e);
        }

        return paymentsList;
    }


    @Override
    public void update(Payment payments) {
        try {
            preparedStatement = dbConnection.prepareStatement(UPDATE);
            preparedStatement.setInt(1, payments.getIdSubscribe());
            preparedStatement.setInt(2, payments.getSum());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOG.error(e);
        }
    }

    @Override
    public void deleteById(int id) {
        try {
            preparedStatement = dbConnection.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOG.error(e);
        }

    }

    @Override
    public Payment getUserByEmail(String email) {
        return null;
    }

    @Override
    public Payment readById(Integer id) {
        return null;
    }
}

