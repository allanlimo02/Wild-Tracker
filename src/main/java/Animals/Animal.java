package Animals;

public class Animal {

    private int id;
    private String name;
    private String health;
    private String age;
    private String endangered;

    public Animal(String name, String health, String age, String endangered) {
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

    public String getEndangered() { return endangered;  }

    public void setEndangered(String endangered) { this.endangered = endangered; }
}
