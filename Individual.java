import java.util.*;

public class Individual {
    private int[] genes = new int[7];

    private int fitness = 0;

    public void generateIndividual() {

        List<Integer> asList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            asList.add(i + 1);
        }
        // shuffling the array to make it in a random order.
        Collections.shuffle(asList);

        // Put first 7 of shuffled list in genes array
        for (int i = 0; i < genes.length; i++) {
            genes[i] = asList.get(i);
        }
    }

    public int[] getGenes() {
        return genes;
    }

    public int getGene(int index) {
        return genes[index];
    }

    public void setGene(int index, int value) {
        genes[index] = value;
        fitness = 0;
    }

    public int getFitness() {
        if (fitness == 0) {
            fitness = FitnessCalc.getFitness(this);
        }
        return fitness;
    }

    public void setFitness(int fitn) {
        fitness = fitn;
    }

    public int size() {
        return genes.length;
    }

    public int getObjFitness() {
        return this.fitness;
    }
}
