package pub_sub_queue.handlers;

import lombok.Getter;
import pub_sub_queue.models.Topic;
import pub_sub_queue.models.TopicSubscriber;

import java.util.HashMap;
import java.util.Map;

@Getter
public class TopicHandler {
    private final Topic topic;
    private final Map<String, SubscriberWorker> workers = new HashMap<>();

    public TopicHandler(Topic topic) {
        this.topic = topic;
    }

    public void publish(){
        for(TopicSubscriber subscriber: topic.getSubscribers()){
            startWorker(subscriber);
        }
    }

    private void startWorker(TopicSubscriber subscriber){
        final String id= subscriber.getISubscriber().getId();
        if(!workers.containsKey(id)){
            final SubscriberWorker subscriberWorker= new SubscriberWorker(this.topic, subscriber);
            workers.put(id, subscriberWorker);
            new Thread(subscriberWorker).start();
        }

        final SubscriberWorker subscriberWorker= workers.get(id);
        subscriberWorker.wakeUpIfNeeded();
    }
}
