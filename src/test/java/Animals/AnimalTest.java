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
    @Test
    public void testSetName_Working_true() {
        Animal animal=new Animal("Monkey","healthy","Old",true);
        Assert.assertEquals("Monkey", animal.getName());
    }
    @Test
    public void testSetName_Workingwell_okay() {
        Animal testRest = new Animal( "Lion","okay","old",true);
        testRest.setName("new name");
        Assert.assertEquals("new name", testRest.getName());
    }

}