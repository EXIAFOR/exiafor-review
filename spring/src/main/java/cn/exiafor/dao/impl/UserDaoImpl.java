package cn.exiafor.dao.impl;

import cn.exiafor.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /// lucy转账100给mary
    // 少钱
    @Override
    public void reduceMoney() {
        String sql = "update account set money = money - ? where username = ?";
        jdbcTemplate.update(sql, 100, "lucy");
    }

    // 多钱
    @Override
    public void addMoney() {
        String sql = "update account set money = money + ? where username = ?";
        jdbcTemplate.update(sql, 100, "mary");
    }
}
