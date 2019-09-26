package vetores.teste;
import estruturas.Vetor;

// aumenta a capacidade do vetor

public class Aula09 {

	public static void main(String[] args) {
		
		Vetor vetor = new Vetor(3);
		
		vetor.adiciona("B");
		vetor.adiciona("G");
		vetor.adiciona("D");
		vetor.adiciona("E");
		vetor.adiciona("F");
		
		System.out.println(vetor); //exibe vetor
		
		vetor.remove(1);
		
		System.out.println(vetor); //exibe a terceira posição da busca
		
		vetor.adiciona(0, "A");
		vetor.adiciona(2, "C");
		System.out.println(vetor);

	}

}
