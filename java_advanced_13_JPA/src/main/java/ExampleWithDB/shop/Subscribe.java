package ExampleWithDB.shop;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "subscribe")
public class Subscribe {
    @Id
    @Column
    private String id;
    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_magazine", referencedColumnName = "id")
    private Magazine magazine;

    private LocalDate date;

    @Column(name = "status_subscribe")
    private boolean statusSubscribe;

    public Subscribe(User user, Magazine magazine, boolean statusSubscribe) {
        this.user = user;
        this.magazine = magazine;
        this.statusSubscribe = statusSubscribe;
    }

    public Subscribe(String id, User user, Magazine magazine, boolean statusSubscribe) {
        this.id = id;
        this.user = user;
        this.magazine = magazine;
        this.statusSubscribe = true;
    }

    public Subscribe(){

    }


    public String getId() {
        return id;
    }



    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Magazine getMagazine() {
        return magazine;
    }

    public void setMagazine(Magazine magazine) {
        this.magazine = magazine;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isStatusSubscribe() {
        return statusSubscribe;
    }

    public void setStatusSubscribe(boolean statusSubscribe) {
        this.statusSubscribe = statusSubscribe;
    }

    @Override
    public String toString() {
        return "Subscribe{" +
                "id=" + id +
                ", user=" + user +
                ", magazine=" + magazine +
                ", date=" + date +
                ", statusSubscribe=" + statusSubscribe +
                '}';
    }
}

