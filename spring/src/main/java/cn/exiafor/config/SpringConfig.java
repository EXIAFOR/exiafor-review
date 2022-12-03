package cn.exiafor.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration // 配置类
@ComponentScan(basePackages = "cn.exiafor")
@EnableTransactionManagement // 开启事务
public class SpringConfig {

}
