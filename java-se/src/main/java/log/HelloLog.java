package log;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import lombok.extern.slf4j.Slf4j;
import org.fusesource.jansi.AnsiConsole;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloLog {
    static Logger log;

    public static void main(final String[] args) {
//        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
//            AnsiConsole.systemInstall();
//        }

        log = LoggerFactory.getLogger(HelloLog.class);

        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();

        ch.qos.logback.classic.Logger root = context.getLogger("ROOT");

        Level runtimeLevel = Level.INFO;

        log.info("日志级别设置为 " + runtimeLevel);
        root.setLevel(runtimeLevel);


        log.error("没有错误");
        log.warn("msg");
        log.info("主程序启动");
        log.debug("msg");
        log.trace("msg");

        testOut();

        Inner inner = new Inner();
        inner.outString();
    }

    private static void testOut() {
        log.info("msg");
    }

    static class Inner {
        public void outString() {
            log = LoggerFactory.getLogger(getClass());
            log.error("error");
        }
    }
}
