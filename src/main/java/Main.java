import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {
    public static void main(String[] args){
        BlockingQueue<Order> orders = new LinkedBlockingDeque<>(2);
            orders.add(new Order());
//        orders.add(new Order());
//        orders.add(new Order());
        SubmitOrderThread submitOrderThread = new SubmitOrderThread(orders);
        SubmitOrderThread submitOrderThread1 = new SubmitOrderThread(orders);
        SubmitOrderThread submitOrderThread2 = new SubmitOrderThread(orders);

        CompleteOrderThread completeOrderThread = new CompleteOrderThread(orders);
        CompleteOrderThread completeOrderThread1 = new CompleteOrderThread(orders);

        submitOrderThread.start();
        submitOrderThread1.start();
        submitOrderThread2.start();
        completeOrderThread.start();
        completeOrderThread1.start();
        try {
            submitOrderThread.join();
            completeOrderThread.join();
            submitOrderThread1.join();
            completeOrderThread1.join();
        }
        catch (Exception e){
            System.out.println("Can't join threads");
        }
    }
}
