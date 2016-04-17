package net.fantesy84.sys.customer.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import net.fantesy84.commons.bean.Pagination;
import net.fantesy84.exception.EasypayException;
import net.fantesy84.sys.customer.domain.EpSysCust;
import net.fantesy84.sys.jdbc.support.JdbcReadDaoSupport;

@Repository("customerDao")
public class CustomerDAOImpl implements CustomerDAO {
	@Autowired
	private @Qualifier("jdbcReadDaoSupport")JdbcReadDaoSupport jdbcReadDaoSupport;
	@Override
	public Integer insert(EpSysCust cust) throws EasypayException {
		//String sql="INSERT INTO EASY_PAY.EP_SYS_CUST (AUTO_ID,CUST_NAME) VALUES(:autoId,:custName)";
		
		return 0;
	}

	@Override
	public EpSysCust merge(EpSysCust cust) throws EasypayException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EpSysCust getById(Integer id) throws EasypayException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EpSysCust> selectByName(EpSysCust cust) throws EasypayException {
		String sql = "SELECT c.AUTO_ID as autoId,c.CUST_NAME as custName,c.IS_CORP_CUST as isCorpCust FROM EP_SYS_CUST c WHERE c.CUST_NAME=:custName";
		List<EpSysCust> list = jdbcReadDaoSupport.selectForListByParameterObject(sql, cust, EpSysCust.class);
		return list;
	}

	@Override
	public Pagination<EpSysCust> pageByName(EpSysCust cust, int firstResult, int maxResults) throws EasypayException {
		// TODO Auto-generated method stub
		return null;
	}

}
