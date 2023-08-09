package ExampleWithDB.Application;

import ExampleWithDB.DAO.impl.MagazineDAOImpl;
import ExampleWithDB.DAO.impl.PaymentDAOImpl;
import ExampleWithDB.DAO.impl.SubscribeDAOImpl;
import ExampleWithDB.DAO.impl.UserDAOImpl;
import ExampleWithDB.Service.MagazineService;
import ExampleWithDB.Service.UserService;
import ExampleWithDB.Service.impl.MagazineServiceImpl;
import ExampleWithDB.Service.impl.UserServiceImpl;
import ExampleWithDB.shop.AccessLevel;
import ExampleWithDB.shop.User;

import java.sql.SQLException;
import java.text.ParseException;

public class App {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, ParseException {
        MagazineService magazineService = MagazineServiceImpl.getMagazineServiceImpl();
        magazineService.readAll().forEach(System.out::println);

        UserService userService = UserServiceImpl.getUserServiceImpl();
        userService.getUserByEmail("d");















    }
}
