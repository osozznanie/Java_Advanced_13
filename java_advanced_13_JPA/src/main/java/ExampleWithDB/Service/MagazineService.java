package ExampleWithDB.Service;

import ExampleWithDB.shop.Magazine;
import ExampleWithDB.Shared.AbstractCrud;

import java.util.Map;

public interface MagazineService extends AbstractCrud<Magazine> {
    public Map<Integer, Magazine> readAllMap();
}
