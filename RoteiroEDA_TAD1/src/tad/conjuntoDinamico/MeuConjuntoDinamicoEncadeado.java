package tad.conjuntoDinamico;

import tad.listasEncadeadas.ListaDuplamenteEncadeadaImpl;
import tad.listasEncadeadas.ListaEncadeadaIF;

public class MeuConjuntoDinamicoEncadeado implements ConjuntoDinamicoIF<Integer> {

	//lista encadeada
	ListaEncadeadaIF<Integer> meusDados = new ListaDuplamenteEncadeadaImpl<>();

	@Override
	public void inserir(Integer item) {
		// TODO Auto-generated method stub

	}

	@Override
	public Integer remover(Integer item) throws ConjuntoVazioException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer predecessor(Integer item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer sucessor(Integer item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int tamanho() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Integer buscar(Integer item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer minimum() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer maximum() {
		// TODO Auto-generated method stub
		return null;
	}

}
