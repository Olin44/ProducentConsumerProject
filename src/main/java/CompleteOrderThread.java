import java.util.concurrent.BlockingQueue;

public class CompleteOrderThread extends Thread {
    private BlockingQueue<Order> orders;
    CompleteOrderThread(BlockingQueue<Order> orders) {
        this.orders = orders;
    }

    @Override
    public void run(){
        try {
            while (true) {
                Order order = orders.take();
                order.setOrderStatus("completed");
                System.out.println("Order made " + order.toString());
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
