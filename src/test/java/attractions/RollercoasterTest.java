package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor visitor1;
    Visitor visitor2;
    Visitor visitor3;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10, 8.4);
        visitor1 = new Visitor(14, 140.0, 12.0);
        visitor2 = new Visitor(19, 210.0, 12.0);
        visitor3 = new Visitor(11, 150.0, 12.0);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void canGoIf12And145(){ assertEquals(true, rollerCoaster.isAllowedTo(visitor2)); }

    @Test
    public void cantGoToShort(){ assertEquals(false, rollerCoaster.isAllowedTo(visitor1)); }

    @Test
    public void cantGoToYoung(){ assertEquals(false, rollerCoaster.isAllowedTo(visitor3)); }

    @Test
    public void normalPriceIfShort(){ assertEquals(8.4, rollerCoaster.priceFor(visitor1), 0.01); }

    @Test
    public void doubleIfTall(){ assertEquals(16.8, rollerCoaster.priceFor(visitor2), 0.01); }
}
