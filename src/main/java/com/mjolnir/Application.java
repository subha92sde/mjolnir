package com.mjolnir;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.math.BigDecimal;
import java.time.Year;
import java.util.Properties;

public class Application {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();

        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        properties.put(Environment.URL, "jdbc:mysql://localhost:3306/mjolnir");
        properties.put(Environment.USER, "root");
        properties.put(Environment.PASS, "12345");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
        properties.put(Environment.SHOW_SQL, "true");

        configuration.setProperties(properties);

        configuration.addAnnotatedClass(Movie.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        Session session = sessionFactory.openSession();

        Movie movie = new Movie();
        movie.setTitle("Inception");
        movie.setYearOfRelease(Year.of(2010));
        movie.setImdbRating(BigDecimal.valueOf(8.8));

        Transaction transaction = session.beginTransaction();
        session.save(movie);

        session.flush();
        session.clear();

        transaction.commit();

        session.close();
    }
}
