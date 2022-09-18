import pub_sub_queue.Queue;
import pub_sub_queue.SleepingSubscriber;
import pub_sub_queue.models.Message;
import pub_sub_queue.models.Topic;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final Queue queue= new Queue();
        final Topic topic1= queue.createTopic("t1");
        final Topic topic2= queue.createTopic("t2");

        final SleepingSubscriber sub1= new SleepingSubscriber("sub1",5000);
        final SleepingSubscriber sub2= new SleepingSubscriber("sub2",10000);
        final SleepingSubscriber sub3= new SleepingSubscriber("sub3",10000);

        queue.subscribe(topic1,sub2);
        queue.subscribe(topic2,sub1);
        queue.subscribe(topic2,sub3);

        queue.publish(topic1,new Message("m1")); //s2
        queue.publish(topic1,new Message("m2")); //s2

        queue.publish(topic2,new Message("m3")); //s1,s3

        Thread.sleep(15000);

        queue.publish(topic1,new Message("m4")); //s2
        queue.publish(topic2,new Message("m5")); //s1,s3

        queue.resetOffset(topic1,sub2,0);
    }
}