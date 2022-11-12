package dao;

import config.HibernateConfig;
import java.util.List;
import model.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class BookDao {
  private HibernateConfig hibernateConfig = new HibernateConfig();

  public void addBook(Book book) {
    Session session = hibernateConfig.getCurrentSessionFromConfig();
    Transaction transaction = session.beginTransaction();
    session.save(book);
    session.flush();
    transaction.commit();
  }

  public List<Book> getBooks() {

    Session session = hibernateConfig.getCurrentSessionFromConfig();
    Transaction transaction = session.beginTransaction();

    return session.createQuery(" FROM Book", Book.class).getResultList();
  }

  public void removeBook(Long lastId) {


    Session session = hibernateConfig.getCurrentSessionFromConfig();
    Transaction transaction = session.beginTransaction();

    Query query = session.createQuery("delete Book where id = :lastId");
    query.setParameter("lastId", lastId);
    int result = query.executeUpdate();

    if (result > 0) {
      transaction.commit();
    System.out.println("Book was removed");
    }

  }
}
