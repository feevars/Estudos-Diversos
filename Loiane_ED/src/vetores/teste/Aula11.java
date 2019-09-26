package vetores.teste;

import estruturas.Lista;


public class Aula11 {

	public static void main(String[] args) {
		
		
		Lista<String> vetor = new Lista<String>(1);
		
		vetor.adiciona("Elemento");
		
		System.out.println(vetor);
		
		Lista<Contato> contato = new Lista<Contato>(1);
		
		Contato c1 = new Contato("Contato 1", "9999-9999", "contato1@gmail.com");
		Contato c2 = new Contato("Contato 2", "9999-7959", "contato2@gmail.com");
		Contato c3 = new Contato("Contato 3", "9996-6649", "contato3@gmail.com");
	
		System.out.println(contato);
	}

}
