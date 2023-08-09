package ExampleWithDB.Servlets;

import ExampleWithDB.Service.UserService;
import ExampleWithDB.Service.impl.UserServiceImpl;
import ExampleWithDB.shop.AccessLevel;
import ExampleWithDB.shop.User;
import com.google.gson.Gson;
import ExampleWithDB.dto.UserLogin;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private final UserService userService = UserServiceImpl.getUserServiceImpl();
    private final static Logger LOG = Logger.getLogger(LoginServlet.class);


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");


        User user = userService.getUserByEmail(email);
        System.out.println(user + " ----> login-servlet");

        if (user != null && user.getPassword().equals(password)) {
            HttpSession session = req.getSession(true);
            session.setAttribute("idUser", user.getId());
            session.setAttribute("accessLevel",user.getAccessLevel());

            UserLogin userLogin = new UserLogin();
            userLogin.destinationUrl = "cabinet.jsp";
            userLogin.userEmail = user.getEmail();
            String json = new Gson().toJson(userLogin);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(json);
        }
    }
}
