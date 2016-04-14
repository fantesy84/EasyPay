package net.fantesy84.sys.customer.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import net.fantesy84.exception.EasypayException;
import net.fantesy84.sys.customer.domain.EpSysCust;
@Repository("customerHibernateDao")
public class CustomerHibernateDAOImpl implements CustomerDAO {
	@Autowired
	private HibernateTemplate readHibernateTemplate;
	
	@Override
	public int insert(EpSysCust cust) throws EasypayException {
		// TODO Auto-generated method stub
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EpSysCust> selectByName(EpSysCust cust) throws EasypayException {
		DetachedCriteria dc = DetachedCriteria.forClass(EpSysCust.class, "cust");
		dc.add(Restrictions.eq("cust.custName", cust.getCustName()));
		return (List<EpSysCust>) readHibernateTemplate.findByCriteria(dc);
	}

}
