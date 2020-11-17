package attractions;

import Interfaces.ITicketed;
import people.Visitor;

public class Dodgems extends Attraction implements ITicketed {

    private double price;

    public Dodgems(String name, int rating, double price) {
        super(name, rating);
        this.price = price;
    }

    public double defaultPrice() {
        return price;
    }

    public double priceFor(Visitor visitor) {
        return visitor.getAge() <= 12 ? defaultPrice()*0.5 : defaultPrice();
    }
}
