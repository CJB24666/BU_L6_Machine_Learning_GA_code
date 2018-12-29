public class FitnessCalc {

    static public final int[][] table = new int[][]{
   //building 1  2   3   4   5   6   7   8     use\/
            {35, 30, 18, 20, 24, 24, 18, 33}, // 1
            {10, 14, 22, 34, 26, 19, 22, 29}, // 2
            {12, 16, 21, 27, 35, 25, 30, 22}, // 3
            { 7, 25, 29, 26, 13, 24, 25, 25}, // 4
            {12, 25, 27, 26, 15, 24, 27, 25}, // 5
            {24, 29, 37, 34, 37, 20, 21, 25}, // 6
            {15, 28, 37, 28, 27, 23, 19, 33}  // 7
    };

    //transposed the table to be more suitable for my code, the table is from the assignment brief.
//     static public final int[][] table = new int[][]{
//      //Use  1   2   3   4   5   6   7
//            {35, 10, 12, 07, 12, 24, 15}, //B1
//            {30, 14, 16, 25, 25, 29, 28}, //B2
//            {18, 22, 21, 29, 27, 37, 37}, //B3
//            {20, 34, 27, 26, 26, 34, 28}, //B4
//            {24, 26, 35, 13, 15, 37, 27}, //B5
//            {24, 19, 25, 24, 24, 20, 23}, //B6
//            {18, 22, 30, 25, 27, 21, 19}, //B7
//            {33, 29, 22, 25, 25, 25, 33}  //B8
//    };


     static int getFitness (Individual individual){
        int fitness = 0;

        // Calculating the actual fitness here
        int[] genes = individual.getGenes();
        for (int i = 0; i < genes.length; i++) {
                fitness += table[i][genes[i] -1];
        }

        // Set the objects fitness
        individual.setFitness(fitness);
        return fitness;
    }
}