package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarDaoImp implements CarDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addCar(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    public List<User> printCar(String model, int series) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from User where car.model = :model and car.series = :series");
        query.setParameter("model", model);
        query.setParameter("series", series);
        return query.getResultList();
    }
}
