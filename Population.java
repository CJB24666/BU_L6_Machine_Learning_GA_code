import java.util.Arrays;

public class Population {

    // creating x Individual
    Individual[] individuals;

    // Constructor

    public Population(int pop_size, boolean initialise) {
        individuals = new Individual[pop_size];

        // Initialise population
        if (initialise) {
            // Loop and create more individuals
            for (int i = 0; i < pop_size; i++) {
                Individual newIndividual = new Individual();
                newIndividual.generateIndividual();
                individuals[i] = newIndividual;
            }
        }
    }

    public Individual getIndividual(int index) {
        return individuals[index];
    }

    public Individual[] getIndividuals() {
        return individuals;
    }

    public Individual getFittest() {
        Individual fittest = individuals[0];

        int test = size();
        // Loop through individuals to find fittest
        for (int i = 0; i < size(); i++) {
            if (fittest.getFitness() <= getIndividual(i).getFitness()) {
                fittest = getIndividual(i);
             }
        }
        return fittest;

    }
    public int size() {
        return individuals.length;
    }

    public void saveIndividual(int index, Individual indiv) {
        individuals[index] = indiv;
    }
}


