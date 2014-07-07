package dao;

import java.util.List;

import dominio.Entrada;

public interface EntradaDao {
	public void inserir(Entrada entrada);

	public void remover(Entrada entrada);

	public void atualizar(Entrada entrada);

	public Entrada buscaPorCodigo(int cod);

	public List<Entrada> buscaTodos();
	
//	public List<Entrada> entradasEntre(String dataInicial, String dataFinal);
}
