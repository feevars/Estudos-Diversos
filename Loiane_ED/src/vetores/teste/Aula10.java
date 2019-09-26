package vetores.teste;
import estruturas.VetorObjetos;

// aumenta a capacidade do vetor

public class Aula10 {

	public static void main(String[] args) {
		
		VetorObjetos vetor = new VetorObjetos(3);
		
		Contato c1 = new Contato("Contato 1", "9999-9999", "contato1@gmail.com");
		Contato c2 = new Contato("Contato 2", "9999-7959", "contato2@gmail.com");
		Contato c3 = new Contato("Contato 3", "9996-6649", "contato3@gmail.com");
		Contato c4 = new Contato("Contato 4", "9666-2649", "contato4@gmail.com");
		
		vetor.adiciona(c1); //int
		vetor.adiciona(c2); //String
		vetor.adiciona(c3); //double
		
		System.out.println("Tamanho = " + vetor.tamanho()); 
		System.out.println(vetor); 
		
		int pos = vetor.busca(c4);
		if (pos > -1) {
			System.out.println(c4 + " | Elemento existe no vetor.");
		} else {
			System.out.println("Elemento não existe no vetor.");
		}
		
	}

}
