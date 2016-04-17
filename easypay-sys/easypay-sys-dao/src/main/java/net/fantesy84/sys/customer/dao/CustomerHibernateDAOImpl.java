package net.fantesy84.sys.customer.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.fantesy84.commons.bean.Pagination;
import net.fantesy84.exception.EasypayException;
import net.fantesy84.sys.customer.domain.EpSysCust;
import net.fantesy84.sys.hibernate5.support.HibernateReadDaoSupport;
import net.fantesy84.sys.hibernate5.support.HibernateWriteDaoSupport;


@Repository("customerHibernateDao")
public class CustomerHibernateDAOImpl implements CustomerDAO {
	@Autowired
	private HibernateReadDaoSupport hibernateReadDaoSupport;
	@Autowired
	private HibernateWriteDaoSupport hibernateWriteDaoSupport;

	@Override
	public Integer insert(EpSysCust cust) throws EasypayException {
		return (Integer) hibernateWriteDaoSupport.insert(cust);
	}

	@Override
	public EpSysCust merge(EpSysCust cust) throws EasypayException {
		return hibernateWriteDaoSupport.merge(cust);
	}

	@Override
	public EpSysCust getById(Integer id) throws EasypayException {
		return hibernateReadDaoSupport.selectByPrimaryKey(id, EpSysCust.class, LockMode.PESSIMISTIC_WRITE);
	}

	@Override
	public List<EpSysCust> selectByName(EpSysCust cust) throws EasypayException {
		DetachedCriteria dc = DetachedCriteria.forClass(EpSysCust.class, "cust");
		dc.add(Restrictions.like("cust.custName", cust.getCustName(), MatchMode.ANYWHERE));
		return hibernateReadDaoSupport.selectByDetachedCriteria(dc, EpSysCust.class);
	}

	@Override
	public Pagination<EpSysCust> pageByName(EpSysCust cust, int firstResult, int maxResults) throws EasypayException {
		DetachedCriteria dc = DetachedCriteria.forClass(EpSysCust.class, "cust");
		dc.add(Restrictions.like("cust.custName", cust.getCustName(), MatchMode.ANYWHERE));
		return hibernateReadDaoSupport.paginationByDetachedCriteria(dc, EpSysCust.class, firstResult, maxResults);
	}

}
