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
		return posInsercao == meusDados.length;
	}

	private void aumentarArray() {
		Integer[] arrayMaior = new Integer[meusDados.length * 2];
		System.arraycopy(meusDados, 0, arrayMaior, 0, meusDados.length);
		meusDados = arrayMaior;
	}

	@Override
	public Integer remover(Integer item) throws ConjuntoVazioException {
		if (tamanho() == 0) {
			throw new ConjuntoVazioException("Conjunto vazio");
		}

		for (int i = 0; i < posInsercao; i++) {
			if (meusDados[i].equals(item)) {
				Integer removido = meusDados[i];
				// Deslocar elementos à esquerda
				for (int j = i; j < posInsercao - 1; j++) {
					meusDados[j] = meusDados[j + 1];
				}
				meusDados[--posInsercao] = null;
				return removido;
			}
		}
		return null;
	}

	public Integer predecessor(Integer item) {

		Integer pred = null;
		for (int i = 0; i < posInsercao; i++) {
			if (meusDados[i] < item) {
				if (pred == null || meusDados[i] > pred) {
					pred = meusDados[i];
				}
			}
		}
		return pred;
	}

	public Integer sucessor(Integer item) throws Exception {
		if (tamanho() == 0) {
			throw new Exception("Conjunto vazio");
		}
		for (int i = 0; i < posInsercao - 1; i++) {
			if (meusDados[i] != null && meusDados[i].equals(item)) {
				return meusDados[i + 1];
			}
		}

		return null;
	}




	public int tamanho() {
		return posInsercao;
	}

	public Integer buscar(Integer item) {
		for (int i = 0; i < posInsercao; i++) {
			if (meusDados[i].equals(item)) {
				return meusDados[i];
			}
		}
		return null;
	}

	public Integer minimum() throws ConjuntoVazioException {
		if (tamanho() == 0) {
			throw new ConjuntoVazioException("Conjunto vazio"); 		}

		Integer min = meusDados[0];
		for (int i = 1; i < posInsercao; i++) {
			if (meusDados[i] < min) {
				min = meusDados[i];
			}
		}
		return min;
	}

	public Integer maximum() throws ConjuntoVazioException {
		if (tamanho() == 0) {
			throw new ConjuntoVazioException("Conjunto vazio");
		}

		Integer max = meusDados[0];
		for (int i = 1; i < posInsercao; i++) {
			if (meusDados[i] > max) {
				max = meusDados[i];
			}
		}
		return max;
	}
}