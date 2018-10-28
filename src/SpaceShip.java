/**
 * This interface exposes all methods that any space ship should implement.
 */
public interface SpaceShip {
    /**
     * This method returns true if the space ship did not explode when launching.
     * @return true if the space ship launched successfully.
     */
    boolean launch();

    /**
     * This method returns true if the space ship did not crash when landing.
     * @return true if the space ship landed successfully.
     */
    boolean land();

    /**
     * This method evaluates if a space ship can carry a given item.
     * @param item the item to evaluate.
     * @return true if the item can be carried.
     */
    boolean canCarry(Item item);

    /**
     * This method adds the item to the space ship's cargo.
     * @param item the item to add to the cargo.
     */
    void carry(Item item);
}
