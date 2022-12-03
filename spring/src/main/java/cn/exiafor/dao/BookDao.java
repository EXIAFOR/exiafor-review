package cn.exiafor.dao;

import cn.exiafor.bean.Book;

import java.util.List;

public interface BookDao {
    void add(Book book);

    void update(Book book);

    void delete(int id);

    int selectCount();

    Book findBookInfo(int id);

    // 查询返回集合
    List<Book> findAllBook();

    void batchAddBook(List<Object[]> batchArgs);

    void batchUpdateBook(List<Object[]> batchArgs);

    void batchDeleteBook(List<Object[]> batchArgs);
}
