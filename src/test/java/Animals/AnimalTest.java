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
        Animal animal = new Animal("Lion","Health","old",true);
        assertEquals("Health",animal.getHealth());
    }
    @Test
    void getAge() {
        Animal animal = new Animal("old","Health","old",true);
        assertEquals("old",animal.getAge());
    }
}