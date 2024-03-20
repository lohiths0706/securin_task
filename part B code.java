import java.util.*;
public class Main {

    public static void main(String[] args) {
        int[] dieA = {1, 2, 3, 4, 5, 6};
        int[] dieB = {1, 2, 3, 4, 5, 6};

        int[] newDieA = undoom_dice(dieA, dieB);
        if (newDieA != null) {
            int[] newDieB = Arrays.copyOf(newDieA, newDieA.length); 

            System.out.println("New Die A: " + Arrays.toString(newDieA));
            System.out.println("New Die B: " + Arrays.toString(newDieB));
        } else {
            System.out.println("Error: Failed to reattach spots to the dice.");
        }
    }

   public static int[] undoom_dice(int[] dieA, int[] dieB) {
    int[] newDieA = new int[6];

   
    for (int i = 0; i < 6; i++) {
        int spots = dieA[i];
        if (spots <= 4) {
            newDieA[i] = spots;
        } else {
            boolean spotsAllocated = false;
            for (int j = 0; j < 6; j++) {
                if (dieB[j] >= spots - 4) {
                    newDieA[i] = spots;
                    dieB[j] -= (spots - 4); 
                    spotsAllocated = true;
                    break;
                }
            }
            if (!spotsAllocated) {
                
                System.out.println("Error: Not enough spots on Die B to satisfy Die A requirements.");
                return null;
            }
        }
    }

    double[] newProbabilities = new double[11];
    for (int i = 0; i < 6; i++) {
        for (int j = 0; j < 6; j++) {
            int sum = newDieA[i] + dieB[j] - 2;
            if (sum >= 0) {
                newProbabilities[sum] += 1;
            }
        }
    }
    for (int i = 0; i < newProbabilities.length; i++) {
        newProbabilities[i] /= 36; 
    }

    
    System.out.println("New Probabilities:");
    for (int i = 0; i < newProbabilities.length; i++) {
        System.out.println("P(Sum = " + (i + 2) + ") = " + newProbabilities[i]);
    }

    System.out.println("New Die A: " + Arrays.toString(newDieA));
    System.out.println("New Die B: " + Arrays.toString(dieB));

    return newDieA;
}

}