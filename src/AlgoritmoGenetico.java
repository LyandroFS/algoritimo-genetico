import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AlgoritmoGenetico {
	
	private static double taxaCruzamento = 0.7d;
	private static int tamMaxPop = 100000;
	private static double taxaMutacao = 1d;
	private static double taxaSobrevivencia = 0.3d;
	private static int geracao = 0;
	
	public static void main(String[] args) {
		//Criar população inicial
		List<Cromossomo> p = criarPopulacaoInicial(1000);
		fitness(p);
		
		do {
			
			geracao++;
			System.out.println("Geração " + geracao + " | Menor  distância: " + p.get(0).getFitness());
			
			//Realizar as reproduções
			List<Cromossomo> filhos = cruzar(p);
			
			//Realizar as reproduções
			mutacao(filhos);
			
			p.addAll(filhos);
			
			//Avaliar cada indivíduo da população
			fitness(p);
			
			//Selecionar os indivíduos que formarão a próxima geração
			p = selecionar(p);
			
			//Verifica critério de parada
		} while (geracao < 100);
		
		System.out.println("A melhor solução encontrada foi: " + p.get(0).getFitness());
		
		/*CriaCromossomo criaCromossomo = new CriaCromossomo();
		criaCromossomo.mostraCromossomo();*/
	}
	
	private static List<Cromossomo> selecionar(List<Cromossomo> p) {
		//ordenar por fitness
		p.sort((Cromossomo c1, Cromossomo c2) -> {
			return Double.compare(c1.getFitness(), c2.getFitness());
		});
		
		// escolher baseado na taxa de sobrevivencia
		int escolha = (int) (p.size() * taxaSobrevivencia);
		
		return p.subList(0,escolha);
	}

	public static List<Cromossomo> criarPopulacaoInicial(int tamanho) {
		List<Cromossomo> cromossomos = new ArrayList<>();
		for(int x = 0; x <= tamanho; x++) {
			cromossomos.add(new Cromossomo(new Gene(), new Gene()));
		}
		return cromossomos;
	}
	
	public static List<Cromossomo> cruzar(List<Cromossomo> populacao) {
		
		List<Cromossomo> filhos = new ArrayList<Cromossomo>();
		
		Random r = new Random();
		int aux = 0;
		
		while ((populacao.size() <= tamMaxPop) && (aux < populacao.size())) {
			while (r.nextDouble() <= taxaCruzamento) {
				filhos.add(
						new Cromossomo(
						populacao.get(aux).getGenes()[0],
						populacao.get(new Random().nextInt(populacao.size())).getGenes()[1])
						);
			}
			aux++;
		}
		
		return filhos;
	}
	
	public static void mutacao(List<Cromossomo> populacao) {
		Random r = new Random();
		int aux = 0;
		
		while (aux < populacao.size()) {
			if(r.nextDouble() <= taxaMutacao) {
				Gene[] genes = populacao.get(aux).getGenes();
				genes[0] = new Gene();
				populacao.get(aux).setGenes(genes);
			}
			aux++;
		}
	}
	
	public static void fitness(List<Cromossomo> populacao) {
		for (Cromossomo cromossomo : populacao) {
			
		 double fitness = Math.pow((cromossomo.genes[0].getX() - cromossomo.genes[1].getX()), 2) + 
			Math.pow((cromossomo.genes[0].getY() - cromossomo.genes[1].getY()), 2);
		 
		 fitness = Math.sqrt(fitness);
			
		 cromossomo.setFitness(fitness);
		}
	}	

	private static void imprimirResultado(List<Cromossomo> p) {
		for (int x = 0; x< p.size(); x++) {
			System.out.println("Geração " + x + " | FITNESS: " + p.get(x).getFitness());
		}
	}
}