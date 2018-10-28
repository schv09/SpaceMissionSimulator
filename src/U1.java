/**
 * This class represents a specific type of rocket called U1.
 */
public class U1 extends Rocket {

    /**
     * This constructor initializes the fields of this U1 rocket in order to meet its standard specifications.
     */
    public U1() {
        super();

        cost = 100000000;
        rocketWeight = 10;
        currentTotalWeight = rocketWeight;
        cargoLimit = 8;
        maxTotalWeight = currentTotalWeight + cargoLimit;
    }

    /**
     * This method returns true if this U1 rocket did not explode when launching. It calculates the chance of
     * explosion and simulates such an event by generating a random number. Since this method
     * will be called for a list of rockets, we ask for the index of this rocket in the list, and also
     * for the time variable in order to know how many times it's being launched. This will be displayed
     * as to give more information on the status of the rockets' launches.
     * @return true if the rocket launched successfully.
     */
    @Override
    public boolean launch() {
        double chanceOfLaunchExplosion = 0.05 * (cargoCarried / cargoLimit);

        // Testing if rocket explodes at launch by simulating an event where the probability of success
        // is equal to the probability of there being an explosion at launch.
        double random = Math.random();

        if (random < chanceOfLaunchExplosion) {
            // If the condition is met, the rocket has exploded and we will return false because it did not
            // launch successfully.
            System.out.println("U1 rocket exploded at launch.");
            return false;
        } else {
            System.out.println("Success! U1 rocket did not explode at launch.");
            return true;
        }
    }

    /**
     * This method returns true if this U1 rocket did not crash when landing. It calculates the chance of
     * crashing and simulates such an event by generating a random number. Since this method
     * will be called for a list of rockets, we ask for the index of this rocket in the list, and also
     * for the time variable in order to know how many times it's being launched. This will be displayed
     * as to give more information on the status of the rockets' launches.
     * @return true if the rocket launched successfully.
     */
    @Override
    public boolean land() {
        double chanceOfLandingCrash = 0.01 * (cargoCarried / cargoLimit);

        // Testing if rocket crashes at landing by simulating an event where the probability of success
        // is equal to the probability of there being a crash at landing.
        double random = Math.random();

        if (random < chanceOfLandingCrash) {
            // If the condition is met, the rocket has crashed and we will return false because it did not
            // land successfully.
            System.out.println("U1 rocket crashed when landing.");
            return false;
        } else {
            System.out.println("Success! U1 rocket did not crash when landing.\n");
            return true;
        }
    }
}
