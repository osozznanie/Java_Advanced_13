package ExampleWithDB.Servlets;

import ExampleWithDB.Service.MagazineService;
import ExampleWithDB.Service.SubscribeService;
import ExampleWithDB.Service.UserService;
import ExampleWithDB.Service.impl.MagazineServiceImpl;
import ExampleWithDB.Service.impl.SubscribeServiceImpl;
import ExampleWithDB.Service.impl.UserServiceImpl;
import ExampleWithDB.shop.Magazine;
import ExampleWithDB.shop.Subscribe;
import ExampleWithDB.shop.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@WebServlet("/subscribe")
public class SubscribeServlet extends HttpServlet {

    private final SubscribeService subscribeService = SubscribeServiceImpl.getSubscribeServiceImpl();
    private final MagazineService magazineService = MagazineServiceImpl.getMagazineServiceImpl();
    private final UserService userService = UserServiceImpl.getUserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String mID = req.getParameter("idMagazine");
        HttpSession session = req.getSession();
        Integer userID = (Integer) session.getAttribute("idUser");
        User user = null;
        user = userService.readById(userID);

        System.out.println(user + " -> SubscribeServlet");
        String magazineID = req.getParameter("idMagazine");
        Magazine magazine = null;
        magazine = magazineService.readById(Integer.parseInt(magazineID));
        System.out.println(magazine + " -> SubscribeServlet");



//        Magazine magazine = magazineService.readById(Integer.parseInt(mID));

//        HttpSession session = req.getSession();
//        Integer userId = (Integer)session.getAttribute("");
//        User user = userService.readById(userId);

        Subscribe subscribe = new Subscribe(UUID.randomUUID().toString(), user, magazine, true);
        subscribe.setStatusSubscribe(true);

        System.out.println(subscribe + " -> SubscribeServlet");

        try {
            subscribeService.create(subscribe);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write("Success");

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        try {
            subscribeService.deleteById(Integer.parseInt(id));
        } catch (NumberFormatException e) {
            System.out.println("Deleting subscribe failed!" + e);
        }

        resp.setContentType("text");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write("Success");
    }
}
