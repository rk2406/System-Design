public class Player {
    private String name;
    private int id; // we can have email id and mobile no as well

    Player(String name, int id) {
        this.name = name;
        this.id = id;
    }

    String getName() {
        return name;
    }

    Integer getId() {
        return id;
    }
}
