package ExampleWithDB.Servlets;

import ExampleWithDB.Service.MagazineService;
import ExampleWithDB.Service.SubscribeService;
import ExampleWithDB.Service.impl.MagazineServiceImpl;
import ExampleWithDB.Service.impl.SubscribeServiceImpl;
import ExampleWithDB.shop.Magazine;
import ExampleWithDB.shop.Subscribe;
import com.google.gson.Gson;
import ExampleWithDB.dto.SubscribeDto;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet("/subscribes")
public class SubscribesController extends HttpServlet {

    private final MagazineService magazineService = MagazineServiceImpl.getMagazineServiceImpl();
    private final SubscribeService subscribeService = SubscribeServiceImpl.getSubscribeServiceImpl();
    private final static org.apache.log4j.Logger LOG = Logger.getLogger(SubscribesController.class);

    public List<SubscribeDto> map(List<Subscribe> subscribes, Map<Integer, Magazine> magazinesMap) {
        return subscribes.stream().map(subscribe -> {
            SubscribeDto subscribesDTO = new SubscribeDto();
            subscribesDTO.subscribeId = subscribe.getId();

            Magazine magazine = magazinesMap.get(subscribe.getMagazine().getId());
            subscribesDTO.nameOfMagazine = magazine.getNameOfMagazine();
            subscribesDTO.description = magazine.getDescription();
            subscribesDTO.price = magazine.getPrice();

            System.out.println("----------------");
            System.out.println(subscribesDTO + " -----> SubscribesController map");
            System.out.println("----------------");

            return subscribesDTO;
        }).collect(Collectors.toList());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Subscribe> subscribes = null;

        try {
            LOG.trace("Getting list of subscribes from database...");
            subscribes = subscribeService.readAll();
        } catch (RuntimeException e) {
            LOG.error("Getting list of subscribes failed!", e);
        }

        Map<Integer, Magazine> magazinesMap = null;

        try {
            LOG.trace("Getting map of magazines from database...");
            magazinesMap = magazineService.readAllMap();
        } catch (RuntimeException e) {
            LOG.error("Getting map of magazines failed!", e);
        }

        List<SubscribeDto> subscribesDTO = map(subscribes, magazinesMap);

        if (subscribes == null || magazinesMap == null) {
            LOG.warn("There is no any magazine or subscribe in database registered!");
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("No subscriptions or magazines are registered in the database!");
        } else {
            LOG.trace("Returning list of subscribes DTO...");
            String json = new Gson().toJson(subscribesDTO);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        }
        System.out.println("----------------");
        System.out.println(subscribesDTO + " -----> SubscribesController map");
        System.out.println("----------------");
    }
}
