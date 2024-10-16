package tad.conjuntoDinamico;

public class MeuConjuntoDinamico implements ConjuntoDinamicoIF<Integer> {

	private Integer[] meusDados = new Integer[10];
	private int posInsercao = 0;
	
	@Override
	public void inserir(Integer item) {
		if (arrayEstaCheio()) {
			aumentarArray();
		}
		meusDados[posInsercao] = item;
		posInsercao++;
	}
	private boolean arrayEstaCheio() {
        return this.posInsercao == this.meusDados.length;
    }

	private void aumentarArray() {
		Integer[] copia = new Integer[this.meusDados.length * 2];
		for(int index = 0; index<this.meusDados.length; index++){
			copia[index] = this.meusDados[index];
		}

		this.meusDados = copia;
	}

	@Override
	public Integer remover(Integer item) throws ConjuntoVazioException{
		Integer retorno = null;
		if(this.tamanho() == 0){
			throw new ConjuntoVazioException();
		} else {
			for (int index = 0; index < this.posInsercao; index++) {
				if (this.meusDados[index].equals(item)) {
					for (int iterador = index; iterador < this.posInsercao - 1; iterador++) {
						this.meusDados[iterador] = this.meusDados[iterador + 1];
					}
					this.meusDados[this.posInsercao - 1] = null;
					this.posInsercao--;
					retorno = item;
				}
			}
		}
		return retorno;
	}

	@Override
	public Integer predecessor(Integer item) throws ConjuntoVazioException {
		Integer retorno = null;
		if (this.tamanho() == 0) {
			throw new ConjuntoVazioException();
		} else {
			for (int index = 0; index < this.posInsercao; index++) {
				if (this.meusDados[index].equals(item)) {
					if (index > 0){
						retorno = this.meusDados[index-1];
					}
					break;
				}
				if (index==this.posInsercao-1 && retorno==null){
					throw new ConjuntoVazioException();
				}
			}
		}
		return retorno;
    }

	@Override
	public Integer sucessor(Integer item) throws ConjuntoVazioException {
		Integer retorno = null;
		if (this.tamanho() == 0) {
			throw new ConjuntoVazioException();
		} else {
			for (int index = 0; index < this.posInsercao; index++) {
				if (this.meusDados[index].equals(item)) {
					if (index < this.posInsercao-1){
						retorno = this.meusDados[index+1];
					}
					break;
				}
				if (index==this.posInsercao-1 && retorno==null){
					throw new ConjuntoVazioException();
				}
			}
		}
		return retorno;
	}

	@Override
	public int tamanho() {
		int cont = 0;
		if(this.meusDados != null){
			for(Integer dado : this.meusDados){
				if(dado != null){
					cont++;
				}
			}
		}
		return cont;
	}

	@Override
	public Integer buscar(Integer item) {
		Integer retorno = null;
		for(int index = 0; index<this.posInsercao; index ++){
			if(this.meusDados[index].equals(item)){
				retorno = item;
			}
		}
		return retorno;
	}

	@Override
	public Integer minimum() throws ConjuntoVazioException {
		Integer retorno = null;
		if (this.tamanho() == 0){
			throw new ConjuntoVazioException();
		} else {
			Integer min = this.meusDados[0];
			for (int index = 1; index < this.posInsercao; index++) {
				if (this.meusDados[index] < min) {
					min = this.meusDados[index];
				}
			}
			retorno = min;
		}
        return retorno;
	}

	@Override
	public Integer maximum() throws ConjuntoVazioException {
		Integer retorno = null;
		if (this.tamanho() == 0){
			throw new ConjuntoVazioException();
		} else {
			Integer max = this.meusDados[0];
			for (int index = 1; index < this.posInsercao; index++) {
				if (this.meusDados[index] > max) {
					max = this.meusDados[index];
				}
			}
			retorno = max;
		}
		return retorno;
	}

}
