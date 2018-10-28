import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class represents a simulation of preparing and launching all needed rockets for the space mission.
 */
public class Simulation {

    /**
     * This method creates an array list of items from a file containing a list of items.
     * @param fileName the name of the file containing the list of items.
     * @return the list of items.
     */
    public ArrayList<Item> loadItems(String fileName) {

        String phaseNumber = fileName.substring(6,7);

        System.out.println("Preparing items for phase " + phaseNumber + "...");
        System.out.println();

        ArrayList<Item> itemsList = new ArrayList<>();

        File file = new File(fileName);

        try {
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                String currentItemLine = fileScanner.nextLine();

                String [] itemParts = currentItemLine.split("=");

                String itemName = itemParts[0];

                // Divide weight given in kg in items list by 1000, since 1 tonne = 1,000 kg
                int itemWeight = (Integer.parseInt(itemParts[1])) / 1000;

                Item item = new Item(itemName, itemWeight);
                itemsList.add(item);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error opening file. File not found.");
        }
        return itemsList;
    }

    /**
     * This method creates an array list of loaded U1 rockets, by going through a list of items to load.
     * @param items the list of items to be loaded.
     * @return the list of loaded U1 rockets.
     */
    public ArrayList<Rocket> loadU1(ArrayList<Item> items) {
        ArrayList<Rocket> U1RocketsList = new ArrayList<>();

        U1 U1Rocket = new U1();

        for (Item item: items) {
            if (U1Rocket.canCarry(item)) {
                U1Rocket.carry(item);
            } else {
                U1RocketsList.add(U1Rocket);
                U1Rocket = new U1();
            }
        }
        return U1RocketsList;
    }

    /**
     * This method creates an array list of loaded U2 rockets, by going through a list of items to load.
     * @param items the list of items to be loaded.
     * @return the list of loaded U2 rockets.
     */
    public ArrayList<Rocket> loadU2(ArrayList<Item> items) {
        ArrayList<Rocket> U2RocketsList = new ArrayList<>();

        U2 U2Rocket = new U2();

        for (Item item: items) {
            if (U2Rocket.canCarry(item)) {
                U2Rocket.carry(item);
            } else {
                U2RocketsList.add(U2Rocket);
                U2Rocket = new U2();
            }
        }
        return U2RocketsList;
    }

    /**
     * This method takes in a list of loaded rockets and simulates launching each one of them and landing them in Mars.
     * If a rocket explodes when launching or crashes when landing, it will have to be relaunched. It keeps track of
     * the total count of rockets needed and calculates the total corresponding cost.
     * @param loadedRockets the list of rockets to send to Mars.
     * @return the result for this simulation
     */
    public Result runSimulation(ArrayList<Rocket> loadedRockets) {

        // The count of the total rockets used in this simulation
        int totalRocketCount = 0;

        for (int i = 0; i < loadedRockets.size(); i++) {
            // Each time a rocket is launched for the first time, the total count is incremented by 1 in advance
            totalRocketCount++;

            Rocket currentRocket = loadedRockets.get(i);

            // This variable counts how many times the current rocket has been launched
            int currentRocketCount = 1;

            // The number of this rocket within the list of rockets, starting from 1
            int currentRocketNumber = i + 1;

            System.out.println("Simulating launch and landing for rocket No. " + currentRocketNumber + " for the " +
                    getCurrentRocketCountString(currentRocketCount) + " time...");

            // If this rocket's launch fails or its landing fails, it must be relaunched and relanded
            // Therefore the total count of rockets will increment by 1 and the local count of launches for
            // this specific rocket will also increment by 1
            while (!currentRocket.launch() || !currentRocket.land()) {
                // The counting variables are incremented in advance, before relaunching and relanding, since we already
                // know that these future actions imply the use of a new rocket
                totalRocketCount++;
                currentRocketCount++;
                System.out.println("\nSimulating launch and landing for rocket No. " + currentRocketNumber + " for the " +
                        getCurrentRocketCountString(currentRocketCount) + " time...");
            }
        }

        int totalCost = totalRocketCount * loadedRockets.get(0).getCost();

        return new Result(totalRocketCount, totalCost);
    }

    /**
     * This method takes in the launch count for this specific rocket and returns a proper string representing it
     * @param currentRocketCount the number that represents how many times the current rocket has been launched
     * @return the string representing the launch count
     */
    private String getCurrentRocketCountString (int currentRocketCount) {
        String currentRocketCountString;
        switch (currentRocketCount) {
            case 1:  currentRocketCountString = "1st";
                break;
            case 2:  currentRocketCountString = "2nd";
                break;
            case 3:  currentRocketCountString = "3rd";
                break;
            default: currentRocketCountString = currentRocketCount + "th";
                break;
        }
        return currentRocketCountString;
    }
}
