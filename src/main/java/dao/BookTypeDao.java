package dao;

import config.HibernateConfig;
import java.util.List;
import model.BookType;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BookTypeDao {
  private HibernateConfig hibernateConfig = new HibernateConfig();

  public void addBookType(BookType bookType) {
    Session session = hibernateConfig.getCurrentSessionFromConfig();
    Transaction transaction = session.beginTransaction();

    session.save(bookType);

    session.flush();
    transaction.commit();
  }

  public void getBookType(BookType bookType) {
    Session session1 = hibernateConfig.getCurrentSessionFromConfig();
    Transaction transaction1 = session1.beginTransaction();
    List list = session1.createQuery("from BookType ").list();
    list.stream().forEach(System.out::println);
    transaction1.commit();
  }

  public BookType findByName(String name) {
    Session session1 = hibernateConfig.getCurrentSessionFromConfig();
    Transaction transaction1 = session1.beginTransaction();
    List list = session1.createQuery("from BookType where"
            + " name = ?1 ")
        .setParameter(1,name)
        .list();
    list.stream().forEach(System.out::println);
    transaction1.commit();
    return (BookType) list.get(0);
  }
}
