package pub_sub_queue.models;

import lombok.Getter;
import pub_sub_queue.ISubscriber;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class TopicSubscriber {
    private final AtomicInteger offset;
    private final ISubscriber iSubscriber;

    public TopicSubscriber(ISubscriber iSubscriber) {
        this.offset = new AtomicInteger(0);
        this.iSubscriber = iSubscriber;
    }
}
