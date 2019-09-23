package vetores.teste;
import vetores.VetorObjetos;

// aumenta a capacidade do vetor

public class Aula10 {

	public static void main(String[] args) {
		
		VetorObjetos vetor = new VetorObjetos(3);
		
		vetor.adiciona(3);
		vetor.adiciona(4);
		vetor.adiciona(5);
		
		
		System.out.println(vetor); //exibe vetor
		
		vetor.remove(1);
		
		System.out.println(vetor); //exibe a terceira posição da busca
		
		vetor.adiciona(0, "A");
		vetor.adiciona(2, "C");
		System.out.println(vetor);

	}

}
