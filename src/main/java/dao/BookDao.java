package dao;

import config.HibernateConfig;
import model.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BookDao {
  private HibernateConfig hibernateConfig = new HibernateConfig();

  public void addBook(Book book) {
    Session session = hibernateConfig.getCurrentSessionFromConfig();
    Transaction transaction = session.beginTransaction();
    session.save(book);
    session.flush();
    transaction.commit();
  }
}
