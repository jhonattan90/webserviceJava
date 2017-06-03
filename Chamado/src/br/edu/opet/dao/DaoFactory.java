package br.edu.opet.dao;

import br.edu.opet.dao.hibernate.ChamadoHibernateDAO;

public class DaoFactory
{
    public static ChamadoDAO getChamadoDAO()
    {
		return new ChamadoHibernateDAO();
    }

   
}
