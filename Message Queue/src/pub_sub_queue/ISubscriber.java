package pub_sub_queue;

import pub_sub_queue.models.Message;

import java.util.concurrent.atomic.AtomicInteger;

public interface ISubscriber {
    String getId();
    void processMessage(Message message) throws InterruptedException;

    AtomicInteger getOffset();
}
