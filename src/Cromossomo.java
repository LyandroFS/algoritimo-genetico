
public class Cromossomo {
	
	Gene[] genes = new Gene[2];
	double fitness;
	
	public Cromossomo(Gene g1, Gene g2) {
		genes[0] = g1;
		genes[1] = g2;
	}

	public Gene[] getGenes() {
		return genes;
	}

	public void setGenes(Gene[] genes) {
		this.genes = genes;
	}

	public double getFitness() {
		return fitness;
	}

	public void setFitness(double fitness) {
		this.fitness = fitness;
	}		
}