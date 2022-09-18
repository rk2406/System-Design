package pub_sub_queue.models;

import lombok.Getter;
import lombok.NonNull;
import pub_sub_queue.ISubscriber;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Topic {
    private final String topicName;
    private final String topicId;
    private final List<Message> messages= new ArrayList<>();
    private final List<ISubscriber> subscribers= new ArrayList<>();

    public Topic(String topicName, String topicId) {
        this.topicName = topicName;
        this.topicId = topicId;
    }

    public synchronized void addMessage(@NonNull Message message){
        messages.add(message);
    }

    public synchronized  void addSubscribers(@NonNull ISubscriber subscriber){
        subscribers.add(subscriber);
    }
}
