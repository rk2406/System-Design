package pub_sub_queue.handlers;

import lombok.Getter;
import lombok.SneakyThrows;
import pub_sub_queue.models.Message;
import pub_sub_queue.models.Topic;
import pub_sub_queue.models.TopicSubscriber;

@Getter
public class SubscriberWorker implements Runnable{
    private final Topic topic;
    private final TopicSubscriber topicSubscriber;

    public SubscriberWorker(Topic topic, TopicSubscriber topicSubscriber) {
        this.topic = topic;
        this.topicSubscriber = topicSubscriber;
    }

    @SneakyThrows
    @Override
    public void run() {
        synchronized (topicSubscriber){
            do{
                int currOffset = topicSubscriber.getOffset().get();
                if(currOffset >= topic.getMessages().size()) {
                    topicSubscriber.wait();
                }
                else{
                    Message message= topic.getMessages().get(currOffset);
                    topicSubscriber.getISubscriber().processMessage(message);

                    topicSubscriber.getOffset().compareAndSet(currOffset,currOffset+1);
                }

            }while (true);
        }
    }

    public void wakeUpIfNeeded(){
        synchronized (topicSubscriber){
            topicSubscriber.notify();
        }
    }
}
