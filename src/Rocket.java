/**
 * This class represents a rocket that will be loaded with items and launched to space.
 */
public class Rocket implements SpaceShip {

    /** The cost of this rocket*/
    int cost;

    /** The weight of this rocket given in tons*/
    int rocketWeight;

    /** The current total weight of this rocket (rocket weight plus cargo carried, given in tons).*/
    int currentTotalWeight;

    /** The weight limit of this rocket's carried cargo given in tons.*/
    int cargoLimit;

    /** The weight of this rocket's carried cargo given in tons.*/
    double cargoCarried = 0;

    /** The total weight limit of this rocket, including its own weight, given in tons.*/
    int maxTotalWeight;

    /**
     * This method returns true if this rocket did not explode when launching. It returns true for now and will be
     * correctly implemented by subclasses of this class.
     * @return true if the space ship launched successfully.
     */
    @Override
    public boolean launch() {
        return true;
    }

    /**
     * This method returns true if this rocket did not crash when landing. It returns true for now and will be
     * correctly implemented by subclasses of this class.
     * @return true if the space ship launched successfully.
     */
    @Override
    public boolean land() {
        return true;
    }

    /**
     * This method evaluates if a space ship can carry a given item.
     * @param item the item to evaluate.
     * @return true if the item can be carried.
     */
    @Override
    public boolean canCarry(Item item) {
        return  (currentTotalWeight + item.getItemWeight()) <= maxTotalWeight;
    }

    /**
     * This method adds the item to the space ship's cargo.
     * @param item the item to add to the cargo.
     */
    @Override
    public void carry(Item item) {
        currentTotalWeight += item.getItemWeight();
        cargoCarried = currentTotalWeight - rocketWeight;
    }

    @Override
    public String toString() {
        return "ROCKET SPECS.\ncost: " + cost + ", Weight: " + rocketWeight + ", Cargo limit: "
                + cargoLimit + ", Max total weight: " + maxTotalWeight + ", Cargo carried: " + cargoCarried + "\n";
    }

    /**
     * This method gets the cost of this rocket.
     * @return the cost of this rocket.
     */
    public int getCost() {
        return cost;
    }
}