package ExampleWithDB.Service.impl;

import ExampleWithDB.DAO.MagazineDAO;
import ExampleWithDB.DAO.impl.MagazineDAOImpl;
import ExampleWithDB.Service.MagazineService;
import ExampleWithDB.shop.Magazine;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MagazineServiceImpl implements MagazineService {
    private MagazineDAO magazineDAO;
    private final static Logger LOG = Logger.getLogger(MagazineServiceImpl.class);
    private static MagazineService magazineServiceImpl;

    public static MagazineService getMagazineServiceImpl() {
        if (magazineServiceImpl == null){
            return new MagazineServiceImpl();
        }
        return magazineServiceImpl;
    }

    public MagazineServiceImpl() {
            magazineDAO = new MagazineDAOImpl();
    }

    @Override
    public void create(Magazine magazine)  {
        try {
            magazineDAO.create(magazine);
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            LOG.error(e);
        }
    }

    @Override
    public List<Magazine> readAll() {
        return magazineDAO.readAll();
    }

    @Override
    public void update(Magazine magazine) {
        magazineDAO.update(magazine);
    }

    @Override
    public void deleteById(int id) {
        magazineDAO.deleteById(id);
    }

    @Override
    public Magazine getUserByEmail(String email) {
        return magazineDAO.getUserByEmail(email);
    }

    @Override
    public Magazine readById(Integer id) {
        return magazineDAO.readById(id);
    }

    @Override
    public Map<Integer, Magazine> readAllMap() {
        return readAll().stream().collect(Collectors.toMap(Magazine::getId, Function.identity()));
    }
}
