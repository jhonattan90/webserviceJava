/*
 * AlunoController.java
 *
 * Classe que implementa os serviços de manutenção de alunos
 *
 * © 2016 - Faculdades Opet - Todos os direitos reservados.
 *
 * Histórico
 * 14/07/2016 – Versão 1.0 - José Augusto – Criação do arquivo
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
    // Método para criar um aluno
    public static ChamadoDTO cadastrar(Chamado pChamado)
    {
        if (pChamado == null)
            return new ChamadoDTO(false, "Tentativa de inserir um chamado nulo");

        // Chamando a camada de persistência
        ChamadoDAO tDao = DaoFactory.getChamadoDAO();
        Chamado tChamado = tDao.create(pChamado);

        // Verificando se houve erro de criação
        if (tChamado == null)
            return new ChamadoDTO(false, "Problemas na gravação do chamado");

        // Retornando o indicativo de sucesso com o objeto criado
        return new ChamadoDTO(true, "Chamado gravado com sucesso", tChamado);
    }

    // Método para recuperar um aluno
    public static ChamadoDTO recuperar(int pId_chamado)
    {
        // Lendo o objeto
    	ChamadoDAO tDao = DaoFactory.getChamadoDAO();
    	Chamado tChamado = tDao.recovery(pId_chamado);

        // Verificando se houve erro de recuperação
        if (tChamado == null)
            return new ChamadoDTO(false, "Chamado não existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto recuperado
        return new ChamadoDTO(true, "Chamado lido com sucesso", tChamado);
    }

    // Método para atualizar um aluno
    public static ChamadoDTO atualizar(Chamado pChamado)
    {
        if (pChamado == null)
            return new ChamadoDTO(false, "Tentativa de atualizar um aluno nulo");

        // Chamando a camada de persistência
        ChamadoDAO tDao = DaoFactory.getChamadoDAO();
        Chamado tChamado = tDao.update(pChamado);

        // Verificando se houve erro de atualização
        if (tChamado == null)
            return new ChamadoDTO(false, "Chamado não existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto atualizado
        return new ChamadoDTO(true, "Chamado regravado com sucesso", tChamado);
    }

    // Método para deletar um aluno
    public static ChamadoDTO remover(int pId_chamado)
    {
        // Removendo o aluno e verificando se houve erro de remoção
        ChamadoDAO tDao = DaoFactory.getChamadoDAO();
        if (! tDao.delete(pId_chamado))
            return new ChamadoDTO(false, "Chamado não existe no cadastro");

        // Retornando o indicativo de sucesso com o objeto removido
        return new ChamadoDTO(true, "Chamado removido com sucesso");
    }

    // Método para pesquisar todos os alunos
    public static ChamadoDTO pesquisar()
    {
        // Obtendo a lista de alunos
    	ChamadoDAO tDao = DaoFactory.getChamadoDAO();
        List<Chamado> tLista = tDao.search();

        // Verificando se a lista está vazia
        if (tLista.isEmpty())
            return new ChamadoDTO(false, "Lista de chamados vazia");

        // Retornando a lista obtida
        return new ChamadoDTO(true, "Lista de chamados recuperada", tLista);
    }

    // Método para pesquisar por titulo de  todos os chamados
    public static ChamadoDTO pesquisarPorNome(String pTituloChamado)
    {
        // Caso o nome de pesquisa seja nulo, retorna a lista geral
        if (pTituloChamado == null)
            return pesquisar();

        // Obtendo a lista de alunos
        ChamadoDAO tDao = DaoFactory.getChamadoDAO();
        List<Chamado> tLista = tDao.searchByNome(pTituloChamado);

        // Verificando se a lista está vazia
        if (tLista.isEmpty())
            return new ChamadoDTO(false, "Nenhum registro encontrado com nome '" + pTituloChamado + "'");

        // Retornando a lista obtida
        return new ChamadoDTO(true, "Lista de chamados recuperada", tLista);
    }   
}
