package ExampleWithDB.Servlets;

import ExampleWithDB.Service.MagazineService;
import ExampleWithDB.Service.impl.MagazineServiceImpl;
import ExampleWithDB.shop.Magazine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/magazine")
public class MagazineController extends HttpServlet {
    private final MagazineService magazineService = MagazineServiceImpl.getMagazineServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String priceStr = req.getParameter("price");


        // Validate that required parameters are not null or empty
        if (name == null || name.isEmpty() || description == null || description.isEmpty() || priceStr == null || priceStr.isEmpty()) {
            resp.setContentType("text/plain");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write("Error: Please fill in all required fields.");
            return;
        }

        int price = Integer.parseInt(priceStr);

        Magazine magazine = new Magazine(name, description, price);
        try {
            magazineService.create(magazine);
            resp.setContentType("text/plain");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write("Success");
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        int magazineId = Integer.parseInt(id);
        Magazine magazine = magazineService.readById(magazineId);

        System.out.println(magazineId);
        req.setAttribute("magazine", magazine);
        req.getRequestDispatcher("singleMagazine.jsp").forward(req, resp);
    }
}



