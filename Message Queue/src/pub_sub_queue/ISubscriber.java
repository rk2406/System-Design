package pub_sub_queue;

import pub_sub_queue.models.Message;

public interface ISubscriber {
    String getId();
    void processMessage(Message message) throws InterruptedException;
}
