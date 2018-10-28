/**
 * This class represents the result of a simulation of launching and landing a fleet of rockets.
 */
public class Result {
    /** The total number of rockets that were required*/
    private int totalRockets;

    /** The total cost for all the rockets that were needed for this simulation, formatted as currency*/
    private int totalCost;

    /**
     * Constructor to create a new result of a simulation.
     * @param totalRockets the total of rockets for this result.
     * @param totalCost the total cost for this result.
     */
    public Result (int totalRockets, int totalCost) {
        this.totalRockets = totalRockets;
        this.totalCost = totalCost;
    }

    /**
     * This method gets the total rockets for this result.
     * @return the total rockets for this result.
     */
    public int getTotalRockets() {
        return totalRockets;
    }

    /**
     * This method gets the total cost for this result.
     * @return the total cost for this result.
     */
    public int getTotalCost() {
        return totalCost;
    }
}
