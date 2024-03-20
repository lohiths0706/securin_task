public class Main {

    public static void main(String[] args) {
        int[] die = {1, 2, 3, 4, 5, 6};
        int[][] combinations = new int[6][6];
        int totalCombinations = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                combinations[i][j] = die[i] + die[j];
                totalCombinations++;
            }
        }
        System.out.println("totalCombinations:"+totalCombinations);
        System.out.println();
        System.out.println("Distribution of all possible combinations:");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(combinations[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\nProbability of each sum:");
        for (int sum = 2; sum <= 12; sum++) {
            int count = 0;
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    if (combinations[i][j] == sum) {
                        count++;
                    }
                }
            }
            double probability = (double) count / totalCombinations;
            System.out.println("P(Sum = " + sum + ") = " + count + "/" + totalCombinations + " = " + probability);
        }
    }
}
