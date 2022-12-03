package system;

public class Desktop {
    public static void main(String[] args) {
        String property = System.getProperty("os.name");
        System.out.println("sun.desktop --> " + property);
    }
}
