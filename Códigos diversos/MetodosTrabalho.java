import model.Convidado;

public class MetodosTrabalho {
	public static void mergeSortNome(Convidado[] vetorConvidados) {

		if (vetorConvidados.length == 1)
			return;

		int metade = vetorConvidados.length / 2;

		Convidado[] esquerda = new Convidado[metade];
		Convidado[] direita = new Convidado[vetorConvidados.length - metade];

		for (int i = 0; i < vetorConvidados.length; i++) {
			if (i < metade)
				esquerda[i] = vetorConvidados[i];
			else
				direita[i - metade] = vetorConvidados[i];
		}

		mergeSortNome(esquerda);
		mergeSortNome(direita);
		intercalaNome(vetorConvidados, esquerda, direita);

		for (int i = 0; i < vetorConvidados.length; i++) {
			System.out.println(vetorConvidados.toString());
		}

	}

	public static void intercalaNome(Convidado[] vetorConvidados, Convidado[] esquerda, Convidado[] direita) {
		int iEsquerda = 0, iDireita = 0;

		for (int i = 0; i < vetorConvidados.length - 1; i++) {
			if (iEsquerda == esquerda.length) {
				vetorConvidados[i] = direita[iDireita];
				iDireita++;
			} else if (iDireita == direita.length) {
				vetorConvidados[i] = esquerda[iEsquerda];
				iEsquerda++;

			} else if (esquerda[iEsquerda].getNome().compareToIgnoreCase(direita[iDireita].getNome()) > 0) {
				vetorConvidados[i] = esquerda[iEsquerda];
				iEsquerda++;
			} else {
				vetorConvidados[i] = direita[iDireita];
				iDireita++;
			}
		}
	}
}
