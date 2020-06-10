import java.util.concurrent.BlockingQueue;

public class SubmitOrderThread extends Thread {
    private BlockingQueue<Order> orders;

    @Override
    public void run() {
        try {
            while (true) {
                Order order = new Order();
                orders.put(order);
                System.out.println("An order has been placed " + order.toString());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    SubmitOrderThread(BlockingQueue<Order> orders) {
        this.orders = orders;
    }
}
