public class Main {
    public static void main(String[] args) {

        LRUCache cache= new LRUCache(4);
        cache.setKey(2,3);
        System.out.println("-------------");
        cache.setKey(3,4);
        System.out.println("-------------");
        cache.setKey(7,8);
        System.out.println("-------------");
        cache.setKey(2,5);
        System.out.println("-------------");
        cache.setKey(5,9);
        System.out.println("-------------");
        cache.setKey(1,4);
        System.out.println("-------------");


    }
}