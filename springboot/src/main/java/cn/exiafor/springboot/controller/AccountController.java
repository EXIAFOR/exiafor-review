package cn.exiafor.springboot.controller;

import cn.exiafor.springboot.bean.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;

@Slf4j
@RestController
public class AccountController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/account/{id}")
    public String getAccount(@PathVariable("id") Integer id) {
        String sql = "select * from account where id = ?";

        Account account;

        try {
            account = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Account.class), id);
        } catch (EmptyResultDataAccessException e) {
            log.error("没有这个id值对应的account对象");
            return "没有这个id值对应的account对象";
        }

        assert account != null;
        return account.toString();
    }

    @PostMapping("/account")
    public String saveAccount() {
        String sql = "insert into account values(?,?,?)";





        return "POST-张三";
    }

    @PutMapping("/account")
    public String updateAccount() {
        return "PUT-张三";
    }

    @DeleteMapping("/account")
    public String deleteAccount() {
        return "DELETE-张三";
    }
}
