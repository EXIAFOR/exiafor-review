package bean;

public class MultiplePrint implements Runnable {
    @Override
    public void run() {

        MultiplePrint multiplePrint = this;

        synchronized (this) {
            System.out.println(this);
        }
    }
}
