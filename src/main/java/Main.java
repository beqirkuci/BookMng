import dao.AuthorDao;
import dao.BookDao;
import dao.BookTypeDao;
import java.time.LocalDate;
import model.Author;
import model.Book;
import model.BookType;

public class Main {

  public static void main(String[] args) {
    AuthorDao authorDao = new AuthorDao();
    BookTypeDao bookTypeDao = new BookTypeDao();

  /*  AuthorDao authorDao = new AuthorDao();
    Author author = Author.builder().name("Ismail1111")
        .surname("Kadare")
        .email("kadare@gmail.com").build();
    authorDao.addAuthor(author);
    authorDao.getAuthors();

   */

   /* BookTypeDao bookTypeDao = new BookTypeDao();
    BookType bookType = BookType.builder().name("Roman").description("Drama").build();

    bookTypeDao.getBookType(bookType);
    bookTypeDao.addBookType(bookType);

    */

    Author author = authorDao.findByNameAndSurname("Ismail1","Kadare");

    BookType bookType = bookTypeDao.findByName("Roman");


    BookDao  bookDao = new BookDao();
    Book book = Book.builder().title("Gjeneral i ushtrise se vdekur1111")
            .releaseDate(LocalDate.of(1971,2,23))
                .author(author).
        bookType(bookType).build();

    bookDao.addBook(book);

  }
}
