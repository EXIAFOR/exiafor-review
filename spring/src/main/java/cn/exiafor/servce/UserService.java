package cn.exiafor.servce;

import cn.exiafor.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED,
        isolation = Isolation.REPEATABLE_READ)
public class UserService {
    @Autowired
    private UserDao userDao;

    // 转账的方法
    public void accountMoney() {
        // 第一步 开启事务

        // 第二步 进行业务操作
//        try {
            userDao.reduceMoney();

            // 模拟异常
            int i = 10 / 0;

            userDao.addMoney();

            // 第三步 没有发生异常，提交事务

//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            // 第四步 出现异常，事务回滚
//        }
    }
}
