package br.edu.opet.dao;

import java.util.List;

import br.edu.opet.model.Chamado;

public interface ChamadoDAO {
	
	 // M�todo para criar um chamado na base de dados (INSERT)
    Chamado create(Chamado pChamado);

    // M�todo para recuperar um chamado da base de dados (SELECT)
    Chamado recovery(int pId_chamado);

    // M�todo para atualizar um chamado na base de dados (UPDATE)
    Chamado update(Chamado pChamado);

    // M�todo para deletar um chamado na base de dados (DELETE)
    boolean delete(int pId_chamado);

    // M�todo para pesquisar todos os alunos da base de dados
    List<Chamado> search();

    // M�todo para pesquisar por nome todos os chamados da base de dados
    List<Chamado> searchByNome(String pTituloChamado);


}
