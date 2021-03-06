package estruturas;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Lista <T> { //<> = diamond, do generics e o <T> de type

	private T[] elementos;
	private int tamanho;

	public Lista (int capacidade) {
		this.elementos = (T[]) new Object[capacidade]; //melhor solu��o
	}

	public Lista (int capacidade, Class<T> tipoClasse) {
		this.elementos = (T[]) Array.newInstance(tipoClasse, capacidade);
		this.tamanho = 0;
	}

	
	public boolean adiciona(T elemento) {
		this.aumentaCapacidade();
		if (this.tamanho < this.elementos.length) {
			this.elementos[this.tamanho] = elemento;
			this.tamanho++;
			return true;
		}
		return false;
	}

	//empurra todos os itens do vetor para a frente para inserir
	//outro no meio do vetor
	// 0 1 2 3 4 5 6    = tamanho � 5
	// B C E F G + +
	public boolean adiciona(int posicao, T elemento) {

		//verifica se a posi��o existe
		if(!(posicao>=0 && posicao < tamanho)) {
			throw new IllegalArgumentException("Posi��o inv�lida!");
		}

		this.aumentaCapacidade();


		//mover para a frente
		for(int i = this.tamanho-1; i>=posicao; i--) {
			this.elementos[i+1] = this.elementos[i];
		}
		this.elementos[posicao] = elemento;
		this.tamanho++;

		return false;
	}

	//Aumenta a capacidade do vetor.
	private void aumentaCapacidade() {
		if (this.tamanho == this.elementos.length) {
			T[] elementosNovos = (T[]) new Object[this.elementos.length*2];
			for (int i = 0; i < this.elementos.length; i++) {
				elementosNovos[i] = this.elementos[i];
			}
			this.elementos = elementosNovos;
		}
	}


	public Object busca(int posicao) {
		if(!(posicao>=0 && posicao < tamanho)) {
			throw new IllegalArgumentException("Posi��o inv�lida!");
		}
		return this.elementos[posicao];
	}

	public int busca(T elemento) {
		for (int i = 0; i < this.tamanho; i++) {
			if (this.elementos[i].equals(elemento)) {
				return i;
			}
		}
		return -1;
	}


	public void remove(int posicao) {
		if(!(posicao>=0 && posicao < tamanho)) {
			throw new IllegalArgumentException("Posi��o inv�lida!");
		}

		for(int i = posicao; i<this.tamanho-1; i++) {
			this.elementos[i] = this.elementos[i+1];
		}
		this.tamanho--;
	}

	public int tamanho() {
		return this.tamanho;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("[");
		for (int i = 0; i < this.tamanho-1; i++) {
			s.append(this.elementos[i]);
			s.append(", ");
		}
		if (this.tamanho>0) {
			s.append(this.elementos[this.tamanho-1]);
		}
		s.append("]");
		return s.toString();
	}





}
