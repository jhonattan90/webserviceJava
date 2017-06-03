package br.edu.opet.dao;

import java.util.List;

import br.edu.opet.model.Chamado;

public interface ChamadoDAO {
	
	 // Método para criar um chamado na base de dados (INSERT)
    Chamado create(Chamado pChamado);

    // Método para recuperar um chamado da base de dados (SELECT)
    Chamado recovery(int pId_chamado);

    // Método para atualizar um chamado na base de dados (UPDATE)
    Chamado update(Chamado pChamado);

    // Método para deletar um chamado na base de dados (DELETE)
    boolean delete(int pId_chamado);

    // Método para pesquisar todos os alunos da base de dados
    List<Chamado> search();

    // Método para pesquisar por nome todos os chamados da base de dados
    List<Chamado> searchByNome(String pTituloChamado);


}
