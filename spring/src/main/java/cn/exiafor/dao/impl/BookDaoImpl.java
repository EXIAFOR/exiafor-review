package cn.exiafor.dao.impl;

import cn.exiafor.bean.Book;
import cn.exiafor.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {
    // 注入jdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void add(Book book) {
        // 1 创建sql语句
        String sql = "insert into book values (?,?,?)";
        // 2 调用方法实现
        Object[] args = {book.getId(), book.getName(), book.getStatus()};

        int add = jdbcTemplate.update(sql, args);
        System.out.println(add);
    }

    @Override
    public void update(Book book) {
        String sql = "update book set name = ?, status = ? where id = ?";

        Object[] args = {book.getName(), book.getStatus(), book.getId()};

        int update = jdbcTemplate.update(sql, args);
        System.out.println(update);
    }

    @Override
    public void delete(int id) {
        String sql = "delete from book where id = ?";

        int delete = jdbcTemplate.update(sql, id);
        System.out.println(delete);
    }

    // 查询表记录数
    @Override
    public int selectCount() {
        String sql = "select count(*) from book";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }

    // 查询返回对象
    @Override
    public Book findBookInfo(int id) {
        String sql = "select * from book where id = ?";

        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class), id);

        return book;
    }

    @Override
    // 查询返回集合
    public List<Book> findAllBook() {
        String sql = "select * from book";


        jdbcTemplate.batchUpdate(sql, new ArrayList<>());

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
    }

    // 批量添加
    @Override
    public void batchAddBook(List<Object[]> batchArgs) {
        String sql = "insert into book values (?,?,?)";
        int[] batchUpdate = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(batchUpdate));
    }

    @Override
    public void batchUpdateBook(List<Object[]> batchArgs) {
        String sql = "update book set name = ? , status = ? where id = ?";
        int[] batchUpdate = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(batchUpdate));
    }

    @Override
    public void batchDeleteBook(List<Object[]> batchArgs) {
        String sql = "delete from book where id = ?";
        int[] batchUpdate = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(batchUpdate));
    }
}
