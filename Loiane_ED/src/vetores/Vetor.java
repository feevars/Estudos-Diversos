package vetores;

import java.util.Arrays;

public class Vetor {

	private String [] elementos;
	private int tamanho;

	public Vetor (int capacidade) {
		this.elementos = new String[capacidade];
	}

	/*
	 public void adiciona(String elemento) {
		for (int i = 0; i<this.elementos.length; i++) {
			if (this.elementos[i] == null) {
				this.elementos[i] = elemento;
				break;
			}
		}
	} 



	public void adiciona(String elemento) throws Exception {
		if (this.tamanho < this.elementos.length) {
			this.elementos[this.tamanho] = elemento;
		} else {
			throw new Exception ("o Vetor já está cheio.");
		}

	}
	 */

	public boolean adiciona(String elemento) {
		if (this.tamanho < this.elementos.length) {
			this.elementos[this.tamanho] = elemento;
			this.tamanho++;
			return true;
		}
		return false;
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
		
			
		return Arrays.toString(elementos);
	}



}
