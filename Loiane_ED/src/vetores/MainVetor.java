package vetores;

public class MainVetor {

	public static void main(String[] args) {
		Vetor vetor = new Vetor(10);
		
		vetor.adiciona("Atualmente,");
		vetor.adiciona("a tua mente");
		vetor.adiciona("atua ou mente?");
		
		System.out.println(vetor.tamanho());
		
		System.out.println(vetor);
	}

}
