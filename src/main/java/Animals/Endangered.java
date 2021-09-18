package Animals;

public class Endangered extends Animal{

    private String age;
    private String health;


    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getHealth() {
        return health;
    }
    public void setHealth(String health) {
        this.health = health;
    }
    public Endangered(String age, String health,String name) {
        super(name);
        this.age = age;
        this.health = health;
    }
}
