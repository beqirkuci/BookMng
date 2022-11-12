import dao.AuthorDao;
import dao.BookDao;
import dao.BookTypeDao;
import java.time.LocalDate;
import java.util.List;
import model.Author;
import model.Book;
import model.BookType;
import model.Page;

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
    BookDao  bookDao = new BookDao();
//    Author author = authorDao.findByNameAndSurname("Ismail1","Kadare");
//    BookType bookType = bookTypeDao.findByName("Roman");
//
//    Page page1 = Page.builder()
//        .nr(14)
//        .paragraph("Autori flet per jeten e tij")
//        .build();
//
//    Page page2 = Page.builder()
//        .nr(15)
//        .paragraph("hyrje")
//        .build();
//
//    List<Page> pages = List.of(page1, page2);
//
//    Book book = Book.builder().title("Kronike ne gur")
//            .releaseDate(LocalDate.of(1971,2,23))
//                .author(author).
//        bookType(bookType)
//        .pages(pages).build();
//
//    bookDao.addBook(book);
//

    List<Book> books = bookDao.getBooks();
    Long lastId = books.get(books.size() - 1).getId();
    System.out.println("Books before : "+ books.size());
    bookDao.removeBook(lastId);
    System.out.println("Books after : "+ books.size());


    books.stream().forEach(b -> System.out.println(b.toString()));





  }

}
