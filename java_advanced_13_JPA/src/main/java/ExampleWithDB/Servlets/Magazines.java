package ExampleWithDB.Servlets;

import ExampleWithDB.Service.MagazineService;
import ExampleWithDB.Service.impl.MagazineServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/magazines")
public class Magazines extends HttpServlet {
    private final MagazineService magazineService = MagazineServiceImpl.getMagazineServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ExampleWithDB.shop.Magazine> magazineList = magazineService.readAll();
        String json = new Gson().toJson(magazineList);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }
}
