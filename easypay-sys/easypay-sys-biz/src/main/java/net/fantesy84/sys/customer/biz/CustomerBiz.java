package net.fantesy84.sys.customer.biz;

import java.util.List;

import net.fantesy84.commons.bean.Pagination;
import net.fantesy84.exception.EasypayException;
import net.fantesy84.sys.customer.domain.EpSysCust;

public interface CustomerBiz {
	Integer save(EpSysCust cust) throws EasypayException;
	EpSysCust modify(EpSysCust cust) throws EasypayException;
	EpSysCust retrieveById(Integer id) throws EasypayException;
	List<EpSysCust> retrieveByName(EpSysCust cust) throws EasypayException;
	Pagination<EpSysCust> paginationCust(EpSysCust cust, int firstResult, int maxResults) throws EasypayException;
}
