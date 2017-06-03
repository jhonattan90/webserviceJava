/*
 * AlunoController.java
 *
 * Classe que implementa os servi�os de manuten��o de alunos
 *
 * � 2016 - Faculdades Opet - Todos os direitos reservados.
 *
 * Hist�rico
 * 14/07/2016 � Vers�o 1.0 - Jos� Augusto � Cria��o do arquivo
 *
 */
package br.edu.opet.controller;

import java.util.List;

import br.edu.opet.dao.ChamadoDAO;
import br.edu.opet.dao.DaoFactory;
import br.edu.opet.dto.ChamadoDTO;
import br.edu.opet.model.Chamado;

public class ChamadoController
{
    // M�todo para criar um aluno
    public static ChamadoDTO cadastrar(Chamado pChamado)
    {
        if (pChamado == null)
            return new ChamadoDTO(false, "Tentativa de inserir um chamado nulo");

        // Chamando a camada de persist�ncia
        ChamadoDAO tDao = DaoFactory.getChamadoDAO();
        Chamado tChamado = tDao.create(pChamado);

        // Verificando se houve erro de cria��o
        if (tChamado == null)
            return new ChamadoDTO(false, "Problemas na grava��o do chamado");

        // Retornando o indicativo de sucesso com o objeto criado
        return new ChamadoDTO(true, "Chamado gravado com sucesso", tChamado);
    }

    // M�todo para recuperar um aluno
    public static ChamadoDTO recuperar(int pId_chamado)
    {
        // Lendo o objeto
    	ChamadoDAO tDao = DaoFactory.getChamadoDAO();
    	Chamado tChamado = tDao.recovery(pId_chamado);

        // Verificando se houve erro de recupera��o
        if (tChamado == null)
            return new ChamadoDTO(false, "Chamado n�o existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto recuperado
        return new ChamadoDTO(true, "Chamado lido com sucesso", tChamado);
    }

    // M�todo para atualizar um aluno
    public static ChamadoDTO atualizar(Chamado pChamado)
    {
        if (pChamado == null)
            return new ChamadoDTO(false, "Tentativa de atualizar um aluno nulo");

        // Chamando a camada de persist�ncia
        ChamadoDAO tDao = DaoFactory.getChamadoDAO();
        Chamado tChamado = tDao.update(pChamado);

        // Verificando se houve erro de atualiza��o
        if (tChamado == null)
            return new ChamadoDTO(false, "Chamado n�o existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto atualizado
        return new ChamadoDTO(true, "Chamado regravado com sucesso", tChamado);
    }

    // M�todo para deletar um aluno
    public static ChamadoDTO remover(int pId_chamado)
    {
        // Removendo o aluno e verificando se houve erro de remo��o
        ChamadoDAO tDao = DaoFactory.getChamadoDAO();
        if (! tDao.delete(pId_chamado))
            return new ChamadoDTO(false, "Chamado n�o existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto removido
        return new ChamadoDTO(true, "Chamado removido com sucesso");
    }

    // M�todo para pesquisar todos os alunos
    public static ChamadoDTO pesquisar()
    {
        // Obtendo a lista de alunos
    	ChamadoDAO tDao = DaoFactory.getChamadoDAO();
        List<Chamado> tLista = tDao.search();

        // Verificando se a lista est� vazia
        if (tLista.isEmpty())
            return new ChamadoDTO(false, "Lista de chamados vazia");

        // Retornando a lista obtida
        return new ChamadoDTO(true, "Lista de chamados recuperada", tLista);
    }

    // M�todo para pesquisar por titulo de  todos os chamados
    public static ChamadoDTO pesquisarPorNome(String pTituloChamado)
    {
        // Caso o nome de pesquisa seja nulo, retorna a lista geral
        if (pTituloChamado == null)
            return pesquisar();

        // Obtendo a lista de alunos
        ChamadoDAO tDao = DaoFactory.getChamadoDAO();
        List<Chamado> tLista = tDao.searchByNome(pTituloChamado);

        // Verificando se a lista est� vazia
        if (tLista.isEmpty())
            return new ChamadoDTO(false, "Nenhum registro encontrado com nome '" + pTituloChamado + "'");

        // Retornando a lista obtida
        return new ChamadoDTO(true, "Lista de chamados recuperada", tLista);
    }   
}
