package tad.listasEncadeadas;

public class ListaEncadeadaImpl<T extends Comparable<T>> implements ListaEncadeadaIF<T> {

	private NodoListaEncadeada<T> cabeca; // Estratégia usando marcação sentinela
	private NodoListaEncadeada<T> cauda; // Estratégia usando marcação sentinela
	private int tamanho; // Para controlar o tamanho da lista

	public ListaEncadeadaImpl() { // Estratégia usando marcação sentinela
		cabeca = new NodoListaEncadeada<>();
		cauda = new NodoListaEncadeada<>();
		cabeca.setProximo(cauda);
		tamanho = 0; // Inicializa o tamanho
	}

	@Override
	public boolean isEmpty() {
		return tamanho == 0; // Retorna true se a lista estiver vazia
	}

	@Override
	public int size() {
		return tamanho; // Retorna o tamanho da lista
	}

	@Override
	public void insert(T chave) {
		NodoListaEncadeada<T> novoNo = new NodoListaEncadeada<>(chave);
		novoNo.setProximo(cabeca.getProximo());
		cabeca.setProximo(novoNo);
		tamanho++; // Incrementa o tamanho
	}

	@Override
	public NodoListaEncadeada<T> remove(T chave) {
		NodoListaEncadeada<T> corrente = cabeca;
		while (corrente.getProximo() != null) {
			if (corrente.getProximo().getChave().equals(chave)) {
				NodoListaEncadeada<T> toRemove = corrente.getProximo();
				corrente.setProximo(toRemove.getProximo());
				tamanho--; // Decrementa o tamanho
				return toRemove; // Retorna o nó removido
			}
			corrente = corrente.getProximo();
		}
		return null; // Retorna null se não encontrar
	}

	public NodoListaEncadeada<T> getCabeca() {
		return cabeca.getProximo(); // Retorna o primeiro elemento
	}

	public NodoListaEncadeada<T> getCauda() {
		return cauda; // Retorna a cauda
	}

	@Override
	public NodoListaEncadeada<T> search(T chave) {
		// Implementação para buscar um elemento
		NodoListaEncadeada<T> corrente = cabeca.getProximo();
		while (corrente != null) {
			if (corrente.getChave().equals(chave)) {
				return corrente;
			}
			corrente = corrente.getProximo();
		}
		return null; // Retorna null se não encontrar
	}

	@Override
	public T[] toArray(Class<T> clazz) {
		// Implementação para converter a lista em um array
		T[] array = (T[]) java.lang.reflect.Array.newInstance(clazz, tamanho);
		NodoListaEncadeada<T> corrente = cabeca.getProximo();
		for (int i = 0; i < tamanho; i++) {
			array[i] = (T) corrente.getChave();
			corrente = corrente.getProximo();
		}
		return array;
	}

	@Override
	public String imprimeEmOrdem() {
		StringBuilder valores = new StringBuilder();
		NodoListaEncadeada<T> corrente = cabeca.getProximo();

		while (!corrente.equals(cauda)) {
			valores.append(corrente.getChave()).append(", ");
			corrente = corrente.getProximo();
		}

		return valores.length() > 0 ? valores.substring(0, valores.length() - 2) : ""; // Retorna a string sem a vírgula final
	}

	@Override
	public String imprimeInverso() {
		StringBuilder valores = new StringBuilder();
		NodoListaEncadeada<T> corrente = cabeca.getProximo();

		while (!corrente.equals(cauda)) {
			valores.insert(0, corrente.getChave() + ", "); // Adiciona no início
			corrente = corrente.getProximo();
		}

		return valores.length() > 0 ? valores.substring(0, valores.length() - 2) : ""; // Retorna a string sem a vírgula final
	}

	@Override
	public NodoListaEncadeada<T> sucessor(T chave) {
		// Implementação para encontrar o sucessor
		NodoListaEncadeada<T> corrente = cabeca.getProximo();
		while (corrente != null) {
			if (corrente.getChave().equals(chave)) {
				return corrente.getProximo(); // Retorna o próximo nó
			}
			corrente = corrente.getProximo();
		}
		return null; // Retorna null se não encontrar
	}

	@Override
	public NodoListaEncadeada<T> predecessor(T chave) {
		// Implementação para encontrar o predecessor
		NodoListaEncadeada<T> corrente = cabeca;
		while (corrente.getProximo() != null) {
			if (corrente.getProximo().getChave().equals(chave)) {
				return corrente; // Retorna o nó anterior
			}
			corrente = corrente.getProximo();
		}
		return null; // Retorna null se não encontrar
	}

	@Override
	public void insert(T chave, int index) {
		// Implementação para inserir em uma posição específica
		if (index < 0 || index > tamanho) {
			throw new IndexOutOfBoundsException("Índice fora dos limites");
		}
		NodoListaEncadeada<T> novoNo = new NodoListaEncadeada<>(chave);
		NodoListaEncadeada<T> corrente = cabeca;

		for (int i = 0; i < index; i++) {
			corrente = corrente.getProximo();
		}

		novoNo.setProximo(corrente.getProximo());
		corrente.setProximo(novoNo);
		tamanho++; // Incrementa o tamanho
	}
}
