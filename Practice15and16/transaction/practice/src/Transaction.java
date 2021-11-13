public class Transaction {
    static class Person {
        private long balance = 0;
        Person(long initial) {
            this.balance = initial;
        }
        public long getBalance() {
            return balance;
        }
        void add(long value) {
            this.balance += value;
        }
        void withdraw(long value) {
            if (value > this.balance) {
                throw new IllegalArgumentException();
            }
            this.balance -= value;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "balance=" + balance +
                    '}';
        }
    }

    static class Operation extends Thread {
        private final Object context;
        private final Person from;
        private final Person to;
        private final long value;

        Operation(Object context, Person from, Person to, long value) {
            this.context = context;
            this.from = from;
            this.to = to;
            this.value = value;
        }

        @Override
        public void run() {
            synchronized (context) {
                from.withdraw(value);
                if (isInterrupted()) {
                    from.add(value);
                    return;
                }
                to.add(value);
                if (isInterrupted()) {
                    to.withdraw(value);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object context = new Object();
        Person first = new Person(100L);
        Person second = new Person(200L);

        System.out.println(first.toString());
        System.out.println(second.toString());

        Operation tx_1 = new Operation(context, first, second, 50L);
        tx_1.start();
        tx_1.interrupt();
        tx_1.join();
        // транзакция должна была откатиться, баланс не должен был измениться
        assert first.getBalance() == 100L;
        assert second.getBalance() == 200L;

        System.out.println(first.toString());
        System.out.println(second.toString());
    }
}
