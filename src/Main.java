import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Main {
    public static void main (String[] args) {

        Simulation simulation = new Simulation();

        System.out.println("Starting space mission simulation:");
        System.out.println();

        // Preparing phase 1 items
        ArrayList <Item> phase1Items = simulation.loadItems("phase-1.txt");

        // Preparing phase 2 items
        ArrayList <Item> phase2Items = simulation.loadItems("phase-2.txt");

        // U1 PHASE 1
        // Loading phase 1 items on U1 rockets
        System.out.println("--- Starting U1 rocket simulation for phase 1 ---");
        System.out.println();

        System.out.println("Loading phase 1 items on U1 rockets...");
        System.out.println();

        ArrayList<Rocket> loadedU1RocketsPhase1 = simulation.loadU1(phase1Items);

        System.out.println("Theoretical number of U1 rockets needed for phase 1: " + loadedU1RocketsPhase1.size());
        System.out.println();

        // Phase 1 launching/landing simulation for U1 rockets
        System.out.println("Simulating launch and landing of U1 rockets fleet for phase 1...");
        System.out.println();

        Result U1Phase1Result = simulation.runSimulation(loadedU1RocketsPhase1);
        int U1Phase1Rockets = U1Phase1Result.getTotalRockets();
        int U1Phase1Cost = U1Phase1Result.getTotalCost();

        System.out.println("Actual number of U1 rockets required for phase 1: " + U1Phase1Rockets);
        System.out.println("Total cost: " + formatCost(U1Phase1Cost));
        System.out.println();

        // U1 PHASE 2
        // Loading phase 2 items on U1 rockets
        System.out.println("--- Starting U1 rocket simulation for phase 2 ---");
        System.out.println();

        System.out.println("Loading phase 2 items on U1 rockets...");
        System.out.println();

        ArrayList<Rocket> loadedU1RocketsPhase2 = simulation.loadU1(phase2Items);

        System.out.println("Theoretical number of U1 rockets needed for phase 2: " + loadedU1RocketsPhase2.size());
        System.out.println();

        // Phase 2 launching/landing simulation for U1 rockets
        System.out.println("Simulating launch and landing of U1 rockets fleet for phase 2...");
        System.out.println();

        Result U1Phase2Result = simulation.runSimulation(loadedU1RocketsPhase2);
        int U1Phase2Rockets = U1Phase2Result.getTotalRockets();
        int U1Phase2Cost = U1Phase2Result.getTotalCost();

        System.out.println("Actual number of U1 rockets required for phase 2: " + U1Phase2Rockets);
        System.out.println("Total cost: " + formatCost(U1Phase2Cost));

        System.out.println("\n*** U1 rocket simulation complete ***\n");

        int totalU1Rockets = U1Phase1Rockets + U1Phase2Rockets;
        int totalU1Cost = U1Phase1Cost + U1Phase2Cost;

        System.out.println("Actual number of U1 rockets required for both phases: " + totalU1Rockets);
        System.out.println("Total cost for U1 rockets: " + formatCost(totalU1Cost));
        System.out.println();

        // U2 PHASE 1
        // Loading phase 1 items on U2 rockets
        System.out.println("--- Starting U2 rocket simulation for phase 1 ---");
        System.out.println();

        System.out.println("Loading phase 1 items on U2 rockets...");
        System.out.println();

        ArrayList<Rocket> loadedU2RocketsPhase1 = simulation.loadU2(phase1Items);

        System.out.println("Theoretical number of U2 rockets needed for phase 1: " + loadedU2RocketsPhase1.size());
        System.out.println();

        // Phase 1 launching/landing simulation for U2 rockets
        System.out.println("Simulating launch and landing of U2 rockets fleet for phase 1...");
        System.out.println();

        Result U2Phase1Result = simulation.runSimulation(loadedU2RocketsPhase1);
        int U2Phase1Rockets = U2Phase1Result.getTotalRockets();
        int U2Phase1Cost = U2Phase1Result.getTotalCost();

        System.out.println("Actual number of U2 rockets required for phase 1: " + U2Phase1Rockets);
        System.out.println("Total cost: " + formatCost(U2Phase1Cost));
        System.out.println();

        // U2 PHASE 2
        // Loading phase 2 items on U2 rockets
        System.out.println("--- Starting U2 rocket simulation for phase 2 ---");
        System.out.println();

        System.out.println("Loading phase 2 items on U2 rockets...");
        System.out.println();

        ArrayList<Rocket> loadedU2RocketsPhase2 = simulation.loadU2(phase2Items);

        System.out.println("Theoretical number of U1 rockets needed for phase 2: " + loadedU1RocketsPhase2.size());
        System.out.println();

        // Phase 2 launching/landing simulation for U2 rockets
        System.out.println("Simulating launch and landing of U2 rockets fleet for phase 2...");
        System.out.println();

        Result U2Phase2Result = simulation.runSimulation(loadedU2RocketsPhase2);
        int U2Phase2Rockets = U2Phase2Result.getTotalRockets();
        int U2Phase2Cost = U2Phase2Result.getTotalCost();

        System.out.println("Actual number of U2 rockets required for phase 2: " + U2Phase2Rockets);
        System.out.println("Total cost: " + formatCost(U2Phase2Cost));

        System.out.println("\n*** U2 rocket simulation complete ***\n");

        int totalU2Rockets = U2Phase1Rockets + U2Phase2Rockets;
        int totalU2Cost = U2Phase1Cost + U2Phase2Cost;

        System.out.println("Actual number of U2 rockets required for both phases: " + totalU2Rockets);
        System.out.println("Total cost for U2 rockets: " + formatCost(totalU2Cost));
    }

    /**
     * This method takes in a cost and returns a proper string representing it as currency
     * @param cost the number that represents how many times the current rocket has been launched
     * @return the string representing the cost as currency
     */
    private static String formatCost(int cost) {
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
        String currency = format.format(cost);
        return currency;
    }
}
