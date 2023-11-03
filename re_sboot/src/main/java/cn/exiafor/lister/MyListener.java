package cn.exiafor.lister;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.time.Duration;

public class MyListener implements SpringApplicationRunListener {
    @Override
    public void starting(ConfigurableBootstrapContext bootstrapContext) {
        System.out.println("======= starting =======");
    }

    @Override
    public void environmentPrepared(ConfigurableBootstrapContext bootstrapContext, ConfigurableEnvironment environment) {
        System.out.println("======= environmentPrepared =======");
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("======= contextPrepared =======");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("======= contextLoaded =======");
    }

    @Override
    public void started(ConfigurableApplicationContext context, Duration timeTaken) {
        System.out.println("======= started =======");
    }

    @Override
    public void ready(ConfigurableApplicationContext context, Duration timeTaken) {
        System.out.println("======= ready =======");
    }
}
