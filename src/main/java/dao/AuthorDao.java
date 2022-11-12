package dao;

import com.sun.tools.javac.Main;
import config.HibernateConfig;
import java.util.List;
import model.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AuthorDao {
  private  HibernateConfig hibernateConfig = new HibernateConfig();

  public void addAuthor() {
    Author author = Author.builder().name("Ismail1111")
        .surname("Kadare")
        .email("kadare@gmail.com").build();


    Session session = hibernateConfig.getCurrentSessionFromConfig();
    Transaction transaction = session.beginTransaction();
    session.save(author);
    session.flush();
    transaction.commit();
  }

  public void getAuthors() {
    Session session1 = hibernateConfig.getCurrentSessionFromConfig();
    Transaction transaction1 = session1.beginTransaction();
    List list = session1.createQuery("from Author ").list();
    list.stream().forEach(System.out::println);
    transaction1.commit();
  }
}
