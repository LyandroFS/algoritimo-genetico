
public class CriaCromossomo {
	private final int TAMANHO_DO_CROMOSSOMO = 2;
	private Gene[] genes;
	
    public CriaCromossomo() {
        genes = new Gene[TAMANHO_DO_CROMOSSOMO];
        initCromossomo();
    }
    private void initCromossomo() {
        for (int i = 0; i < TAMANHO_DO_CROMOSSOMO; i++) {
            genes[i] = new Gene();
        }
    }
    public Gene[] getGenes() {
        return genes;
    }
    public int getTAMANHO_DO_CROMOSSOMO() {
        return TAMANHO_DO_CROMOSSOMO;
    }
    
    public void mostraCromossomo() {
        for (int i = 0; i < TAMANHO_DO_CROMOSSOMO; i++) {
            System.out.println(genes[i].getX()+", "+genes[i].getY());
        }
    }
}