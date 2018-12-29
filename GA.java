import java.util.Arrays;

public class GA {

    static final int POP_SIZE = 200;

    public static void main(String[] args) {

        // Evolve our population until we reach an optimum solution
        int generationCount = 0;

        // Store fitness to display on the console
        int fitness = 0;

        // Creata a new population
        Population population = new Population(POP_SIZE,true);

        // Create a new fitness calculator
        FitnessCalc fitnessCalc = new FitnessCalc();

        //Create an individual from the population
        Individual[] individuals = population.getIndividuals();

        //Loop through all the individuals of the population
        for (Individual indiv :
                individuals) {

            //Calculate the individuals fitness
            //fitness = fitnessCalc.getFitness(indiv);

            //System.out.println("Fitness for: " + Arrays.toString(indiv.getGenes()) + " is " + fitness);

            //Update the number of generations performed
            generationCount++;

            // Evolve a population
            population = Algorithm.evolvePopulation(population);

        }
        // Population evolved, display results
        System.out.println();
        System.out.println("*********************************");
        //System.out.println("Generations: "+ generationCount);
        System.out.println("Best Fitness: " + population.getIndividual(0).getObjFitness());
        System.out.println("Best Fitness is: " + Arrays.toString(population.getIndividual(0).getGenes()));
        System.out.println("*********************************");
    }
}

