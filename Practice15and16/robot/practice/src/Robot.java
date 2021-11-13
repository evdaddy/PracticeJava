public class Robot {
    private final Object monitor = new Object();

    class Leg implements Runnable {
        private final String name;

        Leg(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            while(true) {
                synchronized (monitor) {
                    step();
                    monitor.notify();
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        private void step() {
            System.out.println(name);
        }
    }

    Leg left = new Leg("LEFT");
    Leg right = new Leg("RIGHT");

    void run() {
        new Thread(left).start();
        new Thread(right).start();
    }

    public static void main(String[] args) {
        new Robot().run();
    }
}
