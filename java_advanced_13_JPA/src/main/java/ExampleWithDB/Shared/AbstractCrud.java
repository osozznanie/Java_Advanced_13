package ExampleWithDB.Shared;

import java.sql.SQLException;
import java.util.List;

public interface AbstractCrud<T> {
    void create(T t) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException;

    List<T> readAll();

    void update(T t);

    void deleteById(int id);
     T getUserByEmail(String email);
    T readById(Integer id);

}

