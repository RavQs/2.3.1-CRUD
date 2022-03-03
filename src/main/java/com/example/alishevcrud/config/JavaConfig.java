package com.example.alishevcrud.config;

import com.example.alishevcrud.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class JavaConfig {
    private static SessionFactory sessionFactory;

    private final static String USER_NAME = "Ravv";
    private final static String USER_PASS = "5378144Kor!";
    private final static String CONNECTION_URL = "jdbc:mysql://localhost:3306/kata";

    private JavaConfig(){}

    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null){
            try {
                Configuration configuration = new Configuration();
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.USER, USER_NAME);
                settings.put(Environment.PASS, USER_PASS);
                settings.put(Environment.URL, CONNECTION_URL);
                settings.put(Environment.SHOW_SQL,true);
                settings.put(Environment.DIALECT,"org.hibernate.dialect.MySQL5Dialect");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.HBM2DDL_AUTO, "none");

                configuration.setProperties(settings);
                configuration.addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
