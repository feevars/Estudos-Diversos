package vetores.teste;

import estruturas.Pilha;

public class Aula17 {

	public static void main(String[] args) {
		
		Pilha<Integer> pilha = new Pilha<Integer>();

		System.out.println(pilha.topo());
		System.out.println(pilha);

		pilha.empilha(1);
		pilha.empilha(2);
		pilha.empilha(3);
		
		
		System.out.println(pilha);
		System.out.println("Desempilhando " + pilha.desempilha() +"...");

		System.out.println(pilha.topo());
		System.out.println(pilha);

	}

}
