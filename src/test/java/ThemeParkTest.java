import attractions.RollerCoaster;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.ParkingSpot;
import stalls.TobaccoStall;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {

  private ThemePark themePark;
  private RollerCoaster rollerCoaster;
  private TobaccoStall tobaccoStall;
  private Visitor visitor;
  private Visitor visitor2;

  @Before
  public void before(){
    themePark = new ThemePark("FunLand");
    rollerCoaster = new RollerCoaster("BigCheese", 9, 7.50);
    tobaccoStall = new TobaccoStall("WackyBacky", "James", ParkingSpot.A1);
    visitor = new Visitor(24, 171.0, 25.0);
    visitor2 = new Visitor(17, 171.0, 25.0);
  }

  @Test
  public void hasAttractions(){ assertEquals(0, themePark.getAllAttractions().size()); }

  @Test
  public void canAddStallsAndAttractions() {
    themePark.addAttraction(rollerCoaster);
    themePark.addAttraction(tobaccoStall);
    assertEquals(2, themePark.getAllAttractions().size());
  }

  @Test
  public void visitorVisitsAttraction(){
    themePark.addAttraction(rollerCoaster);
    themePark.visit(visitor, rollerCoaster);
    assertEquals(1, rollerCoaster.getVisitCount());
    assertEquals(1, visitor.getVisitedAttractions().size());
  }

  @Test
  public void canGetReviews(){
    themePark.addAttraction(rollerCoaster);
    themePark.addAttraction(tobaccoStall);
    HashMap<String, Integer> reviews = themePark.getReviews();
    assertEquals(2, reviews.size());
    assertEquals(null, reviews.get("WackyBacky"));
    assertEquals(9, reviews.get("BigCheese").intValue());
  }

  @Test
  public void isAllowedOnBothAttractions(){
    themePark.addAttraction(rollerCoaster);
    themePark.addAttraction(tobaccoStall);
    assertEquals(2, themePark.getAllAllowedFor(visitor).size());
  }

  @Test
  public void onlyAllowedOnOne(){
    themePark.addAttraction(rollerCoaster);
    themePark.addAttraction(tobaccoStall);
    assertEquals(1, themePark.getAllAllowedFor(visitor2).size());
  }
}
