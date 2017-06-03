package br.edu.opet.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import br.edu.opet.dao.ChamadoDAO;
import br.edu.opet.hibernate.HibernateUtil;
import br.edu.opet.model.Chamado;
import br.edu.opet.util.ExceptionUtil;

public class ChamadoHibernateDAO implements ChamadoDAO {

	@Override
	public Chamado create(Chamado pChamado) {
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			tSessao.save(pChamado);
			tSessao.flush();

			return pChamado;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept,"Erro no método de criação do chamado");
		}
		return null;
	}

	@Override
	public Chamado recovery(int pMatricula) {
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			Chamado tChamado = (Chamado) tSessao.get(Chamado.class, pMatricula);
			return tChamado;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept,
					"Erro no método de recuperação do aluno");
		}
		return null;
	}

	@Override
	public Chamado update(Chamado pChamado) {
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			tSessao.merge(pChamado);
			tSessao.flush();

			return pChamado;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept,
					"Erro no método de atualização do aluno");
		}
		return null;
	}

	@Override
	public boolean delete(int pMatricula) {
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			tSessao.delete(tSessao.get(Chamado.class, pMatricula));
			tSessao.flush();

			return true;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept,
					"Erro no método de atualização do aluno");
		}

		return false;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Chamado> search() {

		List<Chamado> tLista = new ArrayList<>();

		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			Query tQuery = tSessao.createQuery("FROM chamado");

			tLista = tQuery.list();
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept,
					"Erro no método de recuperação da lista de chamado");
		}
		return tLista;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Chamado> searchByNome(String pNome) {
		String tNomePesquisa = "%" + pNome + "%";

		List<Chamado> tLista = new ArrayList<>();

		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			Criteria tCriterio = tSessao.createCriteria(Chamado.class).add(
					Restrictions.like("nome", tNomePesquisa).ignoreCase());

			tLista = tCriterio.list();
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept,
					"Erro no método de recuperação da lista de alunos");
		}

		return tLista;
	}
}