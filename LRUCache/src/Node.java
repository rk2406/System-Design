public class Node {
    private int key;
    private int value;
    Node pre;
    Node next;

    public Node(int key,int value) {
        this.key = key;
        this.value=value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getKey() {
        return key;
    }
}
