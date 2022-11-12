package config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {
  public Session getCurrentSessionFromConfig() {
    Configuration config = new Configuration();
    config.configure();

    SessionFactory sessionFactory = config.buildSessionFactory();
    Session session = sessionFactory.getCurrentSession();
    return session;
  }
}
