

public class MergeSort {

	public static void main(String[] args) {
		String [] vetor = {"Guilherme", "Luciana", "Matilde", "Arnaldo", "Arnaldo", "Kleber", "Viviane"};

		
		mergeSort(vetor);	
		
		for (int i = 0; i < vetor.length; i++) {
			System.out.println(vetor[i]);
		}
		
	}
	
	private static void mergeSort(String[] vetor) {
		if (vetor.length == 1)
			return;

		int metade = vetor.length / 2;

		String[] esquerda = new String[metade];
		String[] direita = new String[vetor.length - metade];

		for (int i = 0; i < vetor.length; i++) {
			if (i < metade)
				esquerda[i] = vetor[i];
			else
				direita[i - metade] = vetor[i];
		}

		mergeSort(esquerda);
		mergeSort(direita);
		intercala(vetor, esquerda, direita);
	}

	private static void intercala(String[] vetor, String[] esquerda, String[] direita) {
		
		//indices
		int iEsquerda = 0;
		int iDireita = 0;
		
		for (int k = 0; k < vetor.length; k++) {
			if (iEsquerda == esquerda.length) {
				vetor[k] = direita[iDireita];
				iDireita++;
			} else if (iDireita == direita.length) {
				vetor[k] = esquerda[iEsquerda];
				iEsquerda++;
			} else if (esquerda[iEsquerda].compareToIgnoreCase(direita[iDireita]) < 0) {
				vetor[k] = esquerda[iEsquerda];
				iEsquerda++;
			} else {
				vetor[k] = direita[iDireita];
				iDireita++;
			}
		}
	}
}
