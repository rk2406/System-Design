import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private HashMap<Integer,Node> map;
    private int capacity;
    private int count;
    private Node head;
    private Node tail;

    LRUCache(int capacity){
        this.capacity=capacity;
        map=new HashMap<>();
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;
        tail.pre=head;
        head.pre=null;
        tail.next=null;
        count=0;
    }

    private  void deleteNode(Node node){
        node.pre.next=node.next;
        node.next.pre=node.pre;
    }

    private void addToHead(Node node){
        node.pre=head;
        node.next=head.next;
        node.next.pre=node;
        head.next=node;
    }

    int getKey(int key){
        if(map.get(key)!=null){
            Node node=map.get(key);
            int result= node.getValue();
            deleteNode(node);
            addToHead(node);
            return result;
        }
        return -1;
    }

    void setKey(int key, int value){
        if(map.get(key)!=null){
            Node node=map.get(key);
            node.setValue(value);
            deleteNode(node);
            addToHead(node);
        }
        else{
            Node node =new Node(key,value);
            map.put(key,node);
            if(count<capacity){
                count++;
                addToHead(node);
            }
            else{
                map.remove(tail.pre.getKey());
                deleteNode(tail.pre);
                addToHead(node);
            }
        }
        display();
    }

    private void display(){
        Node curr=head.next;
        while(curr.next!=null){
            System.out.println("Key = "+curr.getKey()+" Value = "+curr.getValue());
            curr=curr.next;
        }
    }
}
