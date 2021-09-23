package Animals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @Test
    void getName() {
        Animal animal = new Animal("Lion","Health","old",true);
        assertEquals("Lion",animal.getName());
    }

    @Test
    void setName() {
        Animal animal = new Animal("Lion","Health","old",true);
        assertEquals("Lion",animal.getName());
    }

    @Test
    void getHealth() {
    }

    @Test
    void setHealth() {
    }

    @Test
    void getAge() {
    }

    @Test
    void setAge() {
    }
}