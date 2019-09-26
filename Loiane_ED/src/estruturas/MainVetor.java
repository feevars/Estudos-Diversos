package estruturas;

public class MainVetor {

	public static void main(String[] args) {
		Vetor vetor = new Vetor(10);
		
		vetor.adiciona("B");
		vetor.adiciona("C");
		vetor.adiciona("E");
		vetor.adiciona("F");
		vetor.adiciona("G");
		
		
		System.out.println(vetor); //exibe vetor
		
		vetor.adiciona(0, "A");
		
		System.out.println(vetor); //exibe a terceira posição da busca
		
		vetor.adiciona(3, "D");
		System.out.println(vetor);
				
	}

}
