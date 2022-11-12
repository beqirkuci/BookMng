import dao.AuthorDao;

public class Main {

  public static void main(String[] args) {
    AuthorDao authorDao = new AuthorDao();
    authorDao.addAuthor();
    authorDao.getAuthors();
  }
}
