
public class Algorithm {

    /* GA parameters */
    private static final double uniformRate = 0.55;
    private static final double mutationRate = 0.015;
    private static final int tournamentSize = 5;

     /* Public methods */

    // Evolve a population
    public static Population evolvePopulation(Population pop) {
        Population newPopulation = new Population(pop.size(), false);

            // Keep our best individual
            newPopulation.saveIndividual(0, pop.getFittest());

            // Crossover population
            int elitismOffset = 1;

            // Loop over the population size and create new individuals with
            // crossover
            for (int i = elitismOffset; i < pop.size(); i++) {
                Individual indiv1 = tournamentSelection(pop);
                Individual indiv2 = tournamentSelection(pop);
                Individual newIndiv = crossover(indiv1, indiv2);
                newPopulation.saveIndividual(i, newIndiv);
            }

            // Mutate population
            for (int i = elitismOffset; i < newPopulation.size(); i++) {
                mutate(newPopulation.getIndividual(i));
            }

        return newPopulation;
    }

    // Crossover individuals
    private static Individual crossover(Individual indiv1, Individual indiv2) {
        Individual newSol = new Individual();
        Individual otherIndividual = new Individual();
        boolean containsDuplicate =  false;

        // Get the best Individual and copy to the new solution
        if  (indiv1.getObjFitness() > indiv2.getObjFitness()){
            for (int i = 0; i < indiv1.size(); i++) {
                 newSol.setGene(i, indiv1.getGene(i));
            }
            otherIndividual = indiv2; // This is the other individual
        }else{
            for (int i = 0; i < indiv2.size(); i++) {
                newSol.setGene(i, indiv2.getGene(i));
            }
            otherIndividual = indiv1; // This is the other individual
        }

        for (int i = 0; i < indiv1.size(); i++) {
            // Crossover
            if (Math.random() <= uniformRate) {

                // newSol already contains everything from the best individual
                // so only need to update with unique values from the other individual
                int indivGene = otherIndividual.getGene(i);
                for (int index = 0; index < otherIndividual.size(); index++) {
                    if (indivGene == newSol.getGene(index)){
                        //Can't add this random gene because it's not unique
                        containsDuplicate = true;
                    };
                }
                if (!containsDuplicate){
                    //This random gene is unique, update the new solution
                    newSol.setGene(i,indivGene);
                    //Reset the duplicate indicator for the this gene
                    containsDuplicate = true;
                }
            }
        }
        return newSol;
    }

    // Mutate an individual
    private static void mutate(Individual indiv) {
        boolean containsDuplicate =  false;

        // Loop through genes
        for (int i = 0; i < indiv.size(); i++) {
            if (Math.random() <= mutationRate) {

                // Create random gene between 1 - 8
                byte gene = (byte) Math.round(Math.random() * 7 + 1);

                for (int index = 0; index < indiv.size(); index++) {
                    if (gene == indiv.getGene(index)) {
                        //Can't add this random gene because it's not unique
                        containsDuplicate = true;
                    }
                }
                if (!containsDuplicate){
                    //This random gene is unique, update the individual
                    indiv.setGene(i, gene);
                    //Reset the duplicate indicator for the this gene
                    containsDuplicate = true;
                }
            }
        }
    }

    //  Select individuals for crossover
    private static Individual tournamentSelection (Population pop){
            // Create a tournament population
            Population tournament = new Population(tournamentSize, false);

            // For each place in the tournament get a random individual
            for (int i = 0; i < tournamentSize; i++) {
                //int randomId = (int) (Math.random() * pop.size());
                int randomId = (int) (Math.random() * tournamentSize);
                tournament.saveIndividual(i, pop.getIndividual(randomId));
            }

            // Get the fittest
            Individual fittest = tournament.getFittest();

            return fittest;
    }
}

