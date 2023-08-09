package ExampleWithDB.Service.impl;

import ExampleWithDB.DAO.PaymentDAO;
import ExampleWithDB.DAO.impl.PaymentDAOImpl;
import ExampleWithDB.Service.PaymentService;
import ExampleWithDB.shop.Payment;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class PaymentServiceImpl implements PaymentService {
    private PaymentDAO paymentDAO;
    private final static Logger LOG = Logger.getLogger(PaymentDAOImpl.class);
    private static PaymentService paymentServiceImpl;

    public static PaymentService getMagazineServiceImpl() {
        if (paymentServiceImpl == null){
            return new PaymentServiceImpl();
        }
        return paymentServiceImpl;
    }


    public PaymentServiceImpl() {
        try {
            paymentDAO = new PaymentDAOImpl();
        } catch (SQLException | IllegalAccessException | ClassNotFoundException | InstantiationException e) {
            LOG.error(e);
        }
    }

    @Override
    public void create(Payment payment) {
        try {
            paymentDAO.create(payment);
        } catch (SQLException | IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            LOG.error(e);
        }
    }

    @Override
    public List<Payment> readAll() {
        return paymentDAO.readAll();
    }

    @Override
    public void update(Payment payment) {
        paymentDAO.update(payment);
    }

    @Override
    public void deleteById(int id) {
        paymentDAO.deleteById(id);
    }

    @Override
    public Payment getUserByEmail(String email) {
        return paymentDAO.getUserByEmail(email);
    }

    @Override
    public Payment readById(Integer id) {
        return null;
    }
}
