import Interfaces.IReviewed;
import Interfaces.ISecurity;
import attractions.Attraction;
import people.Visitor;

import java.util.ArrayList;
import java.util.HashMap;

public class ThemePark {

  private String name;
  private ArrayList<IReviewed> allAttractions;

  public ThemePark(String name){
    this.name = name;
    this.allAttractions = new ArrayList<IReviewed>();
  }

  public String getName() {
    return name;
  }

  public ArrayList<IReviewed> getAllAttractions() {
    return allAttractions;
  }

  public void addAttraction(IReviewed attraction){ allAttractions.add(attraction); }

  public void visit(Visitor visitor, Attraction attraction){
    attraction.incrementVisitCount();
    visitor.visitAttraction(attraction);
  }

  public HashMap<String, Integer> getReviews() {
    HashMap<String, Integer> reviews = new HashMap<String, Integer>();
    for (IReviewed attraction : allAttractions){
      if (attraction instanceof Attraction){
        reviews.put(attraction.getName(), attraction.getRating());
      } else {
        reviews.put(attraction.getName(), null);
      }
    }
    return reviews;
  }

  public ArrayList<IReviewed> getAllAllowedFor(Visitor visitor){
    ArrayList<IReviewed> allowed = new ArrayList<IReviewed>();
    for (IReviewed attraction : allAttractions){
      if (attraction instanceof ISecurity){
        if (((ISecurity) attraction).isAllowedTo(visitor)){
          allowed.add(attraction);
        }
      } else {
        allowed.add(attraction);
      }
    }
    return allowed;
  }
}
