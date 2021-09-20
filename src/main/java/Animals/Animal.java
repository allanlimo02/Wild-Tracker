package Animals;

public class Animal {

    private int id;
    private String name;
    private String health;
    private String age;
    private boolean endangered;

    public Animal( String name, String health, String age, boolean endangered) {

        this.name = name;
        this.health = health;
        this.age = age;
        this.endangered = endangered;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHealth() { return health; }

    public void setHealth(String health) {this.health = health; }

    public String getAge() { return age; }

    public void setAge(String age) { this.age = age;  }

    public boolean isEndangered() {
        return endangered;
    }

    public void setEndangered(boolean endangered) {
        this.endangered = endangered;
    }
}
