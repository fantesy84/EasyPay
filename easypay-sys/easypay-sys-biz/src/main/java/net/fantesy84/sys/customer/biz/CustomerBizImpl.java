package net.fantesy84.sys.customer.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import net.fantesy84.exception.EasypayException;
import net.fantesy84.sys.customer.dao.CustomerDAO;
import net.fantesy84.sys.customer.domain.EpSysCust;
@Service
public class CustomerBizImpl implements CustomerBiz {
	@Autowired
	private @Qualifier("customerHibernateDao")CustomerDAO customerDao;
	@Override
	public List<EpSysCust> retrieveByName(EpSysCust cust) throws EasypayException {
		return customerDao.selectByName(cust);
	}

}
