package uk.ac.rgu.cm2115;

// Abstract Hire Price
public abstract class Vehicle {
    private int hirePrice;

    public int getHirePrice() {
        return this.hirePrice;

    }

    public Vehicle(int hirePrice) {
        this.hirePrice = hirePrice;
    }
}
