/**
 * This class represents an item which will be carried by a rocket.
 */
public class Item {
    /** The name of this item*/
    private String name;

    /** The weight of this item in tons*/
    private int weight;

    /**
     * Constructor to create a new item.
     * @param name the name of this item.
     * @param weight the item of this item.
     */
    public Item (String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    /**
     * This method gets the name of this item.
     * @return the name of this item.
     */
    public String getItemName() {
        return name;
    }

    /**
     * This method gets the weight of this item.
     * @return the weight of this item.
     */
    public int getItemWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return name + " " + weight;
    }
}
