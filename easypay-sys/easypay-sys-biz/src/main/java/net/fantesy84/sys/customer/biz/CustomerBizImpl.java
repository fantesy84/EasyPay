package net.fantesy84.sys.customer.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import net.fantesy84.commons.bean.Pagination;
import net.fantesy84.exception.EasypayException;
import net.fantesy84.sys.customer.dao.CustomerDAO;
import net.fantesy84.sys.customer.domain.EpSysCust;
@Service
public class CustomerBizImpl implements CustomerBiz {
	@Autowired
	private @Qualifier("customerHibernateDao")CustomerDAO customerDao;
	
	@Transactional(propagation=Propagation.REQUIRED,noRollbackFor={EasypayException.class})
	@Override
	public Integer save(EpSysCust cust) throws EasypayException {
		return customerDao.insert(cust);
	}

	@Transactional(propagation=Propagation.REQUIRED,noRollbackFor={EasypayException.class})
	@Override
	public EpSysCust modify(EpSysCust cust) throws EasypayException {
		return customerDao.merge(cust);
	}

	@Override
	public EpSysCust retrieveById(Integer id) throws EasypayException {
		// TODO Auto-generated method stub
		return customerDao.getById(id);
	}

	@Transactional(isolation=Isolation.READ_COMMITTED)
	@Override
	public List<EpSysCust> retrieveByName(EpSysCust cust) throws EasypayException {
		return customerDao.selectByName(cust);
	}

	@Override
	public Pagination<EpSysCust> paginationCust(EpSysCust cust, int firstResult, int maxResults)
			throws EasypayException {
		return customerDao.pageByName(cust, firstResult, maxResults);
	}

}
