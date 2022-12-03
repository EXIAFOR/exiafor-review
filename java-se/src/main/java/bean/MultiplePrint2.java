package bean;

public class MultiplePrint2 extends Thread {
    @Override
    public void run() {

        MultiplePrint2 multiplePrint2 = this;

        synchronized (this) {
            System.out.println(this);
        }
    }
}
