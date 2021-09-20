package Sightings;

import junit.framework.TestCase;

public class SightingTest extends TestCase {

    public void testGetRanger() {
        Sighting sights = new Sighting("River","Allan","22");
        assertEquals("Allan",sights.getRanger());
    }

    public void testGetAnimalId() {
        Sighting sights = new Sighting("River","Allan","22");
        assertEquals(22,sights.getAnimal_id());

    }

    public void testGetLocation() {
        Sighting sights = new Sighting("River","Allan","22");
        assertEquals("River",sights.getLocation());
    }


}