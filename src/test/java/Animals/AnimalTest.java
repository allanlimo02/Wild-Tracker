package Animals;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class AnimalTest {


    @Test
    public void testTestGetName() {
        Animal animal=new Animal("Monkey","healthy","Old",true);
        Assert.assertEquals("Monkey", animal.getName());
    }

}