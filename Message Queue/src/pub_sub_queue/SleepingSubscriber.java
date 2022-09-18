package pub_sub_queue;

import pub_sub_queue.models.Message;

public class SleepingSubscriber implements ISubscriber{
    private final String id;
    private final int sleepTime;

    public SleepingSubscriber(String id, int sleepTime) {
        this.id = id;
        this.sleepTime = sleepTime;
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
}
