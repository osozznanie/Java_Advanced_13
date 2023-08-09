package ExampleWithDB.shop;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "magazines")
public class Magazine {
    @Id
    @Column
    protected int id;
    @Column(name = "name_of_magazine")
    protected String nameOfMagazine;
    @Column
    protected String description;
    @Column
    protected int price;

    public Magazine(int id, String nameOfMagazine, String description, int price) {
        this.id = id;
        this.nameOfMagazine = nameOfMagazine;
        this.description = description;
        this.price = price;
    }

    public Magazine() {
    }

    public Magazine(String nameOfMagazine, String description, int price) {
        this.nameOfMagazine = nameOfMagazine;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfMagazine() {
        return nameOfMagazine;
    }

    public void setNameOfMagazine(String nameOfMagazine) {
        this.nameOfMagazine = nameOfMagazine;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Magazines{" +
                "id=" + id +
                ", nameOfMagazine='" + nameOfMagazine + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
