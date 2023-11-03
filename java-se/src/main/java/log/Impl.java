package log;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Impl {
    private static Logger log = Logger.getLogger(Impl.class.toString());

    public static void main(String[] args) {
        // all→finest→finer→fine→config→info→warning→server→off
        // 级别依次升高，后面的日志级别会屏蔽之前的级别
        log.setLevel(Level.SEVERE);

        log.finest("finest");
        log.finer("finer");
        log.fine("fine");
        log.config("config");
        log.info("info");
        log.warning("warning");
        log.severe("server");
    }

    public void test1() throws FileNotFoundException {
        System.out.println(System.getProperty("user.dir"));

        File file = new File("D:\\d-dual-backup-to-e\\code-old\\JavaSEreview\\out\\production\\JavaSEreview\\log4j.properties");

        System.out.println(file.getAbsoluteFile());

        System.out.println(file.exists());

        FileInputStream fis = new FileInputStream(file);

        System.out.println();
    }
}
