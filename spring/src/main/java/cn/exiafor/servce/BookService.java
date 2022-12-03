package cn.exiafor.servce;

import cn.exiafor.bean.Book;
import cn.exiafor.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    // 注入dao
    @Autowired
    private BookDao bookDao;

    public void addBook(Book book) {
        bookDao.add(book);
    }

    public void updateBook(Book book) {
        bookDao.update(book);
    }

    public void deleteBook(int id) {
        bookDao.delete(id);
    }

    public int selectCount() {
        return bookDao.selectCount();
    }

    public Book findBookInfo(int id) {
        return bookDao.findBookInfo(id);
    }

    public List<Book> findAllBook() {
        return bookDao.findAllBook();
    }

    public void batchAddBook(List<Object[]> batchArgs) {
        bookDao.batchAddBook(batchArgs);
    }

    public void batchUpdateBook(List<Object[]> batchArgs) {
        bookDao.batchUpdateBook(batchArgs);
    }

    public void batchDeleteBook(List<Object[]> batchArgs) {
        bookDao.batchDeleteBook(batchArgs);
    }
}
