package attractions;

import Interfaces.ISecurity;
import Interfaces.ITicketed;
import people.Visitor;

public class RollerCoaster  extends Attraction implements ISecurity, ITicketed {

    private double price;

    public RollerCoaster(String name, int rating, double price) {
        super(name, rating);
        this.price = price;
    }

    public boolean isAllowedTo(Visitor visitor) {
        if (visitor.getAge() >= 12 && visitor.getHeight() >= 145.0){
            return true;
        } else {
            return false;
        }
    }

    public double defaultPrice() {
        return price;
    }

    public double priceFor(Visitor visitor) {
        return visitor.getHeight() >= 200 ? defaultPrice()*2 : defaultPrice();
    }
}
