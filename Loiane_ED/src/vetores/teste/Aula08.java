package vetores.teste;
import vetores.Vetor;

// aumenta a capacidade do vetor

public class Aula08 {

	public static void main(String[] args) {
		
		Vetor vetor = new Vetor(3);
		
		vetor.adiciona("B");
		vetor.adiciona("C");
		vetor.adiciona("E");
		vetor.adiciona("F");
		
		
		System.out.println(vetor); //exibe vetor
		
		vetor.adiciona(0, "A");
		
		System.out.println(vetor); //exibe a terceira posição da busca
		
		vetor.adiciona(3, "D");
		System.out.println(vetor);

	}

}
