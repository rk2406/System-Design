package pub_sub_queue;

import lombok.NonNull;
import pub_sub_queue.handlers.SubscriberWorker;
import pub_sub_queue.handlers.TopicHandler;
import pub_sub_queue.models.Message;
import pub_sub_queue.models.Topic;
import pub_sub_queue.models.TopicSubscriber;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Queue {
    private final Map<String, TopicHandler> topicProcessors= new HashMap<>();


    public Topic createTopic(@NonNull final String topicName){
        final Topic topic= new Topic(topicName, UUID.randomUUID().toString());
        TopicHandler topicHandler= new TopicHandler(topic);
        topicProcessors.put(topic.getTopicId(),topicHandler);
        System.out.println("Created Topic "+topic.getTopicName());
        return topic;
    }

    public void subscribe(@NonNull final Topic topic, @NonNull final ISubscriber iSubscriber){
        TopicSubscriber topicSubscriber= new TopicSubscriber(iSubscriber);
        topic.addSubscribers(topicSubscriber);
        System.out.println(iSubscriber.getId()+" subscribed to topic "+topic.getTopicName());
    }

    public void publish(@NonNull final Topic topic, @NonNull Message message){
        topic.addMessage(message);
        System.out.println(message.getMessage() + " published to topic "+ topic.getTopicName());
        new Thread(() -> topicProcessors.get(topic.getTopicId()).publish()).start();
    }

    public void resetOffset(@NonNull Topic topic, @NonNull ISubscriber iSubscriber, @NonNull Integer newOffset){
        SubscriberWorker subscriberWorker = topicProcessors.get(topic.getTopicId()).getWorkers().get(iSubscriber.getId());
        TopicSubscriber topicSubscriber= subscriberWorker.getTopicSubscriber();
        topicSubscriber.getOffset().set(newOffset);

        System.out.println("Subscriber "+topicSubscriber.getISubscriber().getId()+ " set to "+topicSubscriber.getOffset().get());
    }
}
