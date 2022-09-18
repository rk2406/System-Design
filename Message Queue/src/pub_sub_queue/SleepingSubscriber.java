package pub_sub_queue;

import pub_sub_queue.models.Message;

import java.util.concurrent.atomic.AtomicInteger;

public class SleepingSubscriber implements ISubscriber{
    private final String id;
    private final int sleepTime;

    private final AtomicInteger offset;

    public SleepingSubscriber(String id, int sleepTime) {
        this.id = id;
        this.sleepTime = sleepTime;
        this.offset= new AtomicInteger(0);
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void processMessage(Message message) throws InterruptedException {
        System.out.println("Subscriber "+id+" started consuming message "+message.getMessage());
        Thread.sleep(sleepTime);
        System.out.println("Subscriber "+id+" done consuming message "+message.getMessage());
    }

    @Override
    public AtomicInteger getOffset() {
        return offset;
    }

}
