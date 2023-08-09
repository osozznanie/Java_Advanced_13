package ExampleWithDB.Servlets;

import ExampleWithDB.Service.MagazineService;
import ExampleWithDB.Service.UserService;
import ExampleWithDB.Service.impl.MagazineServiceImpl;
import ExampleWithDB.Service.impl.UserServiceImpl;
import ExampleWithDB.shop.Magazine;
import ExampleWithDB.shop.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/check_email")
public class CheckEmailServlet extends HttpServlet {
    private final UserService userService = UserServiceImpl.getUserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("email");

        User existingUser = userService.getUserByEmail(email);
        if (existingUser != null) {
            resp.setContentType("text/plain");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write("Email already exists");
        } else {
            resp.setContentType("text/plain");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write("Email is available");
        }
    }
}
